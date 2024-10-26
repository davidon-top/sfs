package top.davidon.sfs.renderers

import org.scalajs.dom
import top.davidon.sfs.dom.keys.{EventProp, HtmlProp}
import top.davidon.sfs.dom.mods.{EventMod, Modifier}
import top.davidon.sfs.dom.plain.PlainValue
import top.davidon.sfs.dom.reactive.ReactiveValue
import top.davidon.sfs.dom.{Element, Renderer, Value}

import scala.scalajs.js

class ClientSideRenderer(val root: dom.Element) extends Renderer[Unit] {

  override def render(
      elements: Element[dom.Element]*
  ): Unit = {
    elements.foreach(renderElement(root, _))
  }

  def valueFunc[F](
      element: dom.Element,
      children: Seq[Element[?] | Value[?, String]]
  ): Unit = {
    children.foreach {
      case e: Element[?] =>
        renderElement(element, e)
      case s: Value[?, String] => element.append(s())
    }
  }

  def modifierFunc(
      el: dom.Element,
      mod: Modifier[?, ?]
  ): Unit = {
    mod.key match {
      case _: HtmlProp[?, ?] =>
        el.asInstanceOf[js.Dynamic]
          .updateDynamic(mod.key.name)(mod.value.asInstanceOf[js.Any])
      case _: EventProp[?] =>
      case _               => el.setAttribute(mod.key.name, mod.value.toString)
    }
  }

  private def renderElement(
      parent: dom.Element,
      element: Element[dom.Element]
  ): Unit = {
    val el = dom.document.createElement(element.tag.name)

    element.mods.foreach(m =>
      modifierFunc(el, m)
      m.key match {
        case _: HtmlProp[?, ?] =>
          if m.value.isInstanceOf[ReactiveValue[?, ?]] then {
            m.value
              .asInstanceOf[ReactiveValue[?, ?]]
              .reactiveValue
              .subscribe(value => { modifierFunc(el, m) })
          }
        case _: EventProp[?] =>
          el.addEventListener(
            m.key.name,
            m.value.value.asInstanceOf[EventMod[?]].value
          )
        case _ =>
          if m.value.isInstanceOf[ReactiveValue[?, ?]] then {
            m.value
              .asInstanceOf[ReactiveValue[?, ?]]
              .reactiveValue
              .subscribe(value => { modifierFunc(el, m) })
          }
      }
    )

    valueFunc(el, element.children)
    element.children.foreach { case r: ReactiveValue[?, String] =>
      r.reactiveValue.subscribe(value => { valueFunc(el, element.children) })
    }

    parent.append(el)
  }
}

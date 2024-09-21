package top.davidon.sfs.renderers

import org.scalajs.dom
import top.davidon.sfs.dom.keys.{EventProp, HtmlProp}
import top.davidon.sfs.dom.{Element, Renderer, Value}

import scala.scalajs.js

class ClientSideRenderer(val root: dom.Element)
    extends Renderer[Unit]
    with ReactiveRenderer {

  override def render(
      elements: Element[dom.Element]*
  ): Unit = {
    elements.foreach(renderElement(root, _))
  }

  override def valueFunc[F](element: dom.Element, value: F): Unit = {}

  override def modifierFunc[F, T](
      modifier: top.davidon.sfs.dom.Modifier[F, T],
      value: F
  ): Unit = {}

  private def renderElement(
      parent: dom.Element,
      element: Element[dom.Element]
  ): Unit = {
    val el = dom.document.createElement(element.tag.name)
    element.mods.foreach(m =>
      m.key match {
        case _: HtmlProp[?, ?] =>
          el.asInstanceOf[js.Dynamic]
            .updateDynamic(m.key.name)(m.value().asInstanceOf[js.Any])
        case _: EventProp[?] => ???
        case _ =>
          el.setAttribute(m.key.name, m.value().asInstanceOf[String])
      }
    )
    element.children.foreach {
      case e: Element[dom.Element] => renderElement(el, e)
      case s: Value[?, String]     => el.append(s())
    }
    parent.append(el)
  }
}

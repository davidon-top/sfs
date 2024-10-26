package top.davidon.sfs.renderers

import org.scalajs.dom
import top.davidon.sfs.dom.{Element, Renderer, Value}

class StringRenderer() extends Renderer[String] {
  override def render(
      elements: Element[dom.Element]*
  ): String = {
    elements.map(renderElement(_)).mkString("")
  }

  private def renderElement(e: Element[dom.Element]): String = {
    val modsStr =
      e.mods.map(m => s" ${m.key.name}=\"${m.value.toString}\"").mkString("")
    val bodyStr = e.children
      .map {
        case c: Value[?, String] =>
          c.toString
        case e: Element[?] =>
          renderElement(e)
      }
      .mkString(" ")
    s"<${e.tag.name}$modsStr>$bodyStr${
        if e.tag.void then "" else s"</${e.tag.name}>"
      }"
  }
}

package top.davidon.sfs.renderers

import org.scalajs.dom
import top.davidon.sfs.dom.SFS.given
import top.davidon.sfs.dom.{Element, Renderer, Value}

class StringRenderer extends Renderer[String] {
  override def render(
      elements: Element[dom.Element]*
  ): String = {
    elements.map(renderElement(_)).mkString("")
  }

  private def renderElement(e: Element[dom.Element]): String = {
    val modsStr =
      e.mods.map(m => s" ${m.key.name}=\"${m.value()}\"").mkString("")
    val bodyStr = e.children
      .map {
        case e: Element[?] =>
          renderElement(e)
        case c: Value[?, String] =>
          c()
        case _ =>
          throw Exception(
            "attempted to parse child that was neither an Element or Value, this should never happen if it did its a bug"
          )
      }
      .mkString(" ")
    s"<${e.tag.name}$modsStr>$bodyStr${
        if e.tag.void then "" else s"</${e.tag.name}>"
      }"
  }
}

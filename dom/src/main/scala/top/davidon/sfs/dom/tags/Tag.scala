package top.davidon.sfs.dom.tags

import org.scalajs.dom
import top.davidon.sfs.dom.{Element, Modifier, Value}

trait Tag[+Ref <: dom.Element] {
  val name: String
  val void: Boolean

  def apply(
      modifiers: Modifier[?, ?]*
  )(
      values: Element[?] | Value[?, String]*
  ): Element[Ref] = {
    Element[Ref](this, modifiers, values.toSeq)
  }
}

package top.davidon.sfs.dom

import org.scalajs.dom
import top.davidon.sfs.dom.mods.Modifier

trait ReactiveRenderer {
  def valueFunc[F](element: dom.Element, value: F): Unit
  def modifierFunc[F, T](modifier: Modifier[F, T], value: F): Unit
}

package top.davidon.sfs.dom

import org.scalajs.dom

trait Renderer[T] {
  def render(elements: Element[dom.Element]*): T
}

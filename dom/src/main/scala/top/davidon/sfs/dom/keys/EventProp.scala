package top.davidon.sfs.dom.keys

import org.scalajs.dom
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.codecs.{EmptyCodec, StringAsIsCodec}
import top.davidon.sfs.dom.mods.{EventMod, Modifier}
import top.davidon.sfs.dom.plain.{PlainModifier, PlainValue}

class EventProp[E <: dom.Event](override val name: String) extends Key {

  /** Don't use with StringRenderer and ssr off/false
    * @param value
    * @return
    */
  def :=(value: E => Unit): Modifier[Any, Unit] = {
    PlainModifier(this, PlainValue(EventMod(this, value), EmptyCodec))
  }

  /** Only use with StringRenderer and ssr on/true
    * @param value
    * @return
    */
  def :=(value: String): Modifier[String, String] = {
    PlainModifier(this, PlainValue(value, StringAsIsCodec))
  }
}

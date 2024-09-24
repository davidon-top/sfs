package top.davidon.sfs.dom.keys

import org.scalajs.dom
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.codecs.{EmptyCodec, StringAsIsCodec}
import top.davidon.sfs.dom.mods.{EventMod, Modifier}
import top.davidon.sfs.dom.plain.PlainValue
import top.davidon.sfs.dom.reactive.TriggerableValue

class EventProp[E <: dom.Event](override val name: String) extends Key {

  /** Don't use with StringRenderer and ssr off/false
    * @param value
    * @return
    */
  def :=(value: E => Unit): Modifier[Unit] = {
    Modifier(this, PlainValue(EventMod(this, value), EmptyCodec()))
  }

  /** Don't use with StringRenderer and ssr off/false
    * @param value
    * @return
    */
  def :=(value: TriggerableValue[E]): Modifier[Unit] = {
    Modifier(this, PlainValue(EventMod(this, value.trigger), EmptyCodec()))
  }

  /** Only use with StringRenderer and ssr off/false
    * @param value
    * @return
    */
  def :=(value: String): Modifier[String] = {
    Modifier(this, PlainValue(value, StringAsIsCodec))
  }
}

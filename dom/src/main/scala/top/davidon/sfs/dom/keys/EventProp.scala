package top.davidon.sfs.dom.keys

import org.scalajs.dom
import top.davidon.sfs.dom.codecs.{EmptyCodec, StringAsIsCodec}
import top.davidon.sfs.dom.mods.{EventMod, Modifier}
import top.davidon.sfs.dom.{TriggerableValue, Value}

class EventProp[E <: dom.Event](override val name: String) extends Key {

  /** Don't use with StringRenderer and ssr off/false
    * @param value
    * @return
    */
  def :=(value: E => Unit): Modifier[EventMod[E], Unit] = {
    Modifier(this, Value(EventMod(this, value), EmptyCodec()))
  }

  /** Don't use with StringRenderer and ssr off/false
    * @param value
    * @return
    */
  def :=(value: TriggerableValue[E]): Modifier[EventMod[E], Unit] = {
    Modifier(this, Value(EventMod(this, value.trigger), EmptyCodec()))
  }

  /** Only use with StringRenderer and ssr off/false
    * @param value
    * @return
    */
  def :=(value: String): Modifier[String, String] = {
    Modifier(this, Value(value, StringAsIsCodec))
  }
}

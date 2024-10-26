package top.davidon.sfs.dom.keys

import rescala.default.Signal
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.mods.Modifier
import top.davidon.sfs.dom.plain.{PlainModifier, PlainValue}
import top.davidon.sfs.dom.reactive.{
  ReactiveModifier,
  ReactiveValue
}

class HtmlAttr[V](
    override val name: String,
    val codec: Codec[V, String]
) extends Key {
  @inline def apply(value: V | Signal[V]): Modifier[V, String] = {
    this := value
  }

  def :=(value: V | Signal[V]): Modifier[V, String] = {
    Modifier.fromVorObservableV(this, value, codec)
  }
}

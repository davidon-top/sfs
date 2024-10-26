package top.davidon.sfs.dom.mods

import rescala.default.Signal
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.keys.Key
import top.davidon.sfs.dom.plain.{PlainModifier, PlainValue}
import top.davidon.sfs.dom.reactive.{
  ReactiveModifier,
  ReactiveValue
}

class Modifier[F, T] protected (
    val key: Key,
    val value: Value[F, T]
) {}

object Modifier {
  def fromVorObservableV[F, T](
      key: Key,
      value: F | Signal[F],
      codec: Codec[F, T]
  ): Modifier[F, T] = {
    value match {
      case _: F =>
        PlainModifier(key, PlainValue(value.asInstanceOf[F], codec))
      case _: Signal[F] =>
        ReactiveModifier(
          key,
          ReactiveValue(value.asInstanceOf[Signal[F]], codec)
        )
    }
  }
}

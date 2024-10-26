package top.davidon.sfs.dom.keys
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.mods.Modifier
import top.davidon.sfs.dom.plain.{PlainModifier, PlainValue}
import top.davidon.sfs.dom.reactive.{
  Observable,
  ReactiveModifier,
  ReactiveValue
}

class AriaAttr[V](
    suffix: String,
    val codec: Codec[V, String]
) extends Key {
  override val name: String = "aria-" + suffix

  @inline def apply(value: V | Observable[V]): Modifier[V, String] = {
    this := value
  }

  def :=(value: V | Observable[V]): Modifier[V, String] = {
    Modifier.fromVorObservableV(this, value, codec)
  }
}

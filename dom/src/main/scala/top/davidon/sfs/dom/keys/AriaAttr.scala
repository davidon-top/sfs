package top.davidon.sfs.dom.keys
import top.davidon.sfs.dom.codecs.{Codec, StringCodec}
import top.davidon.sfs.dom.{Modifier, Value}

class AriaAttr[V](
    suffix: String,
    val codec: StringCodec[V]
) extends Key {
  override val name: String = "aria-" + suffix

  @inline def apply(value: V): Modifier[V, String] = {
    this := value
  }

  def :=(value: V): Modifier[V, String] = {
    Modifier(this, Value(value, codec))
  }
}

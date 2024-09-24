package top.davidon.sfs.dom.keys
import top.davidon.sfs.dom.codecs.{Codec, StringCodec}
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.mods.Modifier
import top.davidon.sfs.dom.plain.PlainValue

class AriaAttr[V](
    suffix: String,
    val codec: StringCodec[V]
) extends Key {
  override val name: String = "aria-" + suffix

  @inline def apply(value: V): Modifier[String] = {
    this := value
  }

  def :=(value: V): Modifier[String] = {
    Modifier(this, PlainValue(value, codec))
  }
}

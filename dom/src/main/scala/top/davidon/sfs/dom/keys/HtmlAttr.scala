package top.davidon.sfs.dom.keys

import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.{Modifier, Value}

class HtmlAttr[V](
    override val name: String,
    val codec: Codec[V, String]
) extends Key {
  @inline def apply(value: V): Modifier[V, String] = {
    this := value
  }

  def :=(value: V): Modifier[V, String] = {
    Modifier(this, Value(value, codec))
  }
}

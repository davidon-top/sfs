package top.davidon.sfs.dom.keys
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.mods.Modifier

class HtmlProp[V, DomV](
    override val name: String,
    val codec: Codec[V, DomV]
) extends Key {
  @inline def apply(value: V): Modifier[V, DomV] = {
    this := value
  }

  def :=(value: V): Modifier[V, DomV] = {
    Modifier(this, Value(value, codec))
  }
}

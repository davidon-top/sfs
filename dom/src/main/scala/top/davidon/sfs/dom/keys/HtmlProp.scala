package top.davidon.sfs.dom.keys
import rescala.default.Signal
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.mods.Modifier
import top.davidon.sfs.dom.plain.PlainValue

class HtmlProp[V, DomV](
    override val name: String,
    val codec: Codec[V, DomV]
) extends Key {
  @inline def apply(value: V | Signal[V]): Modifier[V, DomV] = {
    this := value
  }

  def :=(value: V | Signal[V]): Modifier[V, DomV] = {
    Modifier.fromVorObservableV(this, value, codec)
  }
}

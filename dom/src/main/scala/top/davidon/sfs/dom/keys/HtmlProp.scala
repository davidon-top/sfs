package top.davidon.sfs.dom.keys
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.mods.Modifier
import top.davidon.sfs.dom.plain.PlainValue
import top.davidon.sfs.dom.reactive.Observable

class HtmlProp[V, DomV](
    override val name: String,
    val codec: Codec[V, DomV]
) extends Key {
  @inline def apply(value: V | Observable[V]): Modifier[V, DomV] = {
    this := value
  }

  def :=(value: V | Observable[V]): Modifier[V, DomV] = {
    Modifier.fromVorObservableV(this, value, codec)
  }
}

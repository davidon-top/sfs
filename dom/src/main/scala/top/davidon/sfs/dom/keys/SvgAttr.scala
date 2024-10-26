package top.davidon.sfs.dom.keys
import rescala.default.Signal
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.mods.Modifier

class SvgAttr[V](
    val localName: String,
    val codec: Codec[V, String],
    val namespacePrefix: Option[String]
) extends Key {
  override val name: String =
    namespacePrefix.map(_ + ":" + localName).getOrElse(localName)

  val namespaceUri: Option[String] = namespacePrefix.map(SvgAttr.namespaceUri)

  @inline def apply(value: V | Signal[V]): Modifier[V, String] = {
    this := value
  }

  def :=(value: V | Signal[V]): Modifier[V, String] = {
    Modifier.fromVorObservableV(this, value, codec)
  }
}

object SvgAttr {
  final val svgNamespaceUri: String = "http://www.w3.org/2000/svg"
  final val xlinkNamespaceUri: String = "http://www.w3.org/1999/xlink"
  final val xmlNamespaceUri: String = "http://www.w3.org/XML/1998/namespace"
  final val xmlnsNamespaceUri: String = "http://www.w3.org/2000/xmlns/"

  final def namespaceUri(namespace: String): String = {
    namespace match {
      case "svg"   => svgNamespaceUri
      case "xlink" => xlinkNamespaceUri
      case "xml"   => xmlNamespaceUri
      case "xmlns" => xmlnsNamespaceUri
    }
  }
}

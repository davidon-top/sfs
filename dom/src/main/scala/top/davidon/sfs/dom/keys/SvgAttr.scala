package top.davidon.sfs.dom.keys
import top.davidon.sfs.dom.codecs.{Codec, StringCodec}
import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.mods.Modifier
import top.davidon.sfs.dom.plain.PlainValue

class SvgAttr[V](
    val localName: String,
    val codec: StringCodec[V],
    val namespacePrefix: Option[String]
) extends Key {
  override val name: String =
    namespacePrefix.map(_ + ":" + localName).getOrElse(localName)

  val namespaceUri: Option[String] = namespacePrefix.map(SvgAttr.namespaceUri)

  @inline def apply(value: V): Modifier[String] = {
    this := value
  }

  def :=(value: V): Modifier[String] = {
    Modifier(this, PlainValue(value, codec))
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

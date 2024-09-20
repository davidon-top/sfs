package top.davidon.sfs.dom.defs.complex

import top.davidon.sfs.dom.codecs
import top.davidon.sfs.dom.keys.HtmlAttr

trait ComplexHtmlKeys {
  lazy val rel = HtmlAttr("rel", codecs.StringAsIsCodec)
  lazy val role = HtmlAttr("role", codecs.StringAsIsCodec)
  lazy val styleAttr = HtmlAttr("style", codecs.StringAsIsCodec)
  val className = HtmlAttr("class", codecs.StringAsIsCodec)
  val cls: HtmlAttr[String] = className
  val `class`: HtmlAttr[String] = className
  val classList = HtmlAttr("class", codecs.IterableAsSpaceSeparatedStringCodec)
  val cl: HtmlAttr[Iterable[String]] = classList

  def dataAttr(suffix: String): HtmlAttr[String] =
    HtmlAttr[String]("data-" + suffix, codecs.StringAsIsCodec)
}

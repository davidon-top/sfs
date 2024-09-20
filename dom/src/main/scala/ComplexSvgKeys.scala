package top.davidon.sfs.dom.defs.complex

import top.davidon.sfs.dom.codecs
import top.davidon.sfs.dom.keys.HtmlAttr

trait ComplexSvgKeys {
  lazy val role = HtmlAttr("role", codecs.StringAsIsCodec)
  val className = HtmlAttr("class", codecs.StringAsIsCodec)
  val cls: HtmlAttr[String] = className
  val `class`: HtmlAttr[String] = className
  val classList = HtmlAttr("class", codecs.IterableAsSpaceSeparatedStringCodec)
  val cl: HtmlAttr[Iterable[String]] = classList
}

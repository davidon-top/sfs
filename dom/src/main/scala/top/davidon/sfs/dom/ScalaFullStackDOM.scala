package top.davidon.sfs.dom

import top.davidon.sfs.dom.codecs.*
import top.davidon.sfs.dom.defs.attrs.{AriaAttrs, HtmlAttrs, SvgAttrs}
import top.davidon.sfs.dom.defs.complex.{ComplexHtmlKeys, ComplexSvgKeys}
import top.davidon.sfs.dom.defs.eventProps.GlobalEventProps
import top.davidon.sfs.dom.defs.props.HtmlProps
import top.davidon.sfs.dom.defs.tags.{HtmlTags, SvgTags}

trait ScalaFullStackDOM
    extends HtmlTags
    with HtmlAttrs
    with HtmlProps
    with GlobalEventProps
    with ComplexHtmlKeys {

  type Component = Element[?]

  object aria extends AriaAttrs

  object svg extends SvgTags with SvgAttrs with ComplexSvgKeys

  given strToVal: Conversion[String, Value[String, String]] with {
    def apply(from: String): Value[String, String] =
      Value(from, StringAsIsCodec)
  }
  given intToVal: Conversion[Int, Value[Int, String]] with {
    def apply(from: Int): Value[Int, String] = Value(from, IntAsStringCodec)
  }
  given doubleToVal: Conversion[Double, Value[Double, String]] with {
    def apply(from: Double): Value[Double, String] =
      Value(from, DoubleAsStringCodec)
  }
  given longToVal: Conversion[Long, Value[Long, String]] with {
    def apply(from: Long): Value[Long, String] = Value(from, LongAsStringCodec)
  }
  given iterToVal: Conversion[Iterable[String], Value[Iterable[String], String]]
  with {
    def apply(from: Iterable[String]): Value[Iterable[String], String] =
      Value(from, IterableAsSpaceSeparatedStringCodec)
  }
}

package top.davidon.sfs.dom

import rescala.default.Signal
import top.davidon.sfs.dom.codecs.*
import top.davidon.sfs.dom.defs.attrs.{AriaAttrs, HtmlAttrs, SvgAttrs}
import top.davidon.sfs.dom.defs.complex.{ComplexHtmlKeys, ComplexSvgKeys}
import top.davidon.sfs.dom.defs.eventProps.GlobalEventProps
import top.davidon.sfs.dom.defs.props.HtmlProps
import top.davidon.sfs.dom.defs.tags.{HtmlTags, SvgTags}
import top.davidon.sfs.dom.plain.PlainValue
import top.davidon.sfs.dom.reactive.ReactiveValue

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
    def apply(from: String): PlainValue[String, String] =
      PlainValue(from, StringAsIsCodec)
  }
  given intToVal: Conversion[Int, Value[Int, String]] with {
    def apply(from: Int): PlainValue[Int, String] =
      PlainValue(from, IntAsStringCodec)
  }
  given doubleToVal: Conversion[Double, Value[Double, String]] with {
    def apply(from: Double): PlainValue[Double, String] =
      PlainValue(from, DoubleAsStringCodec)
  }
  given longToVal: Conversion[Long, Value[Long, String]] with {
    def apply(from: Long): PlainValue[Long, String] =
      PlainValue(from, LongAsStringCodec)
  }
  given iterToVal: Conversion[Iterable[String], Value[Iterable[String], String]]
  with {
    def apply(from: Iterable[String]): PlainValue[Iterable[String], String] =
      PlainValue(from, IterableAsSpaceSeparatedStringCodec)
  }

  given signalToVal: Conversion[Signal[String], ReactiveValue[String, String]]
  with {
    def apply(from: Signal[String]): ReactiveValue[String, String] = {
      ReactiveValue(from, StringAsIsCodec)
    }
  }
}

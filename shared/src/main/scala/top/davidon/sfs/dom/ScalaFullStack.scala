package top.davidon.sfs.dom

import top.davidon.sfs.dom.codecs.*
import top.davidon.sfs.dom.defs.attrs.{AriaAttrs, HtmlAttrs, SvgAttrs}
import top.davidon.sfs.dom.defs.complex.{ComplexHtmlKeys, ComplexSvgKeys}
import top.davidon.sfs.dom.defs.eventProps.GlobalEventProps
import top.davidon.sfs.dom.defs.props.HtmlProps
import top.davidon.sfs.dom.defs.tags.{HtmlTags, SvgTags}

trait ScalaFullStack
    extends HtmlTags
    with HtmlAttrs
    with HtmlProps
    with GlobalEventProps
    with ComplexHtmlKeys {

  type Component = Element[?]

  object aria extends AriaAttrs

  object svg extends SvgTags with SvgAttrs with ComplexSvgKeys

  given AsValue[String, String] with {
    extension (from: String) {
      def asStringValue(): Value[String, String] = {
        Value(from, StringAsIsCodec)
      }
    }
  }
  given AsValue[Int, String] with {
    extension (from: Int) {
      def asStringValue(): Value[Int, String] = {
        Value(from, IntAsStringCodec)
      }
    }
  }
  given AsValue[Double, String] with {
    extension (from: Double) {
      def asStringValue(): Value[Double, String] = {
        Value(from, DoubleAsStringCodec)
      }
    }
  }
  given AsValue[Boolean, String] with {
    extension (from: Boolean) {
      def asStringValue(): Value[Boolean, String] = {
        Value(from, BooleanAsTrueFalseStringCodec)
      }
    }
  }
  given AsValue[Iterable[String], String] with {
    extension (from: Iterable[String]) {
      def asStringValue(): Value[Iterable[String], String] = {
        Value(from, IterableAsSpaceSeparatedStringCodec)
      }
    }
  }
}

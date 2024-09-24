package top.davidon.sfs.dom.plain

import top.davidon.sfs.dom.{Value, codecs}
import top.davidon.sfs.dom.codecs.Codec

class PlainValue[F, T](
    val value: F,
    val codec: Codec[F, T]
) extends Value[T] {
  def apply(): T = {
    codec.encode(value)
  }

  override def toString: String = {
    value match
      case v: Int     => codecs.IntAsStringCodec.encode(v)
      case v: Long    => codecs.LongAsStringCodec.encode(v)
      case v: Double  => codecs.DoubleAsStringCodec.encode(v)
      case v: Boolean => codecs.BooleanAsTrueFalseStringCodec.encode(v)
      case v: Iterable[String] =>
        codecs.IterableAsSpaceSeparatedStringCodec.encode(v)
      case _ =>
        throw Exception("Couldn't find codec to convert a value to a string")
  }
}

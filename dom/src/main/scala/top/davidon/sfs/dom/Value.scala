package top.davidon.sfs.dom
import top.davidon.sfs.dom.codecs.{Codec, Coder}

trait Value[F, T](val value: F, val codec: Codec[F, T]) {
  def apply(): T = {
    codec.encoder(value)
  }

  override def toString: String = { codec.stringCode(value) }
}

//class Value[F, T](
//    val value: F,
//    val codec: Codec[F, T]
//) {
//  def apply(): T = {
//    codec.encode(value)
//  }
//
//  override def toString: String = {
//    value match
//      case v: Int     => codecs.IntAsStringCodec.encode(v)
//      case v: Long    => codecs.LongAsStringCodec.encode(v)
//      case v: Double  => codecs.DoubleAsStringCodec.encode(v)
//      case v: Boolean => codecs.BooleanAsTrueFalseStringCodec.encode(v)
//      case v: Iterable[String] =>
//        codecs.IterableAsSpaceSeparatedStringCodec.encode(v)
//      case _ =>
//        throw Exception("Couldn't find codec to convert a value to a string")
//  }
//}
//
//object Value {
//  def join(
//      iterator: Iterable[Value[?, String]]
//  ): Value[String, String] = {
//    Value(
//      iterator.map(v => v.toString).mkString(""),
//      StringAsIsCodec
//    )
//  }
//
//}

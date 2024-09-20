package top.davidon.sfs.dom

import top.davidon.sfs.dom.codecs.{Codec, StringAsIsCodec}

class Value[F, T](
    val value: F,
    val codec: Codec[F, T],
    var isReactive: Boolean = false
) {
  def apply(): T = {
    codec.encode(value)
  }

  def reactive(value: Boolean = true): Value[F, T] = {
    isReactive = value
    this
  }
}

object Value {
  def join(
      iterator: Iterable[Value[?, String]]
  ): Value[String, String] = {
    Value(
      iterator.map(v => v.codec.encode(v.value)).mkString(""),
      StringAsIsCodec,
      iterator.exists(_.isReactive)
    )
  }

}

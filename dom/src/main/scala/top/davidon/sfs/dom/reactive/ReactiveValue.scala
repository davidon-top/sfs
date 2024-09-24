package top.davidon.sfs.dom.reactive

import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.plain.PlainValue

class ReactiveValue[F, T](
    val value: Observable[F],
    val codec: Codec[F, T]
) extends Value[T] {
  def apply(): T = {
    codec.encode(value.now())
  }

  def toValueNow: PlainValue[F, T] = {
    PlainValue(value.now(), codec)
  }
}

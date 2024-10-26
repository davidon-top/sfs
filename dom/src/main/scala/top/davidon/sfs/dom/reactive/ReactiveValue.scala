package top.davidon.sfs.dom.reactive

import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.plain.PlainValue

class ReactiveValue[F, T](
    val reactiveValue: Observable[F],
    codec: Codec[F, T]
) extends Value[F, T](reactiveValue.now(), codec) {
  override def apply(): T = {
    codec.encode(reactiveValue.now())
  }

  override def toString: String = {
    codec.stringCode(reactiveValue.now())
  }

  def toValueNow: PlainValue[F, T] = {
    PlainValue(reactiveValue.now(), codec)
  }
}

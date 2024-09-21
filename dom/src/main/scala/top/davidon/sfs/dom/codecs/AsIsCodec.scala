package top.davidon.sfs.dom.codecs

class AsIsCodec[T](val strCodec: StringCodec[T]) extends Codec[T, T] {
  override def encode(scalaValue: T): T = scalaValue

  override def decode(domValue: T): T = domValue
}

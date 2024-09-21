package top.davidon.sfs.dom.codecs

class EmptyCodec[T] extends Codec[T, Unit] {
  override def decode(domValue: Unit): T = ???
  override def encode(scalaValue: T): Unit = {}
}

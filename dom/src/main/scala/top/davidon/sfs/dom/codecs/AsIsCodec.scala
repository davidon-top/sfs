package top.davidon.sfs.dom.codecs

class AsIsCoder[T] extends Coder[T, T] {
  def apply(value: T): T = value
}

class AsIsCodec[T](sc: Coder[T, String])
    extends Codec[T, T](new AsIsCoder[T], new AsIsCoder[T], sc)

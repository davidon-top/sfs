package top.davidon.sfs.dom.codecs

val EmptyCodec = new Codec[Any, Unit](
  * => (),
  * => (),
  * => ""
)

package top.davidon.sfs.dom.plain

import top.davidon.sfs.dom.{Value, codecs}
import top.davidon.sfs.dom.codecs.Codec

class PlainValue[F, T](value: F, codec: Codec[F, T])
    extends Value[F, T](value, codec) {}

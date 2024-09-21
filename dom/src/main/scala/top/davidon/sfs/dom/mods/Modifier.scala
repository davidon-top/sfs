package top.davidon.sfs.dom.mods

import top.davidon.sfs.dom.Value
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.keys.Key

class Modifier[F, T](
    val key: Key,
    val value: Value[F, T]
) {}

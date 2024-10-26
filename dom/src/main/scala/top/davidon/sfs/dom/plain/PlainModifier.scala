package top.davidon.sfs.dom.plain
import top.davidon.sfs.dom.codecs.Codec
import top.davidon.sfs.dom.keys.Key
import top.davidon.sfs.dom.mods.Modifier

class PlainModifier[F, T](key: Key, value: PlainValue[F, T])
    extends Modifier[F, T](key, value) {}

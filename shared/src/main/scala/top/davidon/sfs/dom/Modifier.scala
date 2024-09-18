package top.davidon.sfs.dom

import top.davidon.sfs.dom.keys.Key
import top.davidon.sfs.dom.Value

class Modifier[F, T](val key: Key, val value: Value[F, T]) {}

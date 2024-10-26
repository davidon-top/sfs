package top.davidon.sfs.dom.reactive
import top.davidon.sfs.dom.keys.Key
import top.davidon.sfs.dom.mods.Modifier

class ReactiveModifier[F, T](key: Key, reactiveValue: ReactiveValue[F, T])
    extends Modifier[F, T](key, reactiveValue) {}

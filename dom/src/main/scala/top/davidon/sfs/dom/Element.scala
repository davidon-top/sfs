package top.davidon.sfs.dom

import top.davidon.sfs.dom.mods.Modifier
import top.davidon.sfs.dom.tags.Tag

/** tag + modifiers + value */
class Element[+Ref <: org.scalajs.dom.Element](
    val tag: Tag[Ref],
    val mods: Iterable[Modifier[?]],
    val children: Seq[Element[?] | Value[String]]
) {}

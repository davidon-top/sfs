package top.davidon.sfs.dom.tags

class SvgTag[+Ref <: org.scalajs.dom.svg.Element](
    override val name: String,
    override val void: Boolean = false
) extends Tag[Ref] {}

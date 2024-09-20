package top.davidon.sfs.dom.tags

class HtmlTag[+Ref <: org.scalajs.dom.html.Element](
    override val name: String,
    override val void: Boolean = false
) extends Tag[Ref] {}

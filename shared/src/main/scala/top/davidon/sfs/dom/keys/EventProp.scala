package top.davidon.sfs.dom.keys

import org.scalajs.dom

class EventProp[Event <: dom.Event](override val name: String) extends Key {}

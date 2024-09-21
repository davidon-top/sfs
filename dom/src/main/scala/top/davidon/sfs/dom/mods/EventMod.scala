package top.davidon.sfs.dom.mods

import org.scalajs.dom
import top.davidon.sfs.dom.keys.EventProp

class EventMod[E <: dom.Event](val key: EventProp[E], val value: E => Unit) {}

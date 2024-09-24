package top.davidon.sfs.dom.reactive

trait TriggerableValue[T] {
  def trigger(value: T): Unit
}

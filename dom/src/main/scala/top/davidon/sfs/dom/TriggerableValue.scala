package top.davidon.sfs.dom

trait TriggerableValue[T] {
  def trigger[T](value: T): Unit
}

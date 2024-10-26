package top.davidon.sfs.dom.reactive

abstract class Observable[T](var value: T) {
  def subscribe(observer: T => Unit): Unit
  def unsubscribe(observer: T => Unit): Unit
  def update(value: T): Unit
  def now(): T
}

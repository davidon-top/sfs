package top.davidon.sfs.dom.reactive

trait Observable[T] {
  def subscribe(observer: T => Unit): Unit
  def unsubscribe(observer: T => Unit): Unit
  def notify(value: T): Unit
  def update(value: T): Unit
  def now(): T
}

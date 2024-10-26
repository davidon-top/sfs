package top.davidon.sfs.dom.codecs

trait Coder[F, T] {
  def apply(value: F): T
}

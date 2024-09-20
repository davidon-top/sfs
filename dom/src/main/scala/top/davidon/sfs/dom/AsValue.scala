package top.davidon.sfs.dom

trait AsValue[F, T] {
  extension (from: F) {
    def asStringValue(): Value[F, String]
  }
}

package top.davidon.sfs.dom.codecs

trait Codec[ScalaType, DomType] {

  /** Convert the result of a `dom.Node.getAttribute` call to appropriate Scala
    * type.
    *
    * Note: HTML Attributes are generally optional, and `dom.Node.getAttribute`
    * will return `null` if an attribute is not defined on a given DOM node.
    * However, this decoder is only intended for cases when the attribute is
    * defined.
    */
  def decode(domValue: DomType): ScalaType

  /** Convert desired attribute value to appropriate DOM type. The resulting
    * value should be passed to `dom.Node.setAttribute` call, EXCEPT when
    * resulting value is a `null`. In that case you should call
    * `dom.Node.removeAttribute` instead.
    *
    * We use `null` instead of [[Option]] here to reduce overhead in JS land.
    * This method should not be called by end users anyway, it's the consuming
    * library's job to call this method under the hood.
    */
  def encode(scalaValue: ScalaType): DomType
}

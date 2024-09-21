package top.davidon.sfs.dom

package object codecs {

  lazy val IntAsStringCodec: Codec[Int, String] = new Codec[Int, String] {

    override def decode(domValue: String): Int =
      domValue.toInt // @TODO this can throw exception. How do we handle this?

    override def encode(scalaValue: Int): String = scalaValue.toString
  }

  lazy val DoubleAsIsCodec: Codec[Double, Double] = AsIsCodec()

  lazy val DoubleAsStringCodec: Codec[Double, String] =
    new Codec[Double, String] {

      override def decode(domValue: String): Double =
        domValue.toDouble // @TODO this can throw exception. How do we handle this?

      override def encode(scalaValue: Double): String = scalaValue.toString
    }
  lazy val LongAsIsCodec: Codec[Long, Long] = AsIsCodec()

  lazy val LongAsStringCodec: Codec[Long, String] =
    new Codec[Long, String] {

      override def decode(domValue: String): Long =
        domValue.toLong // @TODO this can throw exception. How do we handle this?

      override def encode(scalaValue: Long): String = scalaValue.toString
    }

  lazy val BooleanAsTrueFalseStringCodec: Codec[Boolean, String] =
    new Codec[Boolean, String] {

      override def decode(domValue: String): Boolean = domValue == "true"

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "true" else "false"
    }

  lazy val BooleanAsYesNoStringCodec: Codec[Boolean, String] =
    new Codec[Boolean, String] {

      override def decode(domValue: String): Boolean = domValue == "yes"

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "yes" else "no"
    }
  lazy val BooleanAsOnOffStringCodec: Codec[Boolean, String] =
    new Codec[Boolean, String] {

      override def decode(domValue: String): Boolean = domValue == "on"

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "on" else "off"
    }

  lazy val IterableAsSpaceSeparatedStringCodec
      : Codec[Iterable[String], String] =
    new Codec[Iterable[String], String] { // could use for e.g. className

      override def decode(domValue: String): Iterable[String] =
        if domValue == "" then Nil else domValue.split(' ')

      override def encode(scalaValue: Iterable[String]): String =
        scalaValue.mkString(" ")
    }
  lazy val IterableAsCommaSeparatedStringCodec
      : Codec[Iterable[String], String] =
    new Codec[Iterable[String], String] { // could use for lists of IDs

      override def decode(domValue: String): Iterable[String] =
        if domValue == "" then Nil else domValue.split(',')

      override def encode(scalaValue: Iterable[String]): String =
        scalaValue.mkString(",")
    }
  val StringAsIsCodec: Codec[String, String] = AsIsCodec()
  val IntAsIsCodec: Codec[Int, Int] = AsIsCodec()
  val BooleanAsIsCodec: Codec[Boolean, Boolean] = AsIsCodec()

  val BooleanAsAttrPresenceCodec: Codec[Boolean, String] =
    new Codec[Boolean, String] {

      override def decode(domValue: String): Boolean = domValue != null

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "" else null
    }

  def AsIsCodec[V](): Codec[V, V] = new Codec[V, V] {
    override def encode(scalaValue: V): V = scalaValue

    override def decode(domValue: V): V = domValue
  }
}

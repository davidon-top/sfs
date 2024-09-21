package top.davidon.sfs.dom

package object codecs {

  lazy val IntAsStringCodec: StringCodec[Int] =
    new StringCodec[Int] {

      override def decode(domValue: String): Int =
        domValue.toInt // @TODO this can throw exception. How do we handle this?

      override def encode(scalaValue: Int): String = scalaValue.toString
    }

  lazy val DoubleAsStringCodec: StringCodec[Double] =
    new StringCodec[Double] {

      override def decode(domValue: String): Double =
        domValue.toDouble // @TODO this can throw exception. How do we handle this?

      override def encode(scalaValue: Double): String = scalaValue.toString
    }

  lazy val LongAsStringCodec: StringCodec[Long] =
    new StringCodec[Long] {

      override def decode(domValue: String): Long =
        domValue.toLong // @TODO this can throw exception. How do we handle this?

      override def encode(scalaValue: Long): String = scalaValue.toString
    }

  lazy val BooleanAsTrueFalseStringCodec: StringCodec[Boolean] =
    new StringCodec[Boolean] {

      override def decode(domValue: String): Boolean = domValue == "true"

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "true" else "false"
    }

  lazy val BooleanAsYesNoStringCodec: StringCodec[Boolean] =
    new StringCodec[Boolean] {

      override def decode(domValue: String): Boolean = domValue == "yes"

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "yes" else "no"
    }
  lazy val BooleanAsOnOffStringCodec: StringCodec[Boolean] =
    new StringCodec[Boolean] {

      override def decode(domValue: String): Boolean = domValue == "on"

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "on" else "off"
    }

  lazy val IterableAsSpaceSeparatedStringCodec: StringCodec[Iterable[String]] =
    new StringCodec[Iterable[String]] { // could use for e.g. className

      override def decode(domValue: String): Iterable[String] =
        if domValue == "" then Nil else domValue.split(' ')

      override def encode(scalaValue: Iterable[String]): String =
        scalaValue.mkString(" ")
    }
  lazy val IterableAsCommaSeparatedStringCodec: StringCodec[Iterable[String]] =
    new StringCodec[Iterable[String]] { // could use for lists of IDs

      override def decode(domValue: String): Iterable[String] =
        if domValue == "" then Nil else domValue.split(',')

      override def encode(scalaValue: Iterable[String]): String =
        scalaValue.mkString(",")
    }
  lazy val BooleanAsAttrPresenceCodec: StringCodec[Boolean] =
    new StringCodec[Boolean] {

      override def decode(domValue: String): Boolean = domValue != null

      override def encode(scalaValue: Boolean): String =
        if scalaValue then "" else null
    }

  lazy val LongAsIsCodec: AsIsCodec[Long] = AsIsCodec(LongAsStringCodec)
  lazy val DoubleAsIsCodec: AsIsCodec[Double] = AsIsCodec(DoubleAsStringCodec)
  lazy val StringAsIsCodec: AsIsCodec[String] & StringCodec[String] =
    new AsIsCodec[String](StringAsIsCodec) with StringCodec[String] {}
  lazy val IntAsIsCodec: AsIsCodec[Int] = AsIsCodec(IntAsStringCodec)
  lazy val BooleanAsIsCodec: AsIsCodec[Boolean] = AsIsCodec(
    BooleanAsTrueFalseStringCodec
  )
}

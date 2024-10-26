package top.davidon.sfs.dom

import top.davidon.sfs.dom.codecs.Codec

class StringCodecs {

  lazy val IntAsStringCodec: Codec[Int, String] =
    new Codec[Int, String](
      (value: Int) => value.toString,
      (value: String) => value.toInt,
      (value: Int) => value.toString
    )

  lazy val DoubleAsStringCodec: Codec[Double, String] =
    new Codec[Double, String](
      (value: Double) => value.toString,
      (value: String) => value.toDouble,
      (value: Double) => value.toString
    )

  lazy val LongAsStringCodec: Codec[Long, String] =
    new Codec[Long, String](
      (value: Long) => value.toString,
      (value: String) => value.toLong,
      (value: Long) => value.toString
    )

  lazy val BooleanAsTrueFalseStringCodec: Codec[Boolean, String] =
    new Codec[Boolean, String](
      (value: Boolean) => value.toString,
      (value: String) => value == "true",
      (value: Boolean) => value.toString
    )

  lazy val BooleanAsYesNoStringCodec: Codec[Boolean, String] =
    new Codec[Boolean, String](
      (value: Boolean) => if value then "yes" else "no",
      (value: String) => value == "yes",
      (value: Boolean) => if value then "yes" else "no"
    )

  lazy val BooleanAsOnOffStringCodec: Codec[Boolean, String] =
    new Codec[Boolean, String](
      (value: Boolean) => if value then "on" else "off",
      (value: String) => value == "on",
      (value: Boolean) => if value then "on" else "off"
    )

  lazy val IterableAsSpaceSeparatedStringCodec
      : Codec[Iterable[String], String] =
    new Codec[Iterable[String], String](
      (value: Iterable[String]) => value.mkString(" "),
      (value: String) => if value == "" then Nil else value.split(" "),
      (value: Iterable[String]) => value.mkString(" ")
    )

  lazy val IterableAsCommaSeparatedStringCodec
      : Codec[Iterable[String], String] =
    new Codec[Iterable[String], String](
      (value: Iterable[String]) => value.mkString(","),
      (value: String) => if value == "" then Nil else value.split(","),
      (value: Iterable[String]) => value.mkString(",")
    )

  lazy val BooleanAsAttrPresenceCodec: Codec[Boolean, String] =
    new Codec[Boolean, String](
      (value: Boolean) => if value then "" else null,
      (value: String) => value != null,
      (value: Boolean) => if value then "" else null
    )
}

package object codecs extends StringCodecs {
  lazy val LongAsIsCodec: AsIsCodec[Long] = AsIsCodec(
    LongAsStringCodec.stringCoder
  )
  lazy val DoubleAsIsCodec: AsIsCodec[Double] = AsIsCodec(
    DoubleAsStringCodec.stringCoder
  )
  lazy val StringAsIsCodec: AsIsCodec[String] =
    AsIsCodec[String](AsIsCoder[String]())
  lazy val IntAsIsCodec: AsIsCodec[Int] = AsIsCodec(
    IntAsStringCodec.stringCoder
  )
  lazy val BooleanAsIsCodec: AsIsCodec[Boolean] = AsIsCodec(
    BooleanAsTrueFalseStringCodec.stringCoder
  )
}

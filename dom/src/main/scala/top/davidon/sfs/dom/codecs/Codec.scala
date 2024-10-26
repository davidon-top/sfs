package top.davidon.sfs.dom.codecs

class Codec[F, T](
    val encoder: Coder[F, T],
    val decoder: Coder[T, F],
    val stringCoder: Coder[F, String]
) {
  def decode(value: T): F = {
    decoder(value)
  }

  def encode(scalaValue: F): T = {
    encoder(scalaValue)
  }

  def stringCode(value: F): String = {
    stringCoder(value)
  }
}

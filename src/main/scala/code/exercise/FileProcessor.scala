package code.exercise

import scala.io.Source
import scala.util.Try


object FileProcessor {

  def readFile(file: String) = Try(Source.fromFile(file).getLines.toList)

}

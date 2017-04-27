package coding.exercise.addressbook.utils

import scala.io.Source
import scala.util.{Failure, Success, Try}

object FileUtils {

  val path = "data"

  def readFile(file: String): Option[List[String]] = {
    val srcFile = Source.fromFile(path + "/" + file)
    try {
      Some(srcFile.getLines.toList)
    } catch {
      case ex: Exception => throw new RuntimeException(s"File $file not found:: ${ex.getMessage}")
    } finally {
      srcFile.close()
    }
  }

  def convertFileToList(fileName: String, f: String => Option[List[String]]): List[String] = {
    Try(f(fileName)) match {
      case Success(Some(ls)) => ls
      case Failure(ex) => Nil
    }
  }

}

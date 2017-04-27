package coding.exercise.addressbook.utils

import java.io.FileNotFoundException

import org.scalatest.{Matchers, WordSpec}
import coding.exercise.addressbook.utils.FileUtils._

class FileUtilsSpec extends WordSpec with Matchers {

  "FileUtils" should {

    "fail to read a file" when {
      "invalid fileName is passed" in {
        val thrown = the[FileNotFoundException] thrownBy readFile("anyfile.txt")
        thrown.getMessage should include("anyfile.txt (No such file or directory)")
      }
    }

    "read a file" when {
      "valid fileName is passed" in {
        val x = readFile("TestFile.txt")
        x.head should be(List("Lorem ipsum dolor sit amet, rutrum elit aliquet aenean,", "convallis luctus rhoncus senectus sit conubia, volutpat", "ac magna praesent lectus. Amet libero tortor, posuere", "dictumst morbi purus arcu. Tellus vitae ut vel quis,", "nec amet, morbi a pretium massa lectus. Pellentesque", "habitasse at blandit elementum, ipsum pede, nunc pellentesque.", "Sit blandit erat sed phasellus animi nostra. Aliquam lorem enim", "lobortis, nec tortor parturient consectetur at senectus ac.", "Sit at dolor nunc enim gravida lectus, tempor maecenas nibh", "lacus odio, molestie elit suscipit sit sed nibh, faucibus", "lacinia, sed montes class elit egestas ultricies.", "Odio nulla dolor malesuada vivamus, adipiscing", "ultricies sapien amet nibh libero."))
      }
    }

    "convert a text file to a list of strings" when {
      "valid fileName is passed" in {
        val x = convertFileToList("TestFile.txt", readFile)
        x.size should be(13)
        x.head should include("Lorem ipsum dolor sit amet, rutrum elit aliquet aenean")
      }
    }

    "return a Nil while converting the file" when {
      "invalid fileName is passed" in {
        val result = convertFileToList("anyfile.txt", readFile)
        result should be(Nil)
      }
    }

  }

}

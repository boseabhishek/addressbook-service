package code.exercise.unit

import org.scalatest.{Matchers, WordSpec}
import code.exercise.FileProcessor._

class FileProcessorSpec extends WordSpec with Matchers {

  "FileProcessor" should {

    "fail to process a file" when {
      "invalid fileName is passed" in {
        val x = readFile("anyfile.txt")
        x.isFailure should be (true)
      }

    }
  }

}

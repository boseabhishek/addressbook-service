package coding.exercise.addressbook.services

import java.io.FileNotFoundException

import coding.exercise.addressbook.utils.DateUtils._
import coding.exercise.addressbook.utils.FileUtils.readFile
import org.joda.time.format.DateTimeFormat
import org.scalatest.{Matchers, WordSpec}

class AddressBookServiceSpec extends WordSpec with Matchers {

  val dtf = DateTimeFormat.forPattern("dd/MM/yy")

  val addressBookService = new AddressBookService

  "AddressBookService" should {

    "return the count of male members in addressbook" when {
      "gender as MALE is passed" in {
        val x = addressBookService.countByGender("AddressTestFile.txt", "MALE")
        x should be (3)
      }
    }

    "return the count of female members in addressbook" when {
      "gender as FEMALE is passed" in {
        val x = addressBookService.countByGender("AddressTestFile.txt", "FEMALE")
        x should be (2)
      }
    }

    "return count as 0" when {
      "invalid gender is passed" in {
        val x = addressBookService.countByGender("AddressTestFile.txt", "ANYGENDER")
        x should be (0)
      }
    }

    "return the name of the oldest person" when {
      "a valid file is passed" in {
        val x = addressBookService.oldestPerson("AddressTestFile.txt")
        x should be ("Gemma Lane")
      }
    }

    "throw RuntimeException while determining the oldest person name" when {
      "a invalid file is passed" in {
        val thrown = the[RuntimeException] thrownBy addressBookService.oldestPerson("anyfile.txt")
        thrown.getMessage should include("No names found!")
      }
    }

    "throw RuntimeException while determining the oldest person name" when {
      "a malformed file is passed with invalid date format" in {
        val thrown = the[RuntimeException] thrownBy addressBookService.oldestPerson("MalformedTestFile3.txt")
        thrown.getMessage should include("Incorrect date of birth format in text file")
      }
    }

    "compares to persons age and says Sarah is older than Paul" when {
      "a valid file is passed" in {
        val x = addressBookService.compareAge("Paul", "Sarah", "AddressTestFile.txt")
        x should be ("Sarah is 1578 days older than Paul")
      }
    }

    "compares to persons age and says Paul is older than Sarah" when {
      "a valid file is passed" in {
        val x = addressBookService.compareAge("Sarah", "Paul", "AddressTestFile.txt")
        x should be ("Sarah is 1578 days older than Paul")
      }
    }

    "compares to persons age and says they are of same age" when {
      "a valid file is passed" in {
        val x = addressBookService.compareAge("Wes", "Gemma", "AddressTestFile.txt")
        x should be ("Gemma and Wes are of same age")
      }
    }

    "throw RuntimeException while comparing ages and Paul's age is malformed" when {
      "a malformed file is passed with invalid date format" in {
        val thrown = the[RuntimeException] thrownBy addressBookService.compareAge("Paul", "Sarah", "MalformedTestFile.txt")
        thrown.getMessage should include("Incorrect date of birth format in text file")
      }
    }

    "throw RuntimeException while comparing ages and Sarah's age is malformed" when {
      "a malformed file is passed with invalid date format" in {
        val thrown = the[RuntimeException] thrownBy addressBookService.compareAge("Paul", "Sarah", "MalformedTestFile1.txt")
        thrown.getMessage should include("Incorrect date of birth format in text file")
      }
    }






  }

}

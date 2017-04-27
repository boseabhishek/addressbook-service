package coding.exercise.addressbook.services

import coding.exercise.addressbook.utils.DateUtils._
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


  }

}

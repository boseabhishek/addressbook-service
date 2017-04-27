package coding.exercise.addressbook.utils

import coding.exercise.addressbook.utils.DateUtils._
import org.joda.time.format.DateTimeFormat
import org.joda.time.{DateTime, LocalDate}
import org.scalatest.{Matchers, WordSpec}

class DateUtilsSpec extends WordSpec with Matchers {

  val dtf = DateTimeFormat.forPattern("dd/MM/yy")

  "DateUtils" should {

    "fail to convert a date string to joda date" when {
      "invalid date string is passed" in {
        val x = convertToDate("12345678")
        x should be (None)
      }
    }

    "convert a date string to joda date" when {
      "valid date string is passed" in {
        val x = convertToDate("14/04/2017")
        x should be (Some(dtf.parseDateTime("14/04/2017")))
      }
    }


  }

}

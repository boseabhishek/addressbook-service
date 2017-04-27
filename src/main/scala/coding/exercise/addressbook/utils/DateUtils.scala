package coding.exercise.addressbook.utils

import java.time.LocalDate

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import scala.util.{Failure, Success, Try}

object DateUtils {

  def convertToDate(dateString: String): Option[DateTime] = {
    Try(DateTimeFormat.forPattern("dd/MM/yy").parseDateTime(dateString)) match {
      case Success(l) => Some(l)
      case Failure(ex) => None
    }

  }

  implicit def dateTimeOrdering: Ordering[DateTime] = Ordering.fromLessThan(_ isBefore _)


}

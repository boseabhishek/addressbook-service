package coding.exercise.addressbook.services

import coding.exercise.addressbook.utils.FileUtils._
import coding.exercise.addressbook.utils.DateUtils._
import org.joda.time.{DateTime, Days}

import scala.math._

class AddressBookService {

  def countByGender(fileName: String, gender: String) = convertFileToList(fileName, readFile) count (_.split(", ")(1).toUpperCase == gender)

  def oldestPerson(fileName: String) = {
    def highestDob(ls: List[String]): DateTime = ls.map(x =>
      convertToDate(x.split(", ")(2)).getOrElse(throw new RuntimeException("Incorrect date of birth format in text file"))).sorted.head
    val ls = convertFileToList(fileName, readFile)
    ls.find(l => convertToDate(l.split(", ")(2)).getOrElse(throw new RuntimeException("Incorrect date of birth format in text file")) ==
      highestDob(ls)) match {
      case Some(name) => name.split(", ")(0)
      case None => throw new RuntimeException("No names found!")
    }
  }

  def compareAge(person1: String, person2: String, fileName: String): String = {
    val ls = convertFileToList(fileName, readFile)
    val dobPerson1 = convertToDate(ls.find(l => l.toUpperCase.contains(person1.toUpperCase())).getOrElse(throw new RuntimeException(s"No person of name $person1 could be found")).split(", ")(2)).getOrElse(throw new RuntimeException("Incorrect date of birth format in text file"))
    val dobPerson2 = convertToDate(ls.find(l => l.toUpperCase.contains(person2.toUpperCase())).getOrElse(throw new RuntimeException(s"No person of name $person2 could be found")).split(", ")(2)).getOrElse(throw new RuntimeException("Incorrect date of birth format in text file"))

    Days.daysBetween(dobPerson1, dobPerson2).getDays match {
      case days if days < 0 => s"$person2 is ${abs(days)} days older than $person1"
      case days if days > 0 => s"$person1 is ${abs(days)} days older than $person2"
      case _ => s"$person2 and $person1 are of same age"
    }
  }

}

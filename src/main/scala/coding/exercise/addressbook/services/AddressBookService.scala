package coding.exercise.addressbook.services

import coding.exercise.addressbook.utils.FileUtils._

class AddressBookService {

  def countByGender(fileName: String, gender: String) = convertFileToList(fileName, readFile) count (_.split(", ")(1).toUpperCase == gender)

}

package coding.exercise.addressbook

import coding.exercise.addressbook.services.AddressBookService

object AddressBookHandler extends App {

  // $COVERAGE-OFF$
  val addressBookService = new AddressBookService

  println(s"Number of males in the address book:: ${addressBookService.countByGender("Address.txt", "MALE")}")
  println(s"Oldest person in the address bookk:: ${addressBookService.oldestPerson("Address.txt")}")
  println(s"How many days older is Bill than Paul?:: ${addressBookService.compareAge("Bill", "Paul", "Address.txt")}")
  // $COVERAGE-ON$

}

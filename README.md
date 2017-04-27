# addressbook-service

#### Tools and Technologies ####

- scala (version 2.11.2) (needs to be installed/ classpath to be set)
- sbt (0.13.5) (needs to be installed)
- find all other necessary dependencies in build.sbt file

#### To see results for the problems ####
- sbt run
(see AddressBookHandler for details on problems)

#### To run all tests ####
- sbt test
(The tests are well descriptive)

#### To run coverage ####

- sbt clean coverage test
- sbt coverageReport


N.B. - Used the scala.io for file reading but it's not very efficient in closing file.
       scala-incubator can be used in place but not used as it's a 3rd party library.
       No mocking has been used for the same reason.
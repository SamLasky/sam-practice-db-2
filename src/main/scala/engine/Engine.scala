package engine

import db.{Database, User}
import scala.io.StdIn._
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.9.0"

object Engine extends App with Database {
  val joach = User("joach", "cranberryBog")
  val milg = User("milg", "carribousButtcrack")
  val database = List[User]()
  val updatedDatabase = createUser(joach, database)
  val updatedDatabase2 = createUser(milg, updatedDatabase)
  val mongoClient: MongoClient = MongoClient()

  val myLilUserBoi = getUser("joach", updatedDatabase2)
  //println(myLilUserBoi)
  //println(updatedDatabase2)

  val goodbyeJoachDatabase = deleteUser(joach, updatedDatabase2)
  //println(goodbyeJoachDatabase)
  runForever(database)
  def runForever(database: List[User]){
    println(database)
    val name = readLine("name? ")
    val location = readLine("locashe? ")
    val user = User(name, location)
    val doSomething = readLine("What? ")
    println(doSomething)
    runForever(if(doSomething == "delete") deleteUser(user, database) else if(doSomething == "create") createUser(user, database) else {
      println("nah son")
      database
    })

  }


}




object Boop extends Database{

  // val immutable: Int = 5

  // val immutable2 = addOne(immutable)
  //  val immutable3 = addOne(immutable2)

  def addOne(someInt: Int) = someInt + 1

  val someFunction = { sallyFields: Int =>
    addOne(sallyFields)
  }
  val list = List(1, 2, 3, 4)

  list.map(someFunction).map(println)

  val a = User("pickle", "locisk")

  println(a.location)
}

package db


trait Database {

  def createUser(someUser: User, database: List[User]) = database :+ someUser

  def getUser(userName: String, database: List[User]) = database.find(user => user.name == userName).get

  def deleteUser(someUser: User, database: List[User]) = database.filterNot(user => user == someUser)


}

case class User(name: String, location: String)




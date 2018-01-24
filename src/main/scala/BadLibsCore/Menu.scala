package BadLibsCore

object Menu {

  def displayMenu(): Unit = {
    println("To choose an option, please type in a number.")
    println()
    println("1: Play from pre-written template.")
    println("2: Play from pre-written template with random trump word.")

    val userEntry = scala.io.StdIn.readInt()
    getUserEntry(userEntry)
  }


  def getUserEntry(userEntry: Int): Unit = {
    userEntry match {
      case 1 => BadLibsEngine.createBadLibStoryAndPrint()
      case 2 => BadLibsEngine.createBadLibStoryFromTrumpAndPrint()
      case _ => {
        println("That was not an option, please try again")
        val newEntry = scala.io.StdIn.readInt()
        getUserEntry(newEntry)
      }
    }
  }

}

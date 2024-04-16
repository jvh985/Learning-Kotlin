

// Getting used to the syntax of Kotlin

fun main() {
    println("Hello World")

    val name = "random person"
    val clubs = 10
    var teams = 10  // mutable type

    // clubs ++  Error: val is read-only

    teams += 4   // teams == 14
    teams ++    // teams == 15

    println("Number of teams: $teams")
    println("Number of clubs: $clubs")

    println("Hello $name")

    val condition = true

    if (condition) {
        println("test for condition bool type")
    }
    else {
        println("error")
    }

    if (!condition) {
        println("Condition set to false")
    }
    else{
        println("Condition set to true")
    }
}



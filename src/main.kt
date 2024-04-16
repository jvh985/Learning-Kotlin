import java.math.BigDecimal

/*  Keyboard shortcuts:
    ⌃ ␣ :brings up completion items
    ⌥ ⏎ :brings up intentions/context actions
    ⇧shift x2 :brings up search everywhere - includes IDE actions
    ⌥ ↑ :to start selecting words, then lines, then blocks
    ⌥ ↓ :reverse of above
    ⌘ / :comments out full line of code, again will undo
    ⌥ ⌘ / :will create block comments
    ⌥ ⇧shift ↑ or ↓ :will move lines of code up or down
    ⇧shift ⌘ ↑ or ↓ :will move entire functions up or down through the code
    ⌘ - or = will collapse / expand code region
    ⌥ ⌘ T :will surround selected code to add template code ie: try/catch
    ⌃ G and ⌃ ⌘ G :will select the symbol at caret / select all symbols with the same name

*/
// Getting used to the syntax of Kotlin


fun main() {
    println("hello world")

    val name = "random person"
    val clubs = 10
    var teams = 10  // mutable type
    val total = 25.60.toBigDecimal()

    val shipping: BigDecimal


    // clubs ++  error: val is read-only

    teams += 4  // teams == 14
    teams -= 2  // teams == 12
    teams *= 2  // teams == 24
    teams /= 3  // teams == 8
    teams ++    // teams == 9
    teams --    // teams == 8

    println("number of teams: $teams")
    println("number of clubs: $clubs")

    println("hello $name")

    val condition = true

    if (condition) {
        println("test for condition bool type")
    }
    else {
        println("error")
    }

    if (!condition) {
        println("condition set to false")
    }
    else{
        println("condition set to true")
    }

   shipping = calculateShipping(total)

    println("Shipping cost is: $${shipping}")

}

fun calculateShipping(total:BigDecimal): BigDecimal {
    val shippingCost:BigDecimal

    if(total < 35.0.toBigDecimal()) {
        shippingCost = 5.00.toBigDecimal()
    }
    else shippingCost = 0.00.toBigDecimal()

    return shippingCost
}


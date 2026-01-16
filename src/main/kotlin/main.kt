// ToDo: Uncomment the code below to test the data class
//import data_class_example.User
//
//fun main() {
//    // Creating an instance with named arguments
//    val user = User(
//        age = 22,
//        lastName = "dayef",
//        firstName = "mourad",
//    )
//
//    // Using generated methods
//    println(user)           // toString()
//    println(user.name)      // Formatted name
//    println(user.isAdult)   // Computed property
//
//    // Copy example
//    val olderUser = user.copy(age = 23)
//    println(olderUser)
//
//    // Destructuring
//    val (age, _, firstName) = user
//    println("$firstName is $age years old")
//}
//
// ToDo: Uncomment the code below to test the enum class
//import enum_class_example.Month
//
//fun main() {
//    // Select month to display its information
//    val month = selectMonth()
//
//    // Display position in its enum declaration
//    println("Ordinal: ${month.ordinal}")
//
//    // Displays information about the selected month
//    println("${month.name}: ${month.title} - ${month.subTitle}\nDescription: ${month.description}".trimIndent())
//}
//
//// Prompts the user to select a month by number
//private fun selectMonth(): Month {
//    while (true) {
//        print("Enter month number (1-12): ")
//        val input = readlnOrNull()?.trim() ?: continue
//
//        // Handle empty input
//        if (input.isBlank()) {
//            println("Please enter a month number")
//            continue
//        }
//
//        // Try to convert input to a month number
//        val monthNumber = input.toIntOrNull() ?: run {
//            println("Please enter a valid number")
//            return@run null
//        } ?: continue
//
//        // Get the corresponding month or show error
//        return Month.entries.getOrNull(monthNumber - 1) ?: run {
//            println("Please enter a number between 1 and 12")
//            return@run null
//        } ?: continue
//    }
//}
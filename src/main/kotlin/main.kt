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
//
// ToDo: Uncomment the code below to test inheritance using interface
//import inheritance_using_interface_example.Doc
//import inheritance_using_interface_example.Eng
//import inheritance_using_interface_example.Person
//
//fun main() {
//    // Create a list of different types of people using the Person interface
//    val team: List<Person> = listOf(
//        // Engineer with all properties
//        Eng(
//            age = 22,
//            lastName = "dayef",
//            firstName = "mourad",
//            field = "Software Engineering",
//            jobTitle = "Senior Software Engineer"  // Overriding default job title
//        ),
//
//        // Doctor with minimal required properties (using defaults for others)
//        Doc(
//            age = 22,
//            firstName = "ashraf",
//            speciality = "Dental Surgery",
//            // lastName will use default empty string
//            // jobTitle will use default "Doctor"
//        ),
//
//        // Another engineer with partial properties
//        Eng(
//            age = 17,  // Testing isAdult functionality
//            firstName = "ahmed",
//            field = "Mechanical Engineering",
//            // lastName will use default empty string
//            // jobTitle will use default "Doctor"
//        )
//    )
//
//    // Process each team member
//    team.forEach { member ->
//        // Demonstrate property access
//        val title = when (member) {
//            is Eng -> "Engineer in ${member.field}"
//            is Doc -> "Doctor specialized in ${member.speciality}"
//            else -> "Team Member"
//        }
//
//        // Demonstrate method calls from the interface
//        val workStatus = member.work()
//        val introduction = member.introduce()
//        val adultStatus = if (member.isAdult) "an adult" else "not an adult"
//
//        // Format the output
//        println("|${"-".repeat(n = 75)}\n|Name: ${member.name}\n|Age: ${member.age} years old ($adultStatus)\n|$workStatus\n|Title: $title\n|$introduction")
//    }
//}
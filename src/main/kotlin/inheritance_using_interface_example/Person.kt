package inheritance_using_interface_example

// Person interface with default implementations for common properties and methods
interface Person {
    val age: Int
    var lastName: String
    val jobTitle: String
    val firstName: String

    // IsAdult computed property with default implementation
    val isAdult: Boolean get() = age >= 18

    // Name computed property with default implementation
    val name: String get() = "${firstName.capitalizeText()} ${lastName.capitalizeText()}".trim()

    // Work method with default implementation
    fun work(): String {
        return "$name is working as $jobTitle"
    }

    // Introduce method with default implementation
    fun introduce(): String {
        return "Hi, my name is $name and I work as $jobTitle"
    }

    // Private extension function for string formatting
    private fun String.capitalizeText(): String {
        return this.trim().lowercase().replaceFirstChar { it.uppercase() }
    }
}
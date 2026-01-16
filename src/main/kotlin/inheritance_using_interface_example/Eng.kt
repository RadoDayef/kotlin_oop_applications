package inheritance_using_interface_example

// Represents Engineer, a specialized type of Person with engineering-specific properties and behaviors.
class Eng(
    val field: String,                          // Engineering specialization field
    override val age: Int,                      // Age from Person interface
    override val firstName: String,             // First name from Person interface
    override var lastName: String = "",         // Last name from Person interface with default empty string
    override val jobTitle: String = "Engineer"  // Job title from Person interface with default "Engineer"
) : Person {
    // Work methode from Person interface with engineer customized implementation
    override fun work(): String {
        return "$name is working as *$jobTitle*"
    }

    // Introduce methode from Person interface with engineer customized implementation
    override fun introduce(): String {
        return "Hi, I'm Eng.$name, specialized in $field"
    }
}
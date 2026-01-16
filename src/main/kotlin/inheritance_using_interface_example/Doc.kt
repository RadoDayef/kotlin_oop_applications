package inheritance_using_interface_example

// Represents Doctor, a specialized type of Person with doctor-specific properties and behaviors.
class Doc(
    override val age: Int,                    // Age from Person interface
    val speciality: String,                   // Speciality of the doctor
    override val firstName: String,           // First name from Person interface
    override var lastName: String = "",       // Last name from Person interface with default empty string
    override val jobTitle: String = "Doctor"  // Job title from Person interface with default "Doctor"
) : Person {
    // Work methode from Person interface with doctor customized implementation
    override fun work(): String {
        return "$name is working as *$jobTitle*"
    }

    // Introduce methode from Person interface with doctor customized implementation
    override fun introduce(): String {
        return "Hi, I'm Dr.$name, specialized in $speciality"
    }
}
package data_class_example

data class User(
    val age: Int,           // Primary constructor property
    val lastName: String,   // Primary constructor property
    val firstName: String,  // Primary constructor property
) {
    // Computed property
    val isAdult: Boolean = age >= 18

    // Another computed property using an extension function
    val name: String = "${firstName.capitalizeName()} ${lastName.capitalizeName()}".trim()

    // Private extension function for string formatting
    private fun String.capitalizeName(): String {
        return this.trim().lowercase().replaceFirstChar { it.uppercase() }
    }
}
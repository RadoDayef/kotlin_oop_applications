# Kotlin OOP Applications

## Data Class Deep Dive

### Basic Structure

```kotlin
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
```

## What Makes This a Data Class?

### 1. The `data` Keyword

- Transforms a regular class into a data-holding class
- Automatically generates standard utility methods
- Must have at least one primary constructor parameter
- Parameters in primary constructor must be marked as `val` or `var`

### 2. Auto-generated Members

#### a) `equals()` and `hashCode()`

```kotlin
val user1 = User(22, "mourad", "dayef")
val user2 = User(22, "mourad", "dayef")
println(user1 == user2)  // true - compares properties, not references
```

#### b) `toString()`

```kotlin
println(user1)  // User(age=22, firstName=mourad, lastName=dayef)
```

#### c) `copy()` Function

```kotlin
val olderUser = user1.copy(age = 23)  // Creates a copy with modified age
```

#### d) Component Functions

```kotlin
val (age, firstName, lastName) = user1  // Destructuring declaration
```

### 3. Class Body Features

#### a) Properties

- **Primary Constructor Properties**: Directly declared in the class header
- **Class Body Properties**: Additional properties defined in the class body

#### b) Extension Function

- `capitalizeName()` extends the `String` class
- Only visible within the `User` class (marked as `private`)
- Used for consistent name formatting

## Usage Example

```kotlin
fun main() {
    // Creating an instance with named arguments
    val user = User(
        age = 22,
        firstName = "mourad",
        lastName = "dayef"
    )

    // Using generated methods
    println(user)           // toString()
    println(user.name)      // Formatted name
    println(user.isAdult)   // Computed property

    // Copy example
    val olderUser = user.copy(age = 23)
    println(olderUser)

    // Destructuring
    val (age, firstName, _) = user
    println("$firstName is $age years old")
}
```

## Key Points About Data Classes

1. **Immutability**: Properties are `val` by default (recommended for data classes)
2. **Inheritance**: Data classes can inherit from other classes and implement interfaces
3. **No Abstract/Open/Inner**: Cannot be `abstract`, `open`, `sealed`, or `inner`
4. **Component Functions**: Enable destructuring declarations
5. **Copy Function**: Creates a modified copy of the object

## When to Use Data Classes

- When your class's main purpose is to hold data
- When you need value-based equality
- When you want automatic `toString()`, `equals()`, and `hashCode()`
- When you need to create modified copies of objects

---

## Enum Class Deep Dive

### Basic Structure

```kotlin
enum class Month(
    val title: String,        // Primary constructor property
    val subTitle: String,     // Primary constructor property
    val description: String,  // Primary constructor property
) {
    JAN(
        title = "January",
        subTitle = "The beginning of the year.",
        description = "A month of new starts, goals, motivation, and fresh energy."
    ),
    // ... other months ...
    DEC(
        title = "December",
        subTitle = "The closing chapter of the year.",
        description = "Associated with family, reflection, celebration, and hope."
    )
}
```

## What Makes This an Enum Class?

### 1. The `enum` Keyword

- Defines a fixed set of constants (enumerated types)
- Each constant is an instance of the enum class
- Can have properties, methods, and implement interfaces
- Can have a constructor to initialize each constant

### 2. Auto-generated Members

#### a) `name` and `ordinal`

```kotlin
val month = Month.DEC
println(month.name)     // "DEC"
println(month.ordinal)  // 11 (position in declaration order)
```

#### b) `values()` and `valueOf()`

```kotlin
// Get all enum constants
val allMonths = Month.values()

// Get enum constant by name
val january = Month.valueOf("JAN")
```

### 3. Class Body Features

#### a) Properties
- Each enum constant has its own set of property values
- Properties are defined in the primary constructor
- Can be accessed like regular class properties

#### b) Methods
- Can define methods that all enum constants share
- Can override methods for specific constants

## Usage Example

```kotlin
fun main() {
    // Display all months
    println("All months: ${Month.entries}")

    // Select month to display its information
    val month = selectMonth()

    // Display position in its enum declaration
    println("Ordinal: ${month.ordinal}")

    // Displays information about the selected month
    println("${month.name}: ${month.title} - ${month.subTitle}\nDescription: ${month.description}".trimIndent())
}

// Prompts the user to select a month by number
private fun selectMonth(): Month {
    while (true) {
        print("Enter month number (1-12): ")
        val input = readlnOrNull()?.trim() ?: continue

        // Handle empty input
        if (input.isBlank()) {
            println("Please enter a month number")
            continue
        }

        // Try to convert input to a month number
        val monthNumber = input.toIntOrNull() ?: run {
            println("Please enter a valid number")
            return@run null
        } ?: continue

        // Get the corresponding month or show error
        return Month.entries.getOrNull(monthNumber - 1) ?: run {
            println("Please enter a number between 1 and 12")
            return@run null
        } ?: continue
    }
}
```

## Key Points About Enum Classes

1. **Type Safety**: Provides type-safe way to work with fixed sets of constants
2. **Properties**: Can have properties with different values for each constant
3. **Methods**: Can define methods that all constants share
4. **Interfaces**: Can implement interfaces
5. **When Expressions**: Work seamlessly with Kotlin's `when` expressions

## When to Use Enum Classes

- When you have a fixed set of related constants
- When you need type safety for a set of values
- When each constant needs to have its own properties or behavior
- When you need to iterate over all possible values
- When you need to convert between strings and typed values

---

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

package enum_class_example

enum class Month(
    val title: String,        // Primary constructor property
    val subTitle: String,     // Primary constructor property
    val description: String,  // Primary constructor property
) {
    JAN(  // Enum constant
        title = "January",
        subTitle = "The beginning of the year.",
        description = "A month of new starts, goals, motivation, and fresh energy."
    ),
    FEB(  // Enum constant
        title = "February",
        subTitle = "The shortest month.",
        description = "Associated with love, emotions, warmth, and close connections."
    ),
    MAR(  // Enum constant
        title = "March",
        subTitle = "The bridge to spring.",
        description = "Represents change, movement, growth, and awakening."
    ),
    APR(  // Enum constant
        title = "April",
        subTitle = "The month of renewal.",
        description = "Known for fresh air, rain, flowers, and new life."
    ),
    MAY(  // Enum constant
        title = "May",
        subTitle = "A month full of beauty.",
        description = "Symbolizes blooming nature, happiness, balance, and calm."
    ),
    JUN(  // Enum constant
        title = "June",
        subTitle = "The start of summer.",
        description = "Connected to light, freedom, energy, and longer days."
    ),
    JUL(  // Enum constant
        title = "July",
        subTitle = "The heart of summer.",
        description = "Represents heat, travel, fun, and strong memories."
    ),
    AUG(  // Enum constant
        title = "August",
        subTitle = "A powerful summer month.",
        description = "Associated with strength, maturity, achievement, and confidence."
    ),
    SEP(  // Enum constant
        title = "September",
        subTitle = "The month of transition.",
        description = "Symbolizes focus, learning, responsibility, and reflection."
    ),
    OCT(  // Enum constant
        title = "October",
        subTitle = "A calm and thoughtful month.",
        description = "Known for change, balance, colors, and deeper thinking."
    ),
    NOV(  // Enum constant
        title = "November",
        subTitle = "A quiet and serious month.",
        description = "Represents gratitude, patience, endings, and preparation."
    ),
    DEC(  // Enum constant
        title = "December",
        subTitle = "The closing chapter of the year.",
        description = "Associated with family, reflection, celebration, and hope."
    ),
}
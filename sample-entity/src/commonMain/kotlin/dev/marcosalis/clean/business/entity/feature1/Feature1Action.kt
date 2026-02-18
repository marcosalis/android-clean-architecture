package dev.marcosalis.clean.business.entity.feature1

/**
 * This is a payload entity.
 * It represents business data created by the user.
 */
data class Feature1Action(
    val parameter1: Boolean,
    val parameter2: String
) {

    /**
     * Action validation according to platform-independent business rules.
     * (could be user input validation, etc).
     */
    fun canPerformAction(): Boolean = parameter1 && parameter2.isNotBlank()

}

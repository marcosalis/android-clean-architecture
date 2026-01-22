package dev.marcosalis.clean.business.entity.feature1

/**
 * This is a business entity.
 * It represents platform independent data and logic, using a language as close to the business as
 * possible.
 *
 * It can contain data representation of entities for real-world scenarios and data or business
 * rules that are specific to the Company or product.
 */
data class Feature1(
    val id: String,
    val parameter1: String
) {

    // business logic that doesn't depend on platform nor UI
    fun isParameterValid() = parameter1.isNotEmpty()

}

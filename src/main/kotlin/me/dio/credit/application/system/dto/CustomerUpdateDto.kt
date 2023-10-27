package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto (
    @field:NotEmpty(message = "Invalid first Name") val firstName: String,
    @field:NotEmpty(message = "Invalid last Name") val lastName: String,
    @field:NotNull(message = "Invalid income") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid zip code") val zipCode: String,
    @field:NotEmpty(message = "Invalid street") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}

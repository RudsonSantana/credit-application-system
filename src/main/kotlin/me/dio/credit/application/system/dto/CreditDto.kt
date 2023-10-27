package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid credit value")
    @field:Positive(message = "Credit needs to be positive") val creditValue: BigDecimal,
    @field:Future(message = "Invalid day first of installment") val dayFirstOfInstallment: LocalDate,
    @field:NotNull(message = "Invalid number of installment")
    @field:Positive(message = "Number of installment needs to be positive")
    @field:Max(value = 60, message = "Number of installments should not be greater than 60") val numberOfInstallment: Int,
    @field:NotNull(message = "Invalid customer id")
    @field:Positive(message = "Customer id needs to be positive") val customerId: Long
    ) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )
}

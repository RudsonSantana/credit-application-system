package me.dio.credit.application.system.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
//@Table(name = "Client")
data class Customer(
        @Column(nullable = false) var firstName: String = "",
        @Column(nullable = false) var lastName: String = "",
        @Column(nullable = false, unique = true) val cpf: String = "",
        @Column(nullable = false) val income: BigDecimal = BigDecimal.ZERO,
        @Column(nullable = false, unique = true) var email: String = "",
        @Column(nullable = false) var password: String = "",
        @Column(nullable = false) @Embedded var address: Adress = Adress(),
        @field:Column(nullable = false) @field:OneToMany(
                cascade = [CascadeType.REMOVE, CascadeType.PERSIST],
                fetch = FetchType.LAZY, mappedBy = "customer")
        var credits: List<Credit> = mutableListOf(),
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)

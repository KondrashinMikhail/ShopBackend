package mk.ru.carshop.persistence.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.UuidGenerator

@Entity
data class Car(
    @Id
    @UuidGenerator
    val id: UUID? = null,
    @Column(nullable = false)
    var manufacturer: String? = null,
    @Column(nullable = false)
    var model: String? = null,
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    var registrationDate: LocalDate? = LocalDate.now(),
    @Column(nullable = false)
    var deleted: Boolean? = false,
    @Column(nullable = false)
    var price: BigDecimal? = null,
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(nullable = false)
    var owner: AppUser? = null
)
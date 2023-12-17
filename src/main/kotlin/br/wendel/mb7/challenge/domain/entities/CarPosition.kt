package br.wendel.mb7.challenge.domain.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "car_position")
data class CarPosition(

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long?,

    @Column(name = "carPlate", nullable = false)
    val carPlate: String,

    @Column(name = "positionDate", nullable = true)
    val positionDate: LocalDateTime?,

    @Column(name = "velocity", nullable = false)
    val velocity: String,

    @Column(name = "latitude", nullable = false)
    val latitude: Double,

    @Column(name = "longitude", nullable = false)
    val longitude: Double,

    @Column(name = "ignition", nullable = false)
    val ignition: Boolean
)

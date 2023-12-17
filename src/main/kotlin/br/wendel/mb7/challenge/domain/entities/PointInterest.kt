package br.wendel.mb7.challenge.domain.entities

import javax.persistence.*

@Entity
@Table(name = "point_interest")
data class PointInterest(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long?,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "ray", nullable = false)
    val ray: Double,

    @Column(name = "latitude", nullable = false)
    val latitude: Double,

    @Column(name = "longitude", nullable = false)
    val longitude: Double
)

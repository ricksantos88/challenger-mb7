package br.wendel.mb7.challenge.domain.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PointInterestDTO(

    @JsonProperty("name")
    val name: String,

    @JsonProperty("ray")
    val ray: Double,

    @JsonProperty("latitude")
    val latitude : Double,

    @JsonProperty("longitude")
    val longitude: Double,
)

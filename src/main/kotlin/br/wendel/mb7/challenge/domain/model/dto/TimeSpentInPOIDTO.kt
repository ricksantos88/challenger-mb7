package br.wendel.mb7.challenge.domain.model.dto

import java.time.Duration

data class TimeSpentInPOIDTO(
    val poiName: String, val timeSpent: Duration
)

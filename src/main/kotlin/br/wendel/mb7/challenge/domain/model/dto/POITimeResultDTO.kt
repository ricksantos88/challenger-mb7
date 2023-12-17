package br.wendel.mb7.challenge.domain.model.dto

import java.time.LocalDateTime

data class POITimeResultDTO(
        val poiId: Long,
        val poiName: String,
        val positionDate: LocalDateTime,
        val totalTimeInSeconds: Long
)
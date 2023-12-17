package br.wendel.mb7.challenge.modules.carpositionmodule.service

import br.wendel.mb7.challenge.domain.model.dto.POITimeResultDTO
import br.wendel.mb7.challenge.domain.model.dto.TimeSpentInPOIDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import java.time.LocalDateTime

interface CarPositionService {
    fun calculateTimeSpentInPOIs(carPlate: String?, startDate: LocalDateTime?, endDate: LocalDateTime?, pageRequest: PageRequest): Page<TimeSpentInPOIDTO>
}
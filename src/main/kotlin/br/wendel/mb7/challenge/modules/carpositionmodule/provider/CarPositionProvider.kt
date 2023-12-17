package br.wendel.mb7.challenge.modules.carpositionmodule.provider

import br.wendel.mb7.challenge.domain.entities.CarPosition
import java.time.LocalDateTime

interface CarPositionProvider {
    fun findByCarPlateAndPositionDateBetween(carPlate: String?, startDate: LocalDateTime?, endDate: LocalDateTime?): List<CarPosition>
}
package br.wendel.mb7.challenge.modules.carpositionmodule.provider

import br.wendel.mb7.challenge.domain.repositories.CarPositionRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CarPositionProviderImpl(
    private val carPositionRepository: CarPositionRepository
): CarPositionProvider{
    override fun findByCarPlateAndPositionDateBetween(carPlate: String?, startDate: LocalDateTime?, endDate: LocalDateTime?) =
        carPositionRepository.findByCarPlateAndPositionDateBetween(carPlate, startDate, endDate)

}
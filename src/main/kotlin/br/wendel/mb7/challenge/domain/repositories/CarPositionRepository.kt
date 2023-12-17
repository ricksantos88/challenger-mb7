package br.wendel.mb7.challenge.domain.repositories

import br.wendel.mb7.challenge.domain.entities.CarPosition
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface CarPositionRepository: JpaRepository<CarPosition, Long> {

    fun findByCarPlateAndPositionDateBetween(carPlate: String?, startDate: LocalDateTime?, endDate: LocalDateTime?): List<CarPosition>

}
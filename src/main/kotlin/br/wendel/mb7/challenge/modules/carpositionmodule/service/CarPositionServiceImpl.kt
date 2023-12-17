package br.wendel.mb7.challenge.modules.carpositionmodule.service

import br.wendel.mb7.challenge.domain.entities.CarPosition
import br.wendel.mb7.challenge.domain.entities.PointInterest
import br.wendel.mb7.challenge.domain.model.dto.POITimeResultDTO
import br.wendel.mb7.challenge.domain.model.dto.TimeSpentInPOIDTO
import br.wendel.mb7.challenge.modules.carpositionmodule.provider.CarPositionProvider
import br.wendel.mb7.challenge.modules.pointInterest.provider.PointInterestProvider
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.LocalDateTime
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Service
class CarPositionServiceImpl(
    private val carPositionProvider: CarPositionProvider,
    private val pointInterestProvider: PointInterestProvider
): CarPositionService {

    private val logger = LoggerFactory.getLogger(CarPositionServiceImpl::class.java)

    override fun calculateTimeSpentInPOIs(carPlate: String?, startDate: LocalDateTime?, endDate: LocalDateTime?, pageRequest: PageRequest): Page<TimeSpentInPOIDTO> {
        logger.info("start process calculate time spent in POIs to car plate: $carPlate")
        TODO("Logic code here!")
    }

}
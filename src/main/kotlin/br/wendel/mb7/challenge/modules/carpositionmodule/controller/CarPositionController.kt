package br.wendel.mb7.challenge.modules.carpositionmodule.controller

import br.wendel.mb7.challenge.domain.model.dto.TimeSpentInPOIDTO
import br.wendel.mb7.challenge.modules.carpositionmodule.service.CarPositionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/v1/car-positions")
class CarPositionController(
    private val carPositionService: CarPositionService
) {

    @GetMapping("/poi-times", produces = ["application/json"])
    fun getVehicleTimeInEachPOI(
        @RequestParam(required = false) carPlate: String?,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startDate: LocalDateTime?,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endDate: LocalDateTime?,
        @RequestParam(name = "page", defaultValue = "0") page: Int,
        @RequestParam(name = "size", defaultValue = "10") size: Int,
        @RequestParam(name = "sort", defaultValue = "positionDate") sort: String,
        @RequestParam(name = "direction", defaultValue = "DESC") direction: String,
    ): ResponseEntity<Page<TimeSpentInPOIDTO>> =
        ResponseEntity.ok(carPositionService.calculateTimeSpentInPOIs(
            carPlate,
            startDate,
            endDate,
            PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(direction), sort))
        )
    )

}
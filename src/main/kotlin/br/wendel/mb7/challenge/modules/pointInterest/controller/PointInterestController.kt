package br.wendel.mb7.challenge.modules.pointInterest.controller

import br.wendel.mb7.challenge.domain.model.dto.PointInterestDTO
import br.wendel.mb7.challenge.domain.model.dto.PointInterestRequestDTO
import br.wendel.mb7.challenge.modules.pointInterest.service.PointInterestService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/point-interest")
class PointInterestController(
    private val pointInterestService: PointInterestService
) {

    @PostMapping(produces = ["application/json"])
    fun getVehicleTimeInEachPOI(@RequestBody pointInterestRequestDto: PointInterestRequestDTO): ResponseEntity<PointInterestDTO> =
        ResponseEntity.ok(pointInterestService.savePointInterest(pointInterestRequestDto))

}
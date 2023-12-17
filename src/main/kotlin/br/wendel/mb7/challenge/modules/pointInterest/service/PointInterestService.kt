package br.wendel.mb7.challenge.modules.pointInterest.service

import br.wendel.mb7.challenge.domain.entities.PointInterest
import br.wendel.mb7.challenge.domain.model.dto.PointInterestDTO
import br.wendel.mb7.challenge.domain.model.dto.PointInterestRequestDTO

interface PointInterestService {
    fun findAllPointInterest(): List<PointInterest>
    fun savePointInterest(pointInterestRequestDto: PointInterestRequestDTO): PointInterestDTO?
}
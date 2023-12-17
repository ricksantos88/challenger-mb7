package br.wendel.mb7.challenge.modules.pointInterest.service

import br.wendel.mb7.challenge.domain.entities.PointInterest
import br.wendel.mb7.challenge.domain.model.dto.PointInterestDTO
import br.wendel.mb7.challenge.domain.model.dto.PointInterestRequestDTO
import br.wendel.mb7.challenge.modules.pointInterest.provider.PointInterestProvider
import org.springframework.stereotype.Service

@Service
class PointInterestServiceImpl(
    private val pointInterestProvider: PointInterestProvider
): PointInterestService {

    override fun findAllPointInterest(): List<PointInterest> = pointInterestProvider.findAllPointInterest()

    override fun savePointInterest(pointInterestRequestDto: PointInterestRequestDTO): PointInterestDTO? =
        TODO("logic and validation to create point of interest")


}
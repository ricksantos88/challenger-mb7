package br.wendel.mb7.challenge.modules.pointInterest.provider

import br.wendel.mb7.challenge.domain.entities.PointInterest
import br.wendel.mb7.challenge.domain.repositories.PointInterestRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class PointInterestProviderImpl(
    private val pointInterestRepository: PointInterestRepository
): PointInterestProvider {

    override fun findAllPointInterest(): List<PointInterest> = pointInterestRepository.findAll()

    override fun savePointInterest(pointInterest: PointInterest): PointInterest =
        pointInterestRepository.save(pointInterest)
}
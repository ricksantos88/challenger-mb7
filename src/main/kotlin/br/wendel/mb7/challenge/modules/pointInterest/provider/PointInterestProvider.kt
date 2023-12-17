package br.wendel.mb7.challenge.modules.pointInterest.provider

import br.wendel.mb7.challenge.domain.entities.PointInterest

interface PointInterestProvider {
    fun findAllPointInterest(): List<PointInterest>
    fun savePointInterest(pointInterest: PointInterest): PointInterest
}
package br.wendel.mb7.challenge.domain.repositories

import br.wendel.mb7.challenge.domain.entities.PointInterest
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PointInterestRepository: JpaRepository<PointInterest, Long> {
}
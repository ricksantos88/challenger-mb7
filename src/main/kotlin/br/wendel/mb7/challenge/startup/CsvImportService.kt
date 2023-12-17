package br.wendel.mb7.challenge.startup

import br.wendel.mb7.challenge.domain.entities.CarPosition
import br.wendel.mb7.challenge.domain.entities.PointInterest
import br.wendel.mb7.challenge.domain.repositories.CarPositionRepository
import br.wendel.mb7.challenge.domain.repositories.PointInterestRepository
import com.opencsv.CSVReaderBuilder
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.InputStreamReader
import java.time.LocalDateTime
import java.time.Month
import java.util.*
import javax.annotation.PostConstruct
import javax.transaction.Transactional

@Service
class CsvImportService(
        private val carPositionRepository: CarPositionRepository,
        private val pointInterestRepository: PointInterestRepository
) {

    @PostConstruct
    @Transactional
    fun initializeDatabase() {
        importCarPositions()
        importPointInterests()
    }

    @Transactional
    fun importCarPositions() {
        processCsvFile("posicoes.csv") { line ->

           val positionDate: LocalDateTime? = convertToLocalDateTime(line)

            val carPosition = CarPosition(
               id = null,
               carPlate = line[0],
               positionDate = positionDate,
               velocity = line[2],
               latitude = line[3].toDouble(),
               longitude = line[4].toDouble(),
               ignition = line[5].toBoolean()
           )
           carPositionRepository.save(carPosition)
        }
    }

    private fun convertToLocalDateTime(line: List<String>): LocalDateTime? {
        val regex = Regex("([a-zA-Z]+) ([a-zA-Z]+) (\\d{1,2}) (\\d{4}) (\\d{2}):(\\d{2}):(\\d{2}) GMT([+-]\\d{4}) \\(.+\\)")
        val matchResult = regex.matchEntire(line[1])
        val positionDate: LocalDateTime?

        if (matchResult != null) {
            val (_, mes, dia, ano, hora, minuto, segundo, offset) = matchResult.destructured

            val mesEnum = Month.valueOf(mes.toUpperCase(Locale.ENGLISH))
            positionDate = LocalDateTime.of(ano.toInt(), mesEnum, dia.toInt(), hora.toInt(), minuto.toInt(), segundo.toInt())
        } else {
            return null
        }
        return positionDate
    }

    @Transactional
    fun importPointInterests() {
        processCsvFile("base_pois_def.csv") { line ->
            val pointInterest = PointInterest(
                id = null,
                name = line[0],
                ray = line[1].toDouble(),
                latitude = line[2].toDouble(),
                longitude = line[3].toDouble()
            )
            pointInterestRepository.save(pointInterest)
        }
    }

    private fun processCsvFile(fileName: String, saveFunction: (List<String>) -> Unit) {
        val fileResource = ClassPathResource(fileName)

        try {
            fileResource.inputStream.use { inputStream ->
                val reader = InputStreamReader(inputStream)
                val csvReader = CSVReaderBuilder(reader).withSkipLines(1).build()

                csvReader.readAll().forEach { line ->
                    saveFunction(line.toList())
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
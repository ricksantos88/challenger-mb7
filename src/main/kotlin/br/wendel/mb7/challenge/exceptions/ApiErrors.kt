package br.wendel.mb7.challenge.exceptions

import org.springframework.validation.FieldError
import org.springframework.web.server.ResponseStatusException

class ApiErrors {

    private var errors: MutableList<String> = ArrayList()

    constructor(fieldsErrors: List<FieldError>) {
        fieldsErrors.forEach {
            val defaultMessage = "${it.field} ${it.defaultMessage}"
            errors.add(defaultMessage)
        }
    }

    constructor(businessException: BusinessException) {
        businessException.message?.let { errors.add(it) }
    }

    constructor(responseStatusException: ResponseStatusException) {
        responseStatusException.reason?.let { errors.add(it) }
    }

    fun getErrors(): List<String?> {
        return errors
    }

}
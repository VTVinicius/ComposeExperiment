package com.example.domain.usecase.referenciadouso

import com.example.domain.core.UseCase
import com.example.domain.exception.MissingParamsException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class ExampleUseCase(
    scope: CoroutineScope,
    private val string: String
) : UseCase<Unit, ExampleUseCase.Params>(scope) {

    override fun run(params: Params?): Flow<Unit> = when (params) {
        null -> throw MissingParamsException()
        else -> params.user
    }

    data class Params(
        val user: Flow<Unit>
    )
}

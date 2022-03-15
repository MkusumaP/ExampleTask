package com.example.exampletask

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UseCase {
    abstract class UseCase<out Type, in Params> {

        abstract suspend fun run(params: Params): Type
    }

    abstract class FlowUseCase<out Type, in Params> : UseCase<Type, Params>() {
        operator fun invoke(params: Params): Flow<Type> {
            return flow {
                val result = run(params)
                emit(result)
            }
        }
    }

    abstract class NewFlowUseCase<out Type, in Params> where Type : Any {

        abstract fun run(params: Params): Flow<Type>

        operator fun invoke(params: Params): Flow<Type> = run(params)
    }

    object None

}

package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.Workout
import com.wiseassblog.domain.repository.IWorkoutRepository

/**
 * When user wishes to delete workout
 * 1. Delete Workout in repository
 */
class DeleteWorkout(private val repository: IWorkoutRepository): UseCaseWithParams<String, ResultWrapper<Exception,Unit>>(){
    override suspend fun buildUseCase(params: String): ResultWrapper<Exception,Unit> {
        return repository.deleteWorkout(params)
    }
}
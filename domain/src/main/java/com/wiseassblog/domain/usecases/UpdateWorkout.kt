package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.Workout
import com.wiseassblog.domain.repository.IWorkoutRepository

/**
 * When user wishes to update or create a new workout
 * 1. Update Workout in repository
 */
class UpdateWorkout(private val repository: IWorkoutRepository): UseCaseWithParams<Workout, ResultWrapper<Exception,Unit>>(){
    override suspend fun buildUseCase(params: Workout): ResultWrapper<Exception,Unit> {
        return repository.updateWorkout(params)
    }
}
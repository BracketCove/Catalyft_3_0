package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.Workout
import com.wiseassblog.domain.repository.IWorkoutRepository

/**
 * When a user opens the application, retrieve all workouts on the current day
 * 1. Request workout list from repository
 */
class GetWorkoutsByMonth(private val repository: IWorkoutRepository): UseCaseWithParams<String, ResultWrapper<Exception, List<Workout>>>(){
    override suspend fun buildUseCase(params: String): ResultWrapper<Exception, List<Workout>> {
        return repository.getWorkoutsByDate(params, DateRange.MONTH)
    }

}
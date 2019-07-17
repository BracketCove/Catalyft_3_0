package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.Workout
import com.wiseassblog.domain.domainmodel.WorkoutTemplate
import com.wiseassblog.domain.repository.IWorkoutRepository
import com.wiseassblog.domain.repository.IWorkoutTemplateRepository

/**
 * When a user wants to view a list of Workout templates
 * 1. Retrieve Workout Templates from repo
 */
class GetWorkoutTemplates(private val repository: IWorkoutTemplateRepository): UseCaseWithParams<Boolean, ResultWrapper<Exception, List<WorkoutTemplate>>>(){
    override suspend fun buildUseCase(params: Boolean): ResultWrapper<Exception, List<WorkoutTemplate>> {
        return repository.getWorkoutTemplates(params)
    }
}
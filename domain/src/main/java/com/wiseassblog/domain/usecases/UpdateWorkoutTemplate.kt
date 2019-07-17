package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.Workout
import com.wiseassblog.domain.domainmodel.WorkoutTemplate
import com.wiseassblog.domain.repository.IWorkoutRepository
import com.wiseassblog.domain.repository.IWorkoutTemplateRepository

/**
 * When a user wants to add a new workout template to the repo
 * 1. Give workout template to repo
 */
class UpdateWorkoutTemplate(private val repository: IWorkoutTemplateRepository): UseCaseWithParams<WorkoutTemplate, ResultWrapper<Exception, Unit>>(){
    override suspend fun buildUseCase(params: WorkoutTemplate): ResultWrapper<Exception, Unit> {
        return repository.updateWorkoutTemplate(params)
    }
}
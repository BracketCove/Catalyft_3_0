package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.Workout
import com.wiseassblog.domain.domainmodel.WorkoutTemplate
import com.wiseassblog.domain.repository.IWorkoutRepository
import com.wiseassblog.domain.repository.IWorkoutTemplateRepository

/**
 * When a user wants to remove a  workout template from the repo
 * 1. Delete workout template from
 */
class DeleteWorkoutTemplate(private val repository: IWorkoutTemplateRepository): UseCaseWithParams<Int, ResultWrapper<Exception, Unit>>(){
    override suspend fun buildUseCase(params: Int): ResultWrapper<Exception, Unit> {
        return repository.deleteWorkoutTemplate(params)
    }
}
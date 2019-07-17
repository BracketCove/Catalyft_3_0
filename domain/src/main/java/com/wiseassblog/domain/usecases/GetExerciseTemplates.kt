package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.ExerciseTemplate
import com.wiseassblog.domain.domainmodel.Workout
import com.wiseassblog.domain.repository.IExerciseTemplateRepository
import com.wiseassblog.domain.repository.IWorkoutRepository

/**
 * When user wishes to view custom exercise templates
 * 1. retrieve custom exercise templates
 */
class GetExerciseTemplates(private val repository: IExerciseTemplateRepository) :
    UseCaseWithParams<List<String>, ResultWrapper<Exception, List<ExerciseTemplate>>>() {
    override suspend fun buildUseCase(params: List<String>): ResultWrapper<Exception, List<ExerciseTemplate>> {
        return repository.getExerciseTemplatesByFilter(params)
    }
}
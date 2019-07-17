package com.wiseassblog.domain.usecases

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.domainmodel.WorkoutTemplate
import com.wiseassblog.domain.repository.IWorkoutRepository

class LoadWorkoutFromTemplate(private val repository: IWorkoutRepository): UseCaseWithParams<WorkoutTemplate, ResultWrapper<Exception, Unit>>(){
    override suspend fun buildUseCase(params: WorkoutTemplate): ResultWrapper<Exception, Unit> {
        return repository.updateWorkout(params.workout)
    }
}
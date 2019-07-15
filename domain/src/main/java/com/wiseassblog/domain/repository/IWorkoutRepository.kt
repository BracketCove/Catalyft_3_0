package com.wiseassblog.domain.repository

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.constants.DateRange
import com.wiseassblog.domain.domainmodel.Workout

interface IWorkoutRepository {
    fun getWorkoutsByDate(date:String, selection: DateRange): ResultWrapper<Exception, List<Workout>>
    fun updateWorkout(workout: Workout): ResultWrapper<Exception, Unit>
    fun deleteWorkout(creationDateId: String): ResultWrapper<Exception, Unit>
}

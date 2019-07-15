package com.wiseassblog.domain.repository

import com.wiseassblog.domain.ResultWrapper
import com.wiseassblog.domain.domainmodel.WorkoutTemplate

interface IWorkoutTemplateRepository {
    fun getWorkoutTemplates(getCustom:Boolean):ResultWrapper<Exception, List<WorkoutTemplate>>
    fun deleteWorkoutTemplate(id:Int):ResultWrapper<Exception, Unit>
    fun updateWorkoutTemplate(template:WorkoutTemplate):ResultWrapper<Exception, Unit>
}
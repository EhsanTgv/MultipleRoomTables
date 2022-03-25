package com.taghavi.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.taghavi.multipleroomtables.entities.School
import com.taghavi.multipleroomtables.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)

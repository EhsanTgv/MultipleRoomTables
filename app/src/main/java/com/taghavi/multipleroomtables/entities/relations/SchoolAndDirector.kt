package com.taghavi.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.taghavi.multipleroomtables.entities.Director
import com.taghavi.multipleroomtables.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn="schoolName",
        entityColumn="schoolName"
    )
    val director: Director
)

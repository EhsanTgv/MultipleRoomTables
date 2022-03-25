package com.taghavi.multipleroomtables

import androidx.room.*
import com.taghavi.multipleroomtables.entities.Director
import com.taghavi.multipleroomtables.entities.School
import com.taghavi.multipleroomtables.entities.Student
import com.taghavi.multipleroomtables.entities.relations.SchoolAndDirector
import com.taghavi.multipleroomtables.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudent(schoolName: String): List<SchoolWithStudents>
}
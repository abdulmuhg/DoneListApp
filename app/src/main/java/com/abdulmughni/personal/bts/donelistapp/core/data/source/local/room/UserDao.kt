package com.abdulmughni.personal.bts.donelistapp.core.data.source.local.room

import androidx.room.*
import com.abdulmughni.personal.bts.donelistapp.core.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE email =:email AND password =:password")
    fun login(email: String, password: String): Flow<UserEntity>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun register(userEntity: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

}
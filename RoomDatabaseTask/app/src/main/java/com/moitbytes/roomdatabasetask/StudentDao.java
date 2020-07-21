package com.moitbytes.roomdatabasetask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao
{
    //Here we will create the queries
    @Insert
    public void insert(Student student);

    @Query("SELECT * FROM studentdata")
    public LiveData<List<Student>> readData();

    @Delete
    public void delete(Student student);

    @Update
    public void update(Student student);

}

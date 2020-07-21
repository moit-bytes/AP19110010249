package com.moitbytes.roomdatabasetask;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase
{
    public abstract StudentDao myDao(); //Abstract Method

    public static StudentDatabase database;

    public static synchronized StudentDatabase getDatabase(Context context)
    {
        if(database==null)
        {
            database = Room.databaseBuilder(context, StudentDatabase.class, "myDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

}


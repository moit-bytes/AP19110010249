package com.moitbytes.roomdatabasetask;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository
{
    StudentDatabase studentDatabase;
    LiveData<List<Student>> readData;

    public Repository(Application application)
    {
        studentDatabase = StudentDatabase.getDatabase(application);
        readData = studentDatabase.myDao().readData();
    }

    /*This is insert Method*/
    public void insert(Student student)
    {
        new InsertTask().execute(student);
    }

    /*This is read Method*/
    public LiveData<List<Student>> readALLData()
    {
        return readData;
    }

    /*This is update Method*/
    public void update(Student student)
    {
        new UpdateTask().execute(student);
    }

    /*This is delete Method*/
    public void delete(Student student)
    {
        new DeleteTask().execute(student);
    }

    class InsertTask extends AsyncTask<Student, Void, Void>
    {

        @Override
        protected Void doInBackground(Student... students)
        {
            studentDatabase.myDao().insert(students[0]);
            return null;
        }
    }

    class UpdateTask extends AsyncTask<Student, Void, Void>
    {

        @Override
        protected Void doInBackground(Student... students)
        {
            studentDatabase.myDao().update(students[0]);
            return null;
        }
    }

    class DeleteTask extends AsyncTask<Student, Void, Void>
    {

        @Override
        protected Void doInBackground(Student... students)
        {
            studentDatabase.myDao().delete(students[0]);
            return null;
        }
    }
}

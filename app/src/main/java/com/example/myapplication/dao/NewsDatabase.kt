package com.example.myapplication.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.models.News

@Database(entities = [News::class],version = 1,exportSchema = true)
public abstract class NewsDatabase: RoomDatabase() {

    private var newContext: Context? = null
    abstract fun newsDao(): NewsDao?
    private val TAG = "NewsDatabase"



    companion object{
        private var sInstance: NewsDatabase? = null
        fun getInstance(context: Context): NewsDatabase {
        if (sInstance == null) {

            sInstance = Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "NOTES_DATABASE"
            )
                .fallbackToDestructiveMigration().build()
        }
        return sInstance as NewsDatabase
    }

    fun destroyDataBase(){
        sInstance = null
        }
    }

}
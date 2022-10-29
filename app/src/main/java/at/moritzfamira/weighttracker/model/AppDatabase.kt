package at.moritzfamira.weighttracker.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(Converters::class)
@Database(entities = [Weight::class],version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun weightDao(): WeightDao
}
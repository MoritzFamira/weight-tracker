package at.moritzfamira.weighttracker.datamodel

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters(Converters::class)
@Database(entities = [Weight::class],version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun weightDao(): WeightDao
}
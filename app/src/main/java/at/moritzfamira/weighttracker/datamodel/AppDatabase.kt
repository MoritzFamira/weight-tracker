package at.moritzfamira.weighttracker.datamodel

import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@TypeConverters(Converters::class)
@Database(entities = [Weight::class],version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun weightDao(): WeightDao

}
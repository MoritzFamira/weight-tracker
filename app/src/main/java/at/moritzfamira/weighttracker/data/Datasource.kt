package at.moritzfamira.weighttracker.data

import android.content.Context
import androidx.room.Room
import at.moritzfamira.weighttracker.model.AppDatabase
import at.moritzfamira.weighttracker.model.Weight

class Datasource {
    fun loadWeights(context: Context): List<Weight> {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).fallbackToDestructiveMigration().build()
        val weightDao = db.weightDao()

        return weightDao.getAll()
    }
}
package at.moritzfamira.weighttracker.datamodel

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeightDao {
    @Query("select * from w_weights")
    fun getAll(): List<Weight>
    @Query("select * from w_weights order by w_date desc")
    fun getNewestFirst(): List<Weight>
    @Insert
    fun insert(weight:Weight)
    @Delete
    fun delete(weight: Weight)
}
package at.moritzfamira.weighttracker.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(primaryKeys = ["w_date","w_value"], tableName = "w_weights")
data class Weight(
    @ColumnInfo(name = "w_date")
    val dateOfWeight: Date,
    @ColumnInfo(name = "w_value")
    val value: Double
)

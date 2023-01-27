package at.moritzfamira.weighttracker.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "w_weights")
data class Weight(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "w_id")
    val weightId: Int?,
    @ColumnInfo(name = "w_date")
    val dateOfWeight: LocalDateTime,
    @ColumnInfo(name = "w_value")
    val value: Double
)

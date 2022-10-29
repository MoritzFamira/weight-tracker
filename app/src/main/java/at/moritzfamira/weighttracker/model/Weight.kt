package at.moritzfamira.weighttracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.Date

@Entity(primaryKeys = ["dateOfWeight","value"])
data class Weight(
    @ColumnInfo val dateOfWeight: Date,
    @ColumnInfo val value: Double
)

package at.moritzfamira.weighttracker.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(primaryKeys = ["dateOfWeight","value"])
data class Weight(
    @ColumnInfo val dateOfWeight: Date,
    @ColumnInfo val value: Long
)

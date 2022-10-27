package at.moritzfamira.weighttracker.datamodel

import androidx.room.TypeConverter
import java.util.Date

public class Converters {
    @TypeConverter
    public fun fromTimestamp(value: Long): Date? {
        return if (value == null) {
            null
        } else {
            Date(value)
        }
    }

    @TypeConverter
    public fun dateToTimestamp(date: Date): Long? {
        return if (date == null) {
            null
        } else {
            date.time
        }
    }
}
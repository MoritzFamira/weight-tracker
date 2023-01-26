package at.moritzfamira.weighttracker.datamodel

import androidx.room.TypeConverter
import java.time.*
import java.util.Date

public class Converters {
    private val zoneId: ZoneId = ZoneId.ofOffset("UTC", ZoneOffset.UTC)
    @TypeConverter
    public fun fromTimestamp(value: Long): LocalDateTime? {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(value),zoneId)
    }

    @TypeConverter
    public fun dateToTimestamp(date: LocalDateTime): Long? {
        return date.toInstant(ZoneOffset.UTC).toEpochMilli()

    }
}
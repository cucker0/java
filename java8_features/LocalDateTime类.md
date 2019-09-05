LocalDateTime类
==

# 字段属性
```text
static LocalDateTime MAX 
The maximum supported LocalDateTime, '+999999999-12-31T23:59:59.999999999'.

static LocalDateTime MIN 
The minimum supported LocalDateTime, '-999999999-01-01T00:00:00'.
```

# 构造器
只有一个私有的构造器
```text
    private LocalDateTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }
```

# 方法
```text
adjustInto​(Temporal temporal) 
Adjusts the specified temporal object to have the same date and time as this object.

OffsetDateTime atOffset​(ZoneOffset offset) 
Combines this date-time with an offset to create an OffsetDateTime.

ZonedDateTime atZone​(ZoneId zone) 
Combines this date-time with a time-zone to create a ZonedDateTime.

int compareTo​(ChronoLocalDateTime<?> other) 
Compares this date-time to another date-time.

boolean equals​(Object obj) 
Checks if this date-time is equal to another date-time.

String format​(DateTimeFormatter formatter) 
Formats this date-time using the specified formatter.

static LocalDateTime from​(TemporalAccessor temporal) 
Obtains an instance of LocalDateTime from a temporal object.

int get​(TemporalField field) 
Gets the value of the specified field from this date-time as an int.

int getDayOfMonth() 
Gets the day-of-month field.
获取月份中的天数，范围[1, 31]

DayOfWeek getDayOfWeek() 
Gets the day-of-week field, which is an enum DayOfWeek.
返回星期几，DayOfWeek的枚举值

int getDayOfYear() 
Gets the day-of-year field.
获取年份中的天数，范围[1, 366]

int getHour() 
Gets the hour-of-day field.
获取天中的小时数

long getLong​(TemporalField field) 
Gets the value of the specified field from this date-time as a long.

int getMinute() 
Gets the minute-of-hour field.
获取时间中的分值

Month getMonth() 
Gets the month-of-year field using the Month enum.
获取月份，返回一个Moth枚举值

int getMonthValue() 
Gets the month-of-year field from 1 to 12.
获取月份值

int getNano() 
Gets the nano-of-second field.
获取纳秒值

int getSecond() 
Gets the second-of-minute field.
获取秒值

int getYear() 
Gets the year field.
获取年份值

int hashCode() 
A hash code for this date-time.

boolean isAfter​(ChronoLocalDateTime<?> other) 
Checks if this date-time is after the specified date-time.

boolean isBefore​(ChronoLocalDateTime<?> other) 
Checks if this date-time is before the specified date-time.

boolean isEqual​(ChronoLocalDateTime<?> other) 
Checks if this date-time is equal to the specified date-time.

boolean isSupported​(TemporalField field) 
Checks if the specified field is supported.

boolean isSupported​(TemporalUnit unit) 
Checks if the specified unit is supported.

LocalDateTime minus​(long amountToSubtract, TemporalUnit unit) 
Returns a copy of this date-time with the specified amount subtracted.

LocalDateTime minus​(TemporalAmount amountToSubtract) 
Returns a copy of this date-time with the specified amount subtracted.


LocalDateTime minusDays​(long days) 
Returns a copy of this LocalDateTime with the specified number of days subtracted.
复制此LocalDateTime对象，复制对象减days天，返回复制的LocalDateTime对象

LocalDateTime minusHours​(long hours) 
Returns a copy of this LocalDateTime with the specified number of hours subtracted.
复制此LocalDateTime对象，复制对象减hours个小时，返回复制的LocalDateTime对象

LocalDateTime minusMinutes​(long minutes) 
Returns a copy of this LocalDateTime with the specified number of minutes subtracted.
复制此LocalDateTime对象，复制对象减minutes分钟，返回复制的LocalDateTime对象

LocalDateTime minusMonths​(long months) 
Returns a copy of this LocalDateTime with the specified number of months subtracted.
复制此LocalDateTime对象，复制对象减months个月，返回复制的LocalDateTime对象

LocalDateTime minusNanos​(long nanos) 
Returns a copy of this LocalDateTime with the specified number of nanoseconds subtracted.
复制此LocalDateTime对象，复制对象减nanos纳秒，返回复制的LocalDateTime对象

LocalDateTime minusSeconds​(long seconds) 
Returns a copy of this LocalDateTime with the specified number of seconds subtracted.
复制此LocalDateTime对象，复制对象减seconds秒，返回复制的LocalDateTime对象

LocalDateTime minusWeeks​(long weeks) 
Returns a copy of this LocalDateTime with the specified number of weeks subtracted.
复制此LocalDateTime对象，复制对象减weeks周，返回复制的LocalDateTime对象

LocalDateTime minusYears​(long years) 
Returns a copy of this LocalDateTime with the specified number of years subtracted.
复制此LocalDateTime对象，复制对象减years年，返回复制的LocalDateTime对象

static LocalDateTime now() 
Obtains the current date-time from the system clock in the default time-zone.
根据当前日期时间创建对象，时区为系统时钟默认的设置的时区

static LocalDateTime now​(Clock clock) 
Obtains the current date-time from the specified clock.
根据当前日期时间创建对象，指定时钟为clock

static LocalDateTime now​(ZoneId zone) 
Obtains the current date-time from the system clock in the specified time-zone.
根据当前日期时间创建对象，并指定时区为对象zone

static LocalDateTime of​(int year, int month, int dayOfMonth, int hour, int minute) 
Obtains an instance of LocalDateTime from year, month, day, hour and minute, setting the second and nanosecond to zero.

static LocalDateTime of​(int year, int month, int dayOfMonth, int hour, int minute, int second) 
Obtains an instance of LocalDateTime from year, month, day, hour, minute and second, setting the nanosecond to zero.

static LocalDateTime of​(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) 
Obtains an instance of LocalDateTime from year, month, day, hour, minute, second and nanosecond.

static LocalDateTime of​(int year, Month month, int dayOfMonth, int hour, int minute) 
Obtains an instance of LocalDateTime from year, month, day, hour and minute, setting the second and nanosecond to zero.

static LocalDateTime of​(int year, Month month, int dayOfMonth, int hour, int minute, int second) 
Obtains an instance of LocalDateTime from year, month, day, hour, minute and second, setting the nanosecond to zero.

static LocalDateTime of​(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) 
Obtains an instance of LocalDateTime from year, month, day, hour, minute, second and nanosecond.

static LocalDateTime of​(LocalDate date, LocalTime time) 
Obtains an instance of LocalDateTime from a date and time.

static LocalDateTime ofEpochSecond​(long epochSecond, int nanoOfSecond, ZoneOffset offset) 
Obtains an instance of LocalDateTime using seconds from the epoch of 1970-01-01T00:00:00Z.

static LocalDateTime ofInstant​(Instant instant, ZoneId zone) 
Obtains an instance of LocalDateTime from an Instant and zone ID.

static LocalDateTime parse​(CharSequence text) 
Obtains an instance of LocalDateTime from a text string such as 2007-12-03T10:15:30.

static LocalDateTime parse​(CharSequence text, DateTimeFormatter formatter) 
Obtains an instance of LocalDateTime from a text string using a specific formatter.

LocalDateTime plus​(long amountToAdd, TemporalUnit unit) 
Returns a copy of this date-time with the specified amount added.

LocalDateTime plus​(TemporalAmount amountToAdd) 
Returns a copy of this date-time with the specified amount added.

LocalDateTime plusDays​(long days) 
Returns a copy of this LocalDateTime with the specified number of days added.
复制此LocalDateTime对象，复制对象加days天，返回复制的LocalDateTime对象

LocalDateTime plusHours​(long hours) 
Returns a copy of this LocalDateTime with the specified number of hours added.
复制此LocalDateTime对象，复制对象加hours小时，返回复制的LocalDateTime对象

LocalDateTime plusMinutes​(long minutes) 
Returns a copy of this LocalDateTime with the specified number of minutes added.
复制此LocalDateTime对象，复制对象加minutes分钟，返回复制的LocalDateTime对象

LocalDateTime plusMonths​(long months) 
Returns a copy of this LocalDateTime with the specified number of months added.
复制此LocalDateTime对象，复制对象加months个月，返回复制的LocalDateTime对象

LocalDateTime plusNanos​(long nanos) 
Returns a copy of this LocalDateTime with the specified number of nanoseconds added.
复制此LocalDateTime对象，复制对象加nanos纳秒，返回复制的LocalDateTime对象

LocalDateTime plusSeconds​(long seconds) 
Returns a copy of this LocalDateTime with the specified number of seconds added.
复制此LocalDateTime对象，复制对象加seconds秒，返回复制的LocalDateTime对象

LocalDateTime plusWeeks​(long weeks) 
Returns a copy of this LocalDateTime with the specified number of weeks added.
复制此LocalDateTime对象，复制对象加weeks周，返回复制的LocalDateTime对象

LocalDateTime plusYears​(long years) 
Returns a copy of this LocalDateTime with the specified number of years added.
复制此LocalDateTime对象，复制对象加years年，返回复制的LocalDateTime对象

<R> R query​(TemporalQuery<R> query) 
Queries this date-time using the specified query.

ValueRange range​(TemporalField field) 
Gets the range of valid values for the specified field.

LocalDate toLocalDate() 
Gets the LocalDate part of this date-time.

LocalTime toLocalTime() 
Gets the LocalTime part of this date-time.

String toString() 
Outputs this date-time as a String, such as 2007-12-03T10:15:30.

LocalDateTime truncatedTo​(TemporalUnit unit) 
Returns a copy of this LocalDateTime with the time truncated.

long until​(Temporal endExclusive, TemporalUnit unit) 
Calculates the amount of time until another date-time in terms of the specified unit.

LocalDateTime with​(TemporalAdjuster adjuster) 
Returns an adjusted copy of this date-time.

LocalDateTime with​(TemporalField field, long newValue) 
Returns a copy of this date-time with the specified field set to a new value.

LocalDateTime withDayOfMonth​(int dayOfMonth) 
Returns a copy of this LocalDateTime with the day-of-month altered.
复制此LocalDateTime对象，将复制对象的天修改为指定的dayOfMonth，返回复制并做修改后的新对象

LocalDateTime withDayOfYear​(int dayOfYear) 
Returns a copy of this LocalDateTime with the day-of-year altered.
复制此LocalDateTime对象，将复制对象的天数修改为指定为年份天数的dayOfYear，返回复制并做修改后的新对象

LocalDateTime withHour​(int hour) 
Returns a copy of this LocalDateTime with the hour-of-day altered.
复制此LocalDateTime对象，将复制对象的小时修改为指定的hour，返回复制并做修改后的新对象


LocalDateTime withMinute​(int minute) 
Returns a copy of this LocalDateTime with the minute-of-hour altered.
复制此LocalDateTime对象，将复制对象的分钟修改为指定的minute，返回复制并做修改后的新对象


LocalDateTime withMonth​(int month) 
Returns a copy of this LocalDateTime with the month-of-year altered.
复制此LocalDateTime对象，将复制对象的月份修改为指定的month，返回复制并做修改后的新对象


LocalDateTime withNano​(int nanoOfSecond) 
Returns a copy of this LocalDateTime with the nano-of-second altered.
复制此LocalDateTime对象，将复制对象的的小时修改为指定的hour，返回复制并做修改后的新对象


LocalDateTime withSecond​(int second) 
Returns a copy of this LocalDateTime with the second-of-minute altered.
复制此LocalDateTime对象，将复制对象的的分钟修改为指定的second，返回复制并做修改后的新对象


LocalDateTime withYear​(int year) 
Returns a copy of this LocalDateTime with the year altered.
复制此LocalDateTime对象，将复制对象的的年份修改为指定的year，返回复制并做修改后的新对象

```
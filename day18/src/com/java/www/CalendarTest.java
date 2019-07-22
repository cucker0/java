/*
Calendar 类
是一个抽象类
日历

## 构造器
Calendar()
Calendar(TimeZone zone, Locale aLocale)

## 方法
get()
add()
set()
Date getTime()
setTime(Date)


abstract void	add(int field, int amount)
boolean	after(Object when)
boolean	before(Object when)
void	clear()
void	clear(int field)
Object	clone()
int	compareTo(Calendar anotherCalendar)
protected void	complete()
protected abstract void	computeFields()
protected abstract void	computeTime()
boolean	equals(Object obj)
int	get(int field)
int	getActualMaximum(int field)
int	getActualMinimum(int field)
static Set<String>	getAvailableCalendarTypes()
static Locale[]	getAvailableLocales()
String	getCalendarType()
String	getDisplayName(int field, int style, Locale locale)
Map<String,Integer>	getDisplayNames(int field, int style, Locale locale)
int	getFirstDayOfWeek()
abstract int	getGreatestMinimum(int field)
static Calendar	getInstance()
static Calendar	getInstance(Locale aLocale)
static Calendar	getInstance(TimeZone zone)
static Calendar	getInstance(TimeZone zone, Locale aLocale)
abstract int	getLeastMaximum(int field)
abstract int	getMaximum(int field)
int	getMinimalDaysInFirstWeek()
abstract int	getMinimum(int field)
Date	getTime()
long	getTimeInMillis()
TimeZone	getTimeZone()
int	getWeeksInWeekYear()
int	getWeekYear()
int	hashCode()
protected int	internalGet(int field)
boolean	isLenient()
boolean	isSet(int field)
boolean	isWeekDateSupported()
abstract void	roll(int field, boolean up)
void	roll(int field, int amount)
void	set(int field, int value)
void	set(int year, int month, int date)
void	set(int year, int month, int date, int hourOfDay, int minute)
void	set(int year, int month, int date, int hourOfDay, int minute, int second)
void	setFirstDayOfWeek(int value)
void	setLenient(boolean lenient)
void	setMinimalDaysInFirstWeek(int value)
void	setTime(Date date)
void	setTimeInMillis(long millis)
void	setTimeZone(TimeZone value)
void	setWeekDate(int weekYear, int weekOfYear, int dayOfWeek)
Instant	toInstant()
String	toString()


## int field 常量
public static final int ERA = 0;
public static final int YEAR = 1;
public static final int MONTH = 2;
public static final int WEEK_OF_YEAR = 3;
public static final int WEEK_OF_MONTH = 4;
public static final int DATE = 5;
public static final int DAY_OF_MONTH = 5;
public static final int DAY_OF_YEAR = 6;
public static final int DAY_OF_WEEK = 7;
public static final int DAY_OF_WEEK_IN_MONTH = 8;
public static final int AM_PM = 9;
public static final int HOUR = 10;
public static final int HOUR_OF_DAY = 11;
public static final int MINUTE = 12;
public static final int SECOND = 13;
public static final int MILLISECOND = 14;
public static final int ZONE_OFFSET = 15;
public static final int DST_OFFSET = 16;
public static final int FIELD_COUNT = 17;


public static final int SUNDAY = 1;
public static final int MONDAY = 2;
public static final int TUESDAY = 3;
public static final int WEDNESDAY = 4;
public static final int THURSDAY = 5;
public static final int FRIDAY = 6;
public static final int SATURDAY = 7;

public static final int JANUARY = 0;
public static final int FEBRUARY = 1;
public static final int MARCH = 2;
public static final int APRIL = 3;
public static final int MAY = 4;
public static final int JUNE = 5;
public static final int JULY = 6;
public static final int AUGUST = 7;
public static final int SEPTEMBER = 8;
public static final int OCTOBER = 9;
public static final int NOVEMBER = 10;
public static final int DECEMBER = 11;
public static final int UNDECIMBER = 12;

public static final int AM = 0;
public static final int PM = 1;




* */

package com.java.www;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    @Test
    public void test1() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        calendar.add(calendar.DAY_OF_MONTH, -2);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date d = calendar.getTime();
        System.out.println(d);
    }
}

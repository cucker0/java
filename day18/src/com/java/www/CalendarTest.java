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

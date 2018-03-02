package com.money.common.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TimeUtil {

	public final static String TAG = TimeUtil.class.getName();

	public final static String countdown(long countdown){
		long day = countdown/(24*60*60);
		long hour = (countdown/(60*60)-day*24);
		long min = ((countdown/(60))-day*24*60-hour*60);
		long s = (countdown-day*24*60*60-hour*60*60-min*60);
		return ((day*24)+hour)+"小时"+min+"分钟"+s+"秒";
	}
	/**
	 * 从时间(毫秒)中提取出时间(时:分:秒) 时间格式: 时:分:秒
	 * 
	 * @param millisecond
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getTimeFromMillisecond(Long millisecond) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(millisecond);
		String timeStr = simpleDateFormat.format(date);
		return timeStr;
	}

	@SuppressLint("SimpleDateFormat")
	public static String getDateTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}

	@SuppressLint("SimpleDateFormat")
	public static String dateTimeTransform(String dateTime) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = sdf.parse(dateTime);
			sdf = new SimpleDateFormat("MM-dd HH:mm");
			return sdf.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressLint("SimpleDateFormat")
	public static Date dateToDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(date);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressLint("SimpleDateFormat")
	public static String dateToDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	@SuppressLint("SimpleDateFormat")
	public static Date getDateTime(String dateTime) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = sdf.parse(dateTime);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressLint("SimpleDateFormat")
	public static String getmonthDayHoursMinutes() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		return sdf.format(d);
	}

	@SuppressLint("SimpleDateFormat")
	public static String getDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}

	@SuppressLint("SimpleDateFormat")
	public static long get2DateTimeBetween(String firstTime, String secondTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			long f = simpleDateFormat.parse(firstTime).getTime();
			long s = simpleDateFormat.parse(secondTime).getTime();
			return (s - f);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	@SuppressLint("SimpleDateFormat")
	public static String getTimestamp() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(d);
	}

	public static String getOutTradeNo() {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss",
				Locale.getDefault());
		Date date = new Date();
		String key = format.format(date);

		Random r = new Random();
		key = key + r.nextInt();
		key = key.replace("-", "");
		key = key.substring(0, 15);
		return key;
	}

	@SuppressLint("SimpleDateFormat")
	public static int getRandomNumber() {
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmssSSS");
		return Integer.parseInt(simpleDateFormat.format(d));
	}
}

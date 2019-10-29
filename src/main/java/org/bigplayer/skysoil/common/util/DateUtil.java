package org.bigplayer.skysoil.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zhufeng
 * @since shop_v1.0
 */
public final class DateUtil {
	
	public enum EDateFormatPattern {
		yyyy("yyyy"), yyyy_MM("yyyy-MM"), yyyyMMdd("yyyyMMdd"), yyyy_MM_dd(
				"yyyy-MM-dd"), HH_mm_ss("HH_mm_ss"), yyyy_MM_dd_HH(
				"yyyy-MM-dd HH"), yyyy_MM_dd_HH_mm("yyyy-MM-dd HH-mm"), yyyy_MM_dd_HH_mm_ss(
				"yyyy-MM-dd HH:mm:ss"), MMdd("MMdd"), MM_dd_HH_mm_ss(
				"MM-dd HH:mm:ss"), yyyyMMddHHmmss("yyyyMMddHHmmss"),
		         HHmmssSSS("HH:mm:ss"),yyyyMMddHHmmssSSS(
				"yyyyMMddHHmmssSSS"),yyyy_M_d(
				"yyyy-M-d");

		private final String pattern;

		public String getPattern() {
			return this.pattern;
		}

		private EDateFormatPattern(String pattern) {
			this.pattern = pattern;
		}

		public static EDateFormatPattern getPattern(String pattern) {
			if (yyyy.getPattern().equals(pattern)) {
				return yyyy;
			} else if (yyyy_MM.getPattern().equals(pattern)) {
				return yyyy_MM;
			} else if (yyyyMMdd.getPattern().equals(pattern)) {
				return yyyyMMdd;
			} else if (HH_mm_ss.getPattern().equals(pattern)) {
				return HH_mm_ss;
			} else if (yyyy_MM_dd_HH.getPattern().equals(pattern)) {
				return yyyy_MM_dd_HH;
			} else if (yyyy_MM_dd_HH.getPattern().equals(pattern)) {
				return yyyy_MM_dd_HH;
			} else if (yyyy_MM_dd_HH_mm.getPattern().equals(pattern)) {
				return yyyy_MM_dd_HH_mm;
			} else if (yyyy_MM_dd_HH_mm_ss.getPattern().equals(pattern)) {
				return yyyy_MM_dd_HH_mm_ss;
			} else if (MMdd.getPattern().equals(pattern)) {
				return MMdd;
			} else if (MM_dd_HH_mm_ss.getPattern().equals(pattern)) {
				return MM_dd_HH_mm_ss;
			} else {
				throw new RuntimeException("日期格式不支持");
			}
		}
	}

	/**
	 * 格式化当前时间字符串
	 * 
	 * @param pattern
	 * @return
	 */
	public static String formatCurrDate(EDateFormatPattern pattern) {
		return DateFormatUtils.format(new Date(), pattern.getPattern());
	}
	/**
	 * 获取当前时间yyyy-MM-dd HH:mm:ss格式字符串
	 *
	 * @return
	 */
	public static String formatDate(Date date) {
		return formatDate(date, EDateFormatPattern.yyyy_M_d);
	}
	/**
	 * 获取当前时间yyyyMMdd格式字符串
	 * 
	 * @return
	 */
	public static String getCurrDate() {
		return formatCurrDate(EDateFormatPattern.yyyyMMdd);
	}

	/**
	 * 获取当前时间yyyyMMddHHmmss格式字符串
	 * 
	 * @return
	 */
	public static String getCurrDateTime() {
		return formatCurrDate(EDateFormatPattern.yyyyMMddHHmmss);
	}

	/**
	 * 获取当前时间yyyyMMddHHmmssSSS格式字符串
	 * 
	 * @return
	 */
	public static String getCurrDateTimeMillisecond() {
		return formatCurrDate(EDateFormatPattern.yyyyMMddHHmmssSSS);
	}

	/**
	 * 获取当前时间yyyy-MM-dd格式字符串
	 * 
	 * @return
	 */
	public static String getCurrDateUseLine() {
		return formatCurrDate(EDateFormatPattern.yyyy_MM_dd);
	}
	
	/**
	 * 获取当前时间yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @return
	 */
	public static String formatDateUseLine(Date date) {
		return formatDate(date, EDateFormatPattern.yyyy_MM_dd_HH_mm_ss);
	}
	
	public static String formatDate(Date date, EDateFormatPattern pattern) {
		
		return DateFormatUtils.format(date, pattern.getPattern());
	}

	/**
	 * 前/后?分钟
	 * 
	 * @param d
	 * @param minute
	 * @return
	 */
	public static Date rollMinute(Date d, int minute) {
		return new Date(d.getTime() + minute * 60 * 1000);
	}

	/**
	 * 前/后?天
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date rollDay(Date d, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 前/后?月
	 * 
	 * @param d
	 * @param mon
	 * @return
	 */
	public static Date rollMon(Date d, int mon) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, mon);
		return cal.getTime();
	}

	/**
	 * 前/后?年
	 * 
	 * @param d
	 * @param year
	 * @return
	 */
	public static Date rollYear(Date d, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return 天数
	 * @throws ParseException
	 */
	public static int dateBetween(Date date1, Date date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateFormat1 = sdf.parse(sdf.format(date1));
			Date dateFormat2 = sdf.parse(sdf.format(date2));
			return Math.abs((int) ((dateFormat1.getTime() - dateFormat2
					.getTime()) / (1000 * 3600 * 24)));
		} catch (Exception e) {
			throw new RuntimeException("时间转化异常");
		}
	}

	/**
	 * 根据用户生日计算年龄
	 */
	public static int getAgeByBirthday(Date birthday) {
		if (birthday == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthday)) {
			throw new IllegalArgumentException(
					"The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}

	/**
	 * 转化Unix时间
	 * 
	 * @param time
	 * @return
	 */
	public static String changeUnixTime(Long time) {

		if (time == null)
		{
			return null;
		}
		return formatDate(new Date(time * 1000), EDateFormatPattern.yyyy_MM_dd);
	}

	public static String getDatePoor(Date endDate, Date nowDate) {
		 
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
//	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = Math.abs(endDate.getTime() - nowDate.getTime());
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
//	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    return day + "天" + hour + "时";
	}

	public static String getHour(String time) {
      if(StringUtils.isBlank(time)){
      	return time;
	  }
		return time.substring(0,time.indexOf(":"))+":00:00";
	}

	public static String getSysTime() {
		return formatCurrDate(EDateFormatPattern.HHmmssSSS);
	}


	public static void main(String[] args){
		String s="2019-01-02";
		s=s.replace("-0","-");
	System.out.println(s.substring(0,4));
	}
}

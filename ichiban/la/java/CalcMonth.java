package la.java;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CalcMonth {

	public static Date getCalcMonth(Date start_date, int num) throws ParseException {
		/*
			機能：
				月単位の日付の計算を行う
			結果：
				計算済の日付が返される
			引数：
				start_date：計算元の日付
				num：計算する月の値
		*/

		Calendar calc_date = Calendar.getInstance();
		// 文字列から日付型に変換
		calc_date.setTime(start_date);
		calc_date.add(Calendar.MONTH, num);

		return calc_date.getTime();
	}

	public static java.sql.Date CastToSQLDate(Date date) {
		/*
		機能：
			java.util.Date型からjava.sql.Date型に変換
		結果：
			時間「00：00：00」を付加されたjava.sql.Date型の日付が表示される
		引数：
			start_date：変換対象の日付
		 */

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		java.sql.Date sql_date = new java.sql.Date(cal.getTimeInMillis());

		return sql_date;
	}
}

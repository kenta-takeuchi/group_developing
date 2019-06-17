package la.java;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CalcMonth {
	public static Date getCalcMonth(Date startDate, int num) throws ParseException {

		Calendar endDate = Calendar.getInstance();
		endDate.setTime(startDate);
		endDate.add(Calendar.MONTH, num);

		return endDate.getTime();
	}

	public static java.sql.Date CastToSQLDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
		return sqlDate;
	}
}

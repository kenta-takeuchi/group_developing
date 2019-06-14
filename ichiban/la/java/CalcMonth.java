package la.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalcMonth {
//	public String getNextMonth(String startDate) throws ParseException {
//
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
//
//		Calendar endDate = Calendar.getInstance();
//		endDate.setTime(date);
//		endDate.add(Calendar.MONTH, 1);
//
//		String strEndDate = new SimpleDateFormat("yyyy-MM-dd").format(endDate.getTime());
//
//		return strEndDate;
//	}
//
	public Date getNextMonth(Date startDate) throws ParseException {

		Calendar endDate = Calendar.getInstance();
		endDate.setTime(startDate);
		endDate.add(Calendar.MONTH, 1);

		String strEndDate = new SimpleDateFormat("yyyy-MM-dd").format(endDate.getTime());

		return endDate.getTime();
	}

	public Date getPreMonth(Date startDate) throws ParseException {

		Calendar endDate = Calendar.getInstance();
		endDate.setTime(startDate);
		endDate.add(Calendar.MONTH, -1);

		String strEndDate = new SimpleDateFormat("yyyy-MM-dd").format(endDate.getTime());

		return endDate.getTime();
	}

	public java.sql.Date CastToSQLDate(Date date) {
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

package adHoc;

import java.util.GregorianCalendar;

public class Calendar {

	public static void main(String[] args) {
		String[] days = new String[] {"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		GregorianCalendar calendar = new GregorianCalendar(1994, 0, 25);
		
		System.out.println(days[calendar.get(GregorianCalendar.DAY_OF_WEEK)]);
	}

}

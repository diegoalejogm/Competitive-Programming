package Exercise123;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Diego on 5/22/15.
 */
public class Three {


    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2015, 4, 27);
        String[] days = {"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        System.out.println(days[calendar.get(Calendar.DAY_OF_WEEK)]);

    }
}

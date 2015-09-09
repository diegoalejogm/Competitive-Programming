package Exercise123;

import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Diego on 5/22/15.
 */
public class Five {
    public static void main(String[] args) {

        Scanner io = new Scanner(new InputStreamReader(System.in));
        SimpleDateFormat formatter = new SimpleDateFormat("(dd, MM, yyy)");
        List<Date> dates = new ArrayList<Date>();

        try {
            String val = io.nextLine();
            System.out.println(val);
            while (!val.equals("0")) {
                try {
                    Date date = formatter.parse(val);
                    dates.add(date);
                    val = io.nextLine();
                } catch (ParseException e) {
                    //e.printStackTrace();
                }
            }
            Collections.sort(dates);
            System.out.println(dates);
        }
        catch (Exception e)
        {

        }
    }
}

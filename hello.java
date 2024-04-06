import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class hello {
    public long daysBetween(Date one, Date two) {
        long difference = (one.getTime() - two.getTime()) / 86400000; // 86400000 нь 1 өдөр дэх миллсекундын тоо
        return Math.abs(difference);
    }

    public static void main(String args[]) {
        Date today = new Date();

        Calendar myNextCalendar = Calendar.getInstance();
        myNextCalendar.set(2020, 0, 1);
        Date nyd = myNextCalendar.getTime();

        hello myObject = new hello();
        long days = myObject.daysBetween(today, nyd);

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");
        String todayDate = sdf.format(today);
        String newYearsDay = sdf.format(nyd);

        System.out.println(todayDate + " өдрөөс " + newYearsDay + " хүртэл нийт " + days + " өдөр бөйна.");

    }

}

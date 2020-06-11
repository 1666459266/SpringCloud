import java.time.ZonedDateTime;

public class TimeTest {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//默认时区
        System.out.println(zonedDateTime);
    }

}

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        String locatn = "가나다라마바사";
        String locrow = locatn.substring(0, 2), locbay = locatn.substring(2, 5), loclev = locatn.substring(5, 7);
        System.out.println(locrow + " " + locbay + " " + loclev);
    }
}

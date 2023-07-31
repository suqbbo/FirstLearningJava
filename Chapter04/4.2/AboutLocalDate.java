import java.time.DayOfWeek;
import java.time.LocalDate;

public class AboutLocalDate {
    public static void main(String[] args) {
        // 不要使用构造器来构造 LocalDate 类的对象
        // 使用静态工厂方法（factory method）代表你调用构造器
        LocalDate nowDate = LocalDate.now();
        System.out.println("now date: " + nowDate.toString());
        // 提供年、月和日来构造对应一个特定日期的对象
        LocalDate pastMeetDate = LocalDate.of(2020, 3, 15);
        System.out.println("past date: " + pastMeetDate.toString());
        new AboutLocalDate().printDate(pastMeetDate, "now");
        // plusDays 方法会生成一个新的 LocalDate 对象，然后把这个新对象赋给 meetToNowDate 变量。原来的对象不做任何改动。
        LocalDate meetToNowDate = pastMeetDate.plusDays(1040);
        new AboutLocalDate().printDate(meetToNowDate, "meet");

        System.out.println("==== print date ======");
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        // 设置为这个月的第一天，并得到这一天为星期几
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        // 打印表头和第一行的缩进
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
    }

    public void printDate(LocalDate localdate, String tips) {
        // 只访问对象而不修改对象的方法有时称为访问器方法（accessor method）。
        int year = localdate.getYear();
        int month = localdate.getMonthValue();
        int day = localdate.getDayOfMonth();
        System.out.println(tips + " year : " + year);
        System.out.println(tips + " month : " + month);
        System.out.println(tips + " day : " + day);

    }
}

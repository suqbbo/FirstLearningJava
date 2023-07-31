import java.util.Date;

class AboutDate {
    public static void main(String[] args) {
        System.out.println("new Date: " + new Date());
        // 在Java中，任何对象变量的值都是对存储在另外一个地方的一个对象的引用。new操作符的返回值也是一个引用。
        String date = new Date().toString();
        System.out.println("date: " + date);
        Date birthday = new Date();
        System.out.println("birthday: " + birthday.toString());
        // 定义了一个对象变量deadline，它可以引用Date类型的对象。
        // 变量deadline不是一个对象，实际上也没有引用对象。
        Date deadline;
        // System.out.println("deadline: " + deadline); x 尚未初始化变量deadline
        deadline = birthday;
        System.out.println("deadline: " + deadline);
        // 显式地将对象变量设置为null，表明这个对象变量目前没有引用任何对象。
        // 如果将一个方法应用于一个值为null的对象上，那么就会产生运行时错误。
        Date nowDate = null;
        nowDate = new Date();
        if (nowDate != null) {
            System.out.println("nowDate: " + nowDate.toString());
        }
    }
}
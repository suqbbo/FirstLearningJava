import java.time.LocalDate;
import java.util.Random;

public class Employee {
    private static int nextId = 1;
    // 初始值不一定是常量值，可以调用方法对域进行初始化。
    private int id = assignId();

    private int assignId() {
        return nextId++;
    }

    private String name;
    private double salary;
    private LocalDate hireDate;

    // 当一个类的所有构造器都希望把相同的值赋予某个特定的实例域时，显式域初始化特别有用
    private int gender = 0;

    private String race;

    /*
     * 初始化块（initialization block）。在一个类的声明中，可以包含多个代码块。只要构造类的对象，这些块就会被执行。
     * 首先运行初始化块，然后才运行构造器的主体部分。
     */ {
        race = "汉族";
    }

    /*
     * 在类第一次加载的时候，将会进行静态域的初始化。
     * 所有的静态初始化语句以及静态初始化块都将依照类定义的顺序执行。
     */
    static {
        Random generator = new Random();
        nextId = generator.nextInt(1000);
    }

    /*
     * 如果在编写一个类时没有编写构造器，那么系统就会提供一个无参数构造器。这个构造器将所有的实例域设置为默认值。
     * 对象由无参数构造函数创建时，其状态会设置为适当的默认值。
     */
    public Employee() {
        name = "";
        salary = 0.0;
        hireDate = LocalDate.now();
    }
    // 如果类中提供了至少一个构造器，但是没有提供无参数的构造器，则在构造对象时如果没有提供参数就会被视为不合法。
    public Employee(String name) {
        // 如果构造器的第一个语句形如this（...），这个构造器将调用同一个类的另一个构造器
        this(3000);
        this.name = name;
    }

    /*
     * 调用构造器的具体处理步骤：
     * 1）所有数据域被初始化为默认值（0、false或null）。
     * 2）按照在类声明中出现的次序，依次执行所有域初始化语句和初始化块。
     * 3）如果构造器第一行调用了第二个构造器，则先执行第二个构造器主体。
     * 4）执行这个构造器的主体。
     */
    public Employee(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        new Employee();
        new Employee();
        new Employee();
    }
}

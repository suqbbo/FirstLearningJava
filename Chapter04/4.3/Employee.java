import java.time.LocalDate;

class Employee {
    // 静态常量
    private static final int HIGH_LEVEL_AGE = 13;
    // 这个类的所有实例将共享一个nextId域, 即使没有一个雇员对象，静态域nextId也存在。
    private static int nextId = 1;

    // Employee类的静态方法不能访问Id实例域，因为它不能操作对象。但是，静态方法可以访问自身类中的静态域。
    public static void setNextId() {
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    // 每一个雇员对象都有一个自己的id域
    private int id;
    // 关键字private确保只有Employee类自身的方法能够访问这些实例域，而其他类的方法不能够读写这些域。
    // 类通常包括类型属于某个类类型的实例域。
    private String name;
    private double salary;
    private LocalDate hireDate;

    // 构造器与类同名。在构造Employee类的对象时，构造器会运行，以便将实例域初始化为所希望的状态。
    // 构造器与其他的方法有一个重要的不同。构造器总是伴随着new操作符的执行被调用，而不能对一个已经存在的对象调用构造器来达到重新设置实例域的目的。
    // 所有的Java对象都是在堆中构造的
    /*
     * ·构造器与类同名
     * ·每个类可以有一个以上的构造器
     * ·构造器可以有0个、1个或多个参数
     * ·构造器没有返回值
     * ·构造器总是伴随着new操作一起调用
     */
    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDate = LocalDate.of(year, month, day);
        this.setId();
    }

    // raiseSalary方法有两个参数。第一个参数称为隐式（implicit）参数，是出现在方法名前的Employee类对象。
    // 在每一个方法中，关键字this表示隐式参数。
    // 第二个参数位于方法名后面括号中的数值，这是一个显式（explicit）参数。
    public void ralseSalary(double byPercent) {
        this.salary += byPercent / 100 * this.salary;
    }
    // 具体的执行过程为：
    // 1）e被初始化为harry值的拷贝，这里是一个对象的引用。
    // 2）ralseSalaryByLevel方法应用于这个对象引用。e和harry同时引用的那个Employee对象的薪金提高了200%。
    // 3）方法结束后，参数变量e不再使用。
    public void ralseSalaryByLevel(Employee e) {
        System.out.println("good job! you salary upto 200%");
        e.ralseSalary(200);
    }

    // 关键字public意味着任何类的任何方法都可以调用这些方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate gethireDate() {
        return hireDate;
    }

    public void sethireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = getNextId();
        setNextId();
    }

    public void getLevel() {
        if (LocalDate.now().getYear() - this.hireDate.getYear() > HIGH_LEVEL_AGE) {
            System.out.println("congratulation " + this.name + ", you are high level");
            ralseSalaryByLevel(this);
            System.out.println("salary: " + this.getSalary());
        } else {
            System.out.println("sorry, continue hard work");
        }
    }
}
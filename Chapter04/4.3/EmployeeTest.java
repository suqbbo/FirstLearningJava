// 在一个源文件中，只能有一个公有类，但可以有任意数目的非公有类。
public class EmployeeTest {
    public static void main(String[] args) {
        // 构造了一个Employee数组，并填入了三个雇员对象
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("王皓", 5000, 2010, 10, 28);
        staff[1] = new Employee("刘波", 18000, 2000, 3, 1);
        staff[2] = new Employee("康森", 7000, 2013, 6, 5);

        // 每个雇员的薪水提高5%
        for (Employee employee : staff) {
            employee.ralseSalary(5);
        }

        for (Employee employee : staff) {
            System.out.println("---------------------------------------------------");
            System.out.println("id: " + employee.getId() + ", name: " + employee.getName() + ", salary: "
                    + employee.getSalary() + ", hireday: "
                    + employee.gethireDate());
            employee.getLevel();
        }
    }
}

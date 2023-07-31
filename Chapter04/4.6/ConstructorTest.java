import java.util.Random;

public class ConstructorTest {
    public static void main(String[] args) {
        Chicken[] chickens = new Chicken[4];
        chickens[0] = new Chicken();
        chickens[1] = new Chicken("啦啦");
        chickens[2] = new Chicken("蹦蹦", "蹦蹦蹦蹦～");
        chickens[3] = new Chicken("恰克", "恰克恰克～");
        for (Chicken chicken : chickens) {
            System.out.println("name: " + chicken.getName() + ", gender: "
                    + chicken.getGender() + ", tag: " + chicken.getTag());
        }
    }
}

class Chicken {
    private static int nextId;
    private int id;
    private String name;
    private int gender = 0;
    private String tag;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(1000);
    }
    {
        id = nextId;
        nextId++;
    }

    Chicken() {
    }

    Chicken(String name) {
        this(1);
        this.name = name;
    }

    Chicken(int gender) {
        this.gender = gender;
    }

    Chicken(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    Chicken(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        if (gender == 1) {
            return "cock";
        }
        return "hen";
    }

    public String getTag() {
        return tag;
    }
}
abstract class Base {
    public static int objectCount = 0;

    public Base() {
        objectCount++;
    }

    public static int getObjectCount() {
        return objectCount;
    }
}

class SubA extends Base {
    public SubA() {
        super();
    }
}

class SubB extends Base {
    public SubB() {
        super();
    }
}

public class AbstractAndStatic {
    public static void main(String[] args) {
        SubA a1 = new SubA();
        SubA a2 = new SubA();
        SubB b1 = new SubB();

        System.out.println("Total objects created: " + Base.objectCount);
    }
}

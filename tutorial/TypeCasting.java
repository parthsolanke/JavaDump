package tutorial;

public class TypeCasting {
    public static void main(String[] args) {
        // smaller to larger (widening/implicit)
        int i = 12;
        double d = i;

        // larger to smaller (narrowing/explicit)
        double d1 = 12;
        int i1 = (int) d;

        // Wrapper classes

        // Autoboxing
        int p = 10;
        Integer obj = p;

        // unboxing
        Integer obj1 = 20;
        int p1 = obj1;
    }
}
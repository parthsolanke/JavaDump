package app.splitwise;

public class PersonAmount {
    public String name;
    public float amount;

    public PersonAmount(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + ": " + String.format("%.2f", amount);
    }
}

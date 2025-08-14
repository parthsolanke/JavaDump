public class Cargo {
    private final float weight;
    private final boolean hasHighPriority;
    private final CargoType description;
    private boolean isCompleted;

    public Cargo(float weight, boolean highPriority, CargoType description) {
        this.weight = weight;
        this.hasHighPriority = highPriority;
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isHasHighPriority() {
        return hasHighPriority;
    }

    public CargoType getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "weight=" + weight +
                ", hasHighPriority=" + hasHighPriority +
                ", description=" + description +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
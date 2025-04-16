package lombard;

public class PawnItem {
    private Long id;
    private String name;
    private double value;
    private int durationDays;

    public PawnItem(Long id, String name, double value, int durationDays) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.durationDays = durationDays;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getValue() { return value; }
    public int getDurationDays() { return durationDays; }

    public void setName(String name) { this.name = name; }
    public void setValue(double value) { this.value = value; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }
}

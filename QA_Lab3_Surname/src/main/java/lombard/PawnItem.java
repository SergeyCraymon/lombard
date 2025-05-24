package lombard;

/**
 * Базовый класс для всех предметов, сдаваемых в ломбард.
 * Содержит основные характеристики предмета: идентификатор, имя, оценочная стоимость и срок хранения.
 */
public class PawnItem {
    private Long id;
    private String name;
    private double value;
    private int durationDays;

    /**
     * Конструктор для создания объекта PawnItem.
     *
     * @param id идентификатор предмета
     * @param name название предмета
     * @param value оценочная стоимость
     * @param durationDays срок хранения в днях
     */
    public PawnItem(Long id, String name, double value, int durationDays) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.durationDays = durationDays;
    }

    /** @return идентификатор */
    public Long getId() { return id; }

    /** @return название предмета */
    public String getName() { return name; }

    /** @return стоимость предмета */
    public double getValue() { return value; }

    /** @return срок хранения */
    public int getDurationDays() { return durationDays; }

    /** @param name новое название предмета */
    public void setName(String name) { this.name = name; }

    /** @param value новая стоимость */
    public void setValue(double value) { this.value = value; }

    /** @param durationDays новый срок хранения */
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }
}

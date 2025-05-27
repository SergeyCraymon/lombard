package lombard;

/**
 * Класс для цепочки, как разновидности ювелирного изделия.
 * Добавляет свойство длины цепочки.
 */
public class Chain extends Jewelry {
    private double lengthCm;

    /**
     * Конструктор цепочки.
     *
     * @param id идентификатор
     * @param name название
     * @param value оценочная стоимость
     * @param durationDays срок хранения
     * @param material материал изделия
     * @param lengthCm длина в сантиметрах
     */
    public Chain(Long id, String name, double value, int durationDays, String material, double lengthCm) {
        super(id, name, value, durationDays, material);
        this.lengthCm = lengthCm;
    }

    /// @return **длина** _цепочки_ в сантиметрах
    public double getLengthCm() { return lengthCm; }

    /** @param lengthCm новая длина цепочки */
    public void setLengthCm(double lengthCm) { this.lengthCm = lengthCm; }
}

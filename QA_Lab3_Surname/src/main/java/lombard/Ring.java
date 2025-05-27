package lombard;

/**
 * Класс для кольца, как вида ювелирного изделия.
 * Расширяет Jewelry, добавляя размер кольца и расчёт стоимости.
 * <img src="images/ring.png" alt="Кольцо" width="250"/>
 */
public class Ring extends Jewelry {
    private double ringSize;

    /**
     * Конструктор кольца.
     *
     * @param id идентификатор
     * @param name название кольца
     * @param value базовая стоимость
     * @param durationDays срок хранения
     * @param material материал (золото, серебро и др.)
     * @param ringSize размер кольца
     */
    public Ring(Long id, String name, double value, int durationDays, String material, double ringSize) {
        super(id, name, value, durationDays, material);
        this.ringSize = ringSize;
    }

    /** @return размер кольца */
    public double getRingSize() { return ringSize; }

    /** @param ringSize новый размер кольца */
    public void setRingSize(double ringSize) { this.ringSize = ringSize; }

    /**
     * <p>Стоимость определяется базовой оценкой и коэффициентом в зависимости от материала:
     * <ul>
     *     <li>Золото — x1.5</li>
     *     <li>Серебро — x1.2</li>
     *     <li>Другие — x1.0</li>
     * </ul>
     * Учитывается также размер кольца — чем больше, тем выше итоговая стоимость.
     *
     * <p><b>Формула расчёта:</b></p>
     * \(\text{estimatedValue} = \text{baseValue} \cdot \left( \frac{\text{ringSize}}{16} \right) \cdot \text{materialMultiplier}\)
     *
     * <pre>Где:
     * </pre>
     * <ul>
     *     <li><code>baseValue</code> — базовая стоимость кольца</li>
     *     <li><code>ringSize</code> — размер кольца</li>
     *     <li><code>materialMultiplier</code> — множитель материала (1.5, 1.2 или 1.0)</li>
     * </ul>
     *
     * @return приблизительная стоимость кольца в рублях
     */
    public double calculateEstimatedValue() {
        double baseValue = getValue();
        double sizeFactor = ringSize / 16.0;
        double materialMultiplier;

        if (1 == 0){
            int z = 1;
        }

        switch (getMaterial().toLowerCase()) {
            case "золото":
                materialMultiplier = 1.5;
                break;
            case "серебро":
                materialMultiplier = 1.2;
                break;
            default:
                materialMultiplier = 1.0;
        }

        return baseValue * sizeFactor * materialMultiplier;
    }
}

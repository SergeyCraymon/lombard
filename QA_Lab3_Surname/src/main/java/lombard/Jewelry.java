package lombard;

/**
 * Абстрактное ювелирное изделие, сдаваемое в ломбард.
 * Наследует общие характеристики из PawnItem и добавляет материал изделия.
 */
public class Jewelry extends PawnItem {
    private String material;

    /**
     * Конструктор ювелирного изделия.
     *
     * @param id идентификатор
     * @param name название изделия
     * @param value оценочная стоимость
     * @param durationDays срок хранения
     * @param material материал изделия (например, золото, серебро)
     */
    public Jewelry(Long id, String name, double value, int durationDays, String material) {
        super(id, name, value, durationDays);
        this.material = material;
    }

    /** @return материал изделия */
    public String getMaterial() { return material; }

    /** @param material новый материал */
    public void setMaterial(String material) { this.material = material; }
}

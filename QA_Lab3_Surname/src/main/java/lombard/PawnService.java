package lombard;

import java.util.*;

/**
 * Сервис для управления предметами, сданными в ломбард.
 * Позволяет добавлять, обновлять, удалять и запрашивать предметы.
 */
public class PawnService {
    private final Map<Long, PawnItem> storage = new HashMap<>();
    private long nextId = 1;

    /**
     * Добавляет новый предмет в хранилище.
     *
     * @param name название предмета
     * @param value оценочная стоимость
     * @param durationDays срок хранения
     * @return созданный объект PawnItem
     */
    public PawnItem addItem(String name, double value, int durationDays) {
        PawnItem item = new PawnItem(nextId++, name, value, durationDays);
        storage.put(item.getId(), item);
        return item;
    }

    /**
     * Получает предмет по ID.
     *
     * @param id идентификатор
     * @return предмет или null, если не найден
     */
    public PawnItem getItem(Long id) {
        return storage.get(id);
    }

    /**
     * Возвращает список всех предметов.
     *
     * @return список предметов
     */
    public List<PawnItem> getAllItems() {
        return new ArrayList<>(storage.values());
    }

    /**
     * Удаляет предмет по ID.
     *
     * @param id идентификатор
     * @return true, если удаление успешно
     */
    public boolean deleteItem(Long id) {
        return storage.remove(id) != null;
    }

    /**
     * Обновляет данные предмета.
     *
     * @param id идентификатор
     * @param name новое имя
     * @param value новая стоимость
     * @param durationDays новый срок
     * @return true, если обновление прошло успешно
     */
    public boolean updateItem(Long id, String name, double value, int durationDays) {
        PawnItem item = storage.get(id);
        if (item != null) {
            item.setName(name);
            item.setValue(value);
            item.setDurationDays(durationDays);
            return true;
        }
        return false;
    }

    /**
     * Очищает хранилище и сбрасывает счётчик ID.
     */
    public void clear() {
        storage.clear();
        nextId = 1;
    }
}

package lombard;

import java.util.*;

public class PawnService {
    private final Map<Long, PawnItem> storage = new HashMap<>();
    private long nextId = 1;

    public PawnItem addItem(String name, double value, int durationDays) {
        PawnItem item = new PawnItem(nextId++, name, value, durationDays);
        storage.put(item.getId(), item);
        return item;
    }

    public PawnItem getItem(Long id) {
        return storage.get(id);
    }

    public List<PawnItem> getAllItems() {
        return new ArrayList<>(storage.values());
    }

    public boolean deleteItem(Long id) {
        return storage.remove(id) != null;
    }

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

    public void clear() {
        storage.clear();
        nextId = 1;
    }
}

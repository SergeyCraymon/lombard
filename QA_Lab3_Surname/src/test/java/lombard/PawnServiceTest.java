package lombard;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PawnServiceTest {
    private PawnService service;

    @BeforeEach
    void setUp() {
        service = new PawnService();
    }

    @Test
    @DisplayName("Добавление нового залога")
    void testAddItem() {
        PawnItem item = service.addItem("Золотое кольцо", 15000, 30);
        assertNotNull(item, "Добавленный элемент не должен быть null");
        assertEquals("Золотое кольцо", item.getName(), "Название залога должно совпадать");
        assertEquals(15000, item.getValue(), "Стоимость должна быть 150");
        assertEquals(30, item.getDurationDays(), "Срок должен быть 30 дней");
    }

    @Test
    @DisplayName("Получение залога по ID и проверка имени")
    void testGetItem() {
        PawnItem item = service.addItem("Серебряная цепочка", 10000, 20);
        PawnItem retrieved = service.getItem(item.getId());
        assertEquals(item.getName(), retrieved.getName(),
                "Имена залогов должны совпадать при использования метода getId()");
    }

    @Test
    @DisplayName("Удаление существующего залога")
    void testDeleteItem() {
        PawnItem item = service.addItem("Наручные часы Casio", 20000, 15);
        boolean deleted = service.deleteItem(item.getId());
        assertTrue(deleted, "Удаление должно вернуть true");
        assertNull(service.getItem(item.getId()), "Залог должен быть удалён из сервиса");
    }

    @Test
    @DisplayName("Обновление существующего залога")
    void testUpdateItem() {
        PawnItem item = service.addItem("Ноутбук Lenovo", 50000, 60);
        boolean updated = service.updateItem(item.getId(), "Игровой ноутбук MSI", 70000, 90);
        assertTrue(updated, "Обновление должно пройти успешно");
        PawnItem updatedItem = service.getItem(item.getId());
        assertEquals("Игровой ноутбук MSI", updatedItem.getName(), "Имя должно быть обновлено");
        assertEquals(70000, updatedItem.getValue(), "Стоимость должна быть обновлена");
        assertEquals(90, updatedItem.getDurationDays(), "Срок должен быть обновлён");
    }

    @Test
    @DisplayName("Обновление несуществующего залога")
    void testUpdateNonExistingItem() {
        boolean result = service.updateItem(123L, "Телевизор Samsung", 30000, 30);
        assertFalse(result, "Обновление несуществующего залога должно вернуть false");
    }

    @Test
    @DisplayName("Удаление несуществующего залога")
    void testDeleteNonExistingItem() {
        boolean result = service.deleteItem(888L);
        assertFalse(result, "Удаление несуществующего ID должно вернуть false");
    }

    @Test
    @DisplayName("Проверка количества залогов")
    void testMultipleItems() {
        service.addItem("Бензопила STIHL", 15000, 30);
        service.addItem("Золотой браслет", 20000, 45);
        List<PawnItem> items = service.getAllItems();
        assertEquals(2, items.size(), "Количество залогов должно быть 2");
    }

    @Test
    @DisplayName("Очистка данных")
    void testClearService() {
        service.addItem("Смартфон iPhone 13", 30000, 60);
        service.clear();
        assertTrue(service.getAllItems().isEmpty(), "Должна отработать очистка сервиса!");
    }

    @Test
    @DisplayName("Проверка пустого списка залогов")
    void testGetAllItemsEmpty() {
        assertTrue(service.getAllItems().isEmpty(), "Сервис должен быть пустым!");
    }

    @Test
    @DisplayName("Проверка автоинкремента ID")
    void testIdIncrement() {
        PawnItem ps5 = service.addItem("Игровая приставка PlayStation 5", 100000, 10);
        PawnItem coffeeMachine = service.addItem("Кофемашина Philips", 20000, 20);
        long idPs5 = ps5.getId() + 1;
        long idCoffeeMachine = coffeeMachine.getId();

        assertEquals(idPs5, idCoffeeMachine, String.format("ID второго элемента должен быть на 1 больше первого. id ps5: %d, id coffee machine: %d", idPs5, idCoffeeMachine));
    }
}

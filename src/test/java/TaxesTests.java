import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TaxesTests {
    Taxes tax;


    @BeforeEach
    public void init() {
        System.out.println("Начало тестов");
        tax = new Taxes();
    }

    @BeforeAll
    static void setUpApp() {
        System.out.println("Запускаюсь до выполнения всех тестов...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Запускаюсь после выполнения всех тестов...");
    }

    @Test
    @DisplayName("Тест: Проверка вычисления налога 15% от суммы дохода")
    public void test1_taxEarningsMinusSpendings() {
        int a = 1000, expected = 150;
        int result = tax.taxEarnings(a);
        assertNotNull(result);
    }
    @Test
    @DisplayName("Тест: Проверка вычисления налога 6% от суммы дохода")
    public void test2_taxEarnings() {
        int a = 10_000, expected = 600;
        int result = tax.taxEarnings(a);
        assertNotNull(result);
    }
    @Test
    @DisplayName("Тест: Сравнение результатов вычисления налогов для выбора налогового учёта")
    public void test3_notEquals() {
        int taxEarnings = 600, taxEarningsMinusSpendings = 100;
        boolean result = tax.notEquals(taxEarnings, taxEarningsMinusSpendings);
        assertTrue(result);
    }


    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(300, 10), Arguments.of(5_000, 400));
    }
}

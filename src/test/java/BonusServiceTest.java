import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldRegisteredAndLessForLimit() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 16_640_00;
        boolean registered = true;
        long expected = 499;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldRegisteredAndEqualLimit() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 16_670_00;
        boolean registered = true;
        long expected = 500;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotRegisteredAndLessForLimit() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 49_900_00;
        boolean registered = false;
        long expected = 499;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotRegisteredAndEqualLimit() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 50_000_00;
        boolean registered = false;
        long expected = 500;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldRegisteredAndMaxBonus() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 1_000_000_00;
        boolean registered = true;
        long expected = 500;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotRegisteredAndMaxBonus() {
        BonusService service = new BonusService();

        //подготовливаем данные
        long amount = 1_000_000_00;
        boolean registered = false;
        long expected = 500;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку
        assertEquals(expected, actual);
    }
}
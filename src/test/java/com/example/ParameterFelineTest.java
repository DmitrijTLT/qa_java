package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterFelineTest {
    IFeline feline;

    private static final List<String> MEAT_MEAL = List.of("Животные", "Птицы", "Рыба");
    private static final List<String> HERB_MEAL = List.of("Трава", "Различные растения");

    // Параметризованный тест: метод getKittens() не должен возвращать указанные неверные значения
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 3})
    @DisplayName("Проверка, что метод getKittens() не должен возвращать значения меньше единицы или больше единицы")
    void getKittensWithInvalidParameters(int expected) {
        Feline feline = new Feline();
        int actualResult = feline.getKittens();
        assertNotEquals(expected, actualResult,"Метод getKittens() не должен совпадать с указанным числом:" + expected);
    }

    public static Object[] provideFelineData() {
        return new Object[][] {
                {"Хищник", MEAT_MEAL},
                {"Травоядное", HERB_MEAL}, // передали тестовые данные
        };
    }

    // Метод getFood() для хищника должен получать соответствующую еду
    @ParameterizedTest
    @MethodSource("provideFelineData")
    @DisplayName("Проверка, что у самца есть грива, а у самки нет")
    void doesHaveManeLion(String animal, List<String> expectedFood) throws Exception {
        Feline feline = new Feline();
        List<String> actualResult = feline.getFood(animal);
        System.out.println(actualResult);
        assertEquals(expectedFood, actualResult, "Должен возвращаться список для " + animal + ": " + expectedFood + ".");
    }

    // Обработка неправильного вида животного
    @ParameterizedTest
    @ValueSource(strings = {"Что-то", "Lev", "123"})
    @DisplayName("Проверка исключения при неверном виде животного")
    void doesHaveMane_ThrowsException(String animal) {
        Feline feline = new Feline();
        assertThrows(Exception.class, () -> feline.getFood(animal), "Ожидалось исключение для вида животного: " + animal);
    }
}

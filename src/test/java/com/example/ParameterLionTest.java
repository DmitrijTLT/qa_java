package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterLionTest {
    IFeline feline;

    public static Object[] provideLionData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}, // передали тестовые данные
        };
    }

    // Параметризованный тест: метод doesHaveMane() показывает, что у самца есть грива, а у самки нет
    @ParameterizedTest
    @MethodSource("provideLionData")
    @DisplayName("Проверка, что у самца есть грива, а у самки нет")
    void doesHaveManeLion(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualResult, "Метод doesHaveMane() должен возвращать гриву у самца");
    }

    // Обработка неправильного пола
    @ParameterizedTest
    @ValueSource(strings = {"Что-то", "Lev", "123"})
    @DisplayName("Проверка исключения при неверном поле")
    void doesHaveMane_ThrowsException(String sex) {
        assertThrows(Exception.class, () -> new Lion(sex, feline));
    }
}

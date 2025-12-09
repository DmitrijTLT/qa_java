package com.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FelineTest {

    private static final List<String> MEAT_MEAL = List.of("Животные", "Птицы", "Рыба");

    // Метод eatMeat() должен возвращать список еды для животных хищников
    @Test
    @DisplayName("Проверка, что хищники едят животных")
    void eatMeatReturnCorrectFoodForPredator() throws Exception {
        Feline feline = new Feline();
        List<String> actualResult = feline.eatMeat();
        assertEquals(MEAT_MEAL, actualResult, "Метод eatMeat() должен возвращать: Животные, Птицы, Рыба.");
    }

    // Метод getFamily() должен возвращать семейство кошки
    @Test
    @DisplayName("Проверка семейства кошачьих")
    void getFamilyReturnFeline() {
        Feline feline = new Feline();
        String actualResult = feline.getFamily();
        System.out.println(actualResult);
        assertEquals("Кошачьи", actualResult, "Метод getFamily() должен возвращать: Кошачьи.");
    }

    // Метод getKittens() должен возвращать одного котенка
    @Test
    @DisplayName("Проверка, что возвращается один котенок")
    void getKittensReturnOneKitten() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens();
        assertEquals(1, actualResult, "Метод getKittens() должен возвращать ровно 1 котенка.");
    }
}
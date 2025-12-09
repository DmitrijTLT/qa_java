package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    private static final List<String> MEAT_MEAL = List.of("Животные", "Птицы", "Рыба");

    // Создали мок
    @Mock
    Feline feline;

    // Метод getSound() возвращает звук кошки
    @Test
    @DisplayName("Проверка, что метод getSound() возвращает звук 'Мяу'")
    void getSoundReturnCorrectSoundForCat() {
        Cat cat = new Cat(feline);
        String actualResult = cat.getSound();
        assertEquals("Мяу", actualResult, "Метод getSound() должен возвращять: Мяу.");
    }

    // Метод getFood() возвращает еду хищников для кошки
    @Test
    @DisplayName("Проверка, что кошки едят еду для хищников")
    void getFoodReturnFoodForPredator() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(MEAT_MEAL);
        List<String> actualResult = cat.getFood();
        assertEquals(MEAT_MEAL, actualResult, "Должен возвращаться список для хищника: Животные, Птицы, Рыба.");
    }
}
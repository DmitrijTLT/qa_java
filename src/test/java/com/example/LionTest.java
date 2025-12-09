package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    private static final List<String> MEAT_MEAL = List.of("Животные", "Птицы", "Рыба");

    // Создали мок
    @Mock
    IFeline feline;

    // Метод getKittens() возвращает кол-во кошачих
    @Test
    @DisplayName("Проверка количество семейства кошачих")
    void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        int actualResult = lion.getKittens();
        assertEquals(1, actualResult);
    }

    // Метод getFood() возвращает еду для хищника с передачей вида животного
    @Test
    @DisplayName("Проверка получения еды для хищника")
    void getFoodReturnFoodForPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> actualResult = lion.getFood("Хищник");
        assertEquals(MEAT_MEAL, actualResult,"Метод getFood() должен возвращать: Животные, Птицы, Рыба.");
    }

    // Метод getFood() возвращает еду для хищника без передачи вида животного
    @Test
    @DisplayName("Проверка получение еды для хищника без указания вида животного")
    void getFoodReturnFoodForPredatorWithoutAnimalKind() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> actualResult = lion.getFood();
        assertEquals(MEAT_MEAL, actualResult,"Метод getFood() должен возвращать: Животные, Птицы, Рыба.");
    }
}
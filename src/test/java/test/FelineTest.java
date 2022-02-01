package test;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @RunWith(Parameterized.class)
    public static class ParameterizedFelineTest {

        // поля класса:
        private final int checkedText; // значение, которое передаётся в метод
        private final int expected; // ожидаемый результат

        // конструктор с параметрами
        public ParameterizedFelineTest (int checkedText, int expected){
            this.checkedText = checkedText;
            this.expected = expected;
        }

        // метод для получения данных
        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][] {
                    {1, 1},
                    {2, 2},
                    {-5, -5}, //проверка на отрицательное значение
            };
        }

        //параметризированный тест (3 набора входных данных)
        @Test
        public void getKittensArgumentTest (){
            Feline feline = new Feline();
            int actual = feline.getKittens(checkedText);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensNoArgumentTest (){
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void eatMeatTest () throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

}

package test;
import com.example.Animal;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class AnimalTest {

    @Test
    public void getFood1Test() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }

    @Test
    public void getFood2Test() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodExceptionTest() {
        try {
            Animal animal = new Animal();
            new ArrayList<>(animal.getFood("животное"));
        } catch (Exception actual) {
            String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
            assertEquals(expected, actual.getMessage());
        }
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }


}

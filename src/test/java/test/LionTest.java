package test;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @RunWith(Parameterized.class)
    public static class ParameterizedLionTest{

        private final String sex;
        private final boolean lionHasMane;

        public ParameterizedLionTest (String sex, boolean lionHasMane){
            this.sex = sex;
            this.lionHasMane = lionHasMane;
        }

        @Parameterized.Parameters
        public static Object[][] lionSexData() {
            return new Object[][] {
                    {"Самец", true},
                    {"Самка", false}
            };
        }

        @Test
        public void doesHaveManeTest() throws Exception {
            Lion lion = new Lion(sex);
            assertEquals(lionHasMane, lion.doesHaveMane());
        }
    }

    @Mock
    Lion lion;

    @Test
    public void lionTrueTest () throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.hasMane);
    }

    @Test
    public void lionFalseTest () throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.hasMane);
    }

    @Test
    public void lionExceptionTest() {
        try {
            new Lion("любое животное");
        } catch (Exception actual) {
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expected, actual.getMessage());
        }
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец");
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensMockTest() {
        Mockito.when(lion.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodMockTest() throws Exception {
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, lion.getFood());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, lion.getFood());
    }


}

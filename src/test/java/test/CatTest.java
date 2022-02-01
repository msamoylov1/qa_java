package test;
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;
    private Cat cat;

    @Before
    public void catInit() {
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundTest() {
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodPredatorsFood() throws Exception {
        cat = new Cat(felineMock);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> catsActualFood = cat.getFood();
        List<String> catsExpectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.verify(felineMock).eatMeat();
        assertEquals(catsActualFood, catsExpectedFood);
    }

}

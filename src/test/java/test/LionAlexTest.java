package test;
import com.example.LionAlex;
import org.junit.Test;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class LionAlexTest {


    @Test
    public void getFriendsTest() throws Exception {
        LionAlex lionAlex = new LionAlex();
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, lionAlex.getFriends());
    }

    @Test
    public void getKittensTest() throws Exception {
        LionAlex lionAlex = new LionAlex();
        int expected = 0;
        assertEquals(expected, lionAlex.getKittens());
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        LionAlex lionAlex = new LionAlex();
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, lionAlex.getPlaceOfLiving());
    }

}

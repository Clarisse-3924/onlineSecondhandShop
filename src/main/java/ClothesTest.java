import static org.junit.Assert.*;
import org.junit.Test;

    public class ClothesTest {
        @Test
        public void allClothes ()throws Exception{
            Clothes testClothes=setUpNewClothes ();
            assertEquals (true,testClothes instanceof Clothes);

        }

        @Test
        public void getName ()throws Exception{
            Clothes testClothes=setUpNewClothes ();
            assertEquals ("jogging",testClothes.getName ());
        }

        @Test
        public void getDesciption ()throws Exception{
            Clothes testClothes=setUpNewClothes ();
            assertEquals ("it can be for men or women",testClothes.getDescription ());
        }
        @Test
        public void getprice ()throws Exception{
            Clothes testClothes=setUpNewClothes ();
            assertEquals (5000,testClothes.getPrice  ());
        }

        private Clothes setUpNewClothes(){
            return new Clothes ("jogging",5000,"it can be for men or women");
        }

    }


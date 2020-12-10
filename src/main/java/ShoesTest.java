import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoesTest {

    @Test
    public void allShoes ()throws Exception{
        Clothes testClothes=setUpNewShoes ();
        assertEquals (true,testClothes instanceof Clothes);

    }

    @Test
    public void getName ()throws Exception{
        Shoes testShoes=setUpNewShoes ();
        assertEquals ("sneakers",testShoes.getName ());
    }

    @Test
    public void getDesciption ()throws Exception{
        Shoes testShoes=setUpNewShoes ();
        assertEquals ("it can be for men or women",testShoes.getDescription ());
    }
    @Test
    public void getprice ()throws Exception{
        Shoes testShoes =setUpNewShoes ();
        assertEquals (15000, testShoes .getPrice  ());
    }
    @Test
    public void getshoe ()throws Exception{
        Shoes testShoes =setUpNewShoes ();
        assertEquals (40, testShoes .getShoe_number  ());
    }
    private Shoes setUpNewShoes(){
        return new Shoes ("sneakers",15000,"it can be for men or women",40);
    }

}
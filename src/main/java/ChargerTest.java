import org.junit.Test;

import static org.junit.Assert.*;

public class ChargerTest {

    @Test
    public void allTelephone ()throws Exception{
        Charger testCharger=setUpNewCharger ();
        assertEquals (true,testCharger instanceof Charger);

    }

    @Test
    public void getName ()throws Exception{
        Charger testCharger=setUpNewCharger ();
        assertEquals ("LG",testCharger.getName ());
    }

    @Test
    public void getDesciption ()throws Exception{
        Charger testCharger=setUpNewCharger ();
        assertEquals ("it can be used for a long time",testCharger.getDescription ());
    }
    @Test
    public void getprice ()throws Exception{
        Charger testCharger =setUpNewCharger ();
        assertEquals (1500, testCharger .getPrice  ());
    }
    @Test
    public void gettrade ()throws Exception{
        Charger testCharger =setUpNewCharger ();
        assertEquals (2, testCharger .getPhone_id  ());
    }
    private Charger setUpNewCharger(){
        return new Charger ("LG",1500,"it can be used for a long time",2);
    }


}
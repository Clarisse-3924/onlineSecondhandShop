import org.junit.Test;

import static org.junit.Assert.*;


    public class TelephoneTest {

        @Test
        public void allTelephone ()throws Exception{
            Telephone testTelephone=setUpNewTelephone ();
            assertEquals (true,testTelephone instanceof Telephone);

        }

        @Test
        public void getName ()throws Exception{
            Telephone testTelephone=setUpNewTelephone ();
            assertEquals ("iphone",testTelephone.getName ());
        }

        @Test
        public void getDesciption ()throws Exception{
            Telephone testTelephone=setUpNewTelephone ();
            assertEquals ("it can be used for a long time",testTelephone.getDescription ());
        }
        @Test
        public void getprice ()throws Exception{
            Telephone testTelephone =setUpNewTelephone ();
            assertEquals (150000, testTelephone .getPrice  ());
        }
        @Test
        public void gettrade ()throws Exception{
            Telephone testTelephone =setUpNewTelephone ();
            assertEquals ("apple", testTelephone .getTrade_mark  ());
        }
        private Telephone setUpNewTelephone(){
            return new Telephone ("iphone",150000,"it can be used for a long time","apple");
        }

    }


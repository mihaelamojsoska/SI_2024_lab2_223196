import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    SILab2 siLab2 = new SILab2();

    @Test
    public void everyBranchTest() {
        RuntimeException ex;
        ex =  assertThrows(RuntimeException.class,()->siLab2.checkCart(null,100));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        List<Item> dog1 = new ArrayList<>();
        dog1.add(new Item("dog","123G",100,0.1f));
        ex =  assertThrows(RuntimeException.class,()->siLab2.checkCart(dog1,150));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        List<Item> cat1 = new ArrayList<>();
        cat1.add(new Item("",null,50,0.1f));
        ex =  assertThrows(RuntimeException.class,()->siLab2.checkCart(cat1,100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        List<Item> fish3 = new ArrayList<>();
        fish3.add(new Item("fish","1234",200,0.1f));
        fish3.add(new Item("fish2","9876",300,0.2f));
        assertTrue(siLab2.checkCart(fish3, 400));

        List<Item> cow3 = new ArrayList<>();
        cow3.add(new Item("cow","1234",100,0.1f));
        cow3.add(new Item("cow2","9876",300,-0.1f));
        assertFalse(siLab2.checkCart(cow3,100));

    }
    @Test
    public void multipleConditionsTest(){
        List<Item> mult = new ArrayList<>();
        mult.add(new Item("mult1","023",170,0.1f));
        mult.add(new Item("mult2","345",320,0));
        mult.add(new Item("mult3","345",320,0.1f));
        mult.add(new Item("mult4","023",320,0.1f));

        assertTrue(siLab2.checkCart(mult,1000));
        assertFalse(siLab2.checkCart(mult,100));
    }
}


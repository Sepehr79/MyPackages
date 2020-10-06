package Main;

import MyPackages.BaseNumber;
import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {
    static BaseNumber binaryNumber;
    static BaseNumber octalNumber;
    static BaseNumber hexDecimalNumber;
    @BeforeClass
    public static void makeValues(){
        binaryNumber = new BaseNumber("10", "2");
        octalNumber = new BaseNumber("11", "8");
        hexDecimalNumber = new BaseNumber("A", "16");
    }
    @Test
    public void testEquals(){
        //from another base to base ten
        assertEquals(binaryNumber.convertToBaseTen(), "2");
        assertEquals(octalNumber.convertToBaseTen(), "9");
        assertEquals(hexDecimalNumber.convertToBaseTen(), "10");

        //from base ten to another base
        assertEquals(binaryNumber.convertToBase("2"), "10");
        assertEquals(octalNumber.convertToBase("8"), "11");
        assertEquals(hexDecimalNumber.convertToBase("16"), "A");
    }
    @Test
    public void testExceptions(){
        try {
            binaryNumber.convertToBase("17");
            octalNumber.convertToBase("A");
            hexDecimalNumber.convertToBase("wdejlijfewl");
        }catch (Exception e){
            assertTrue(e instanceof BaseNumber.WrongBaseFormatException);
        }
    }
}

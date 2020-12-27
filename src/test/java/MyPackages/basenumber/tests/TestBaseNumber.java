package MyPackages.basenumber.tests;

import MyPackages.basenumber.classes.BaseNumber;
import org.junit.*;
import static org.junit.Assert.*;

public class TestBaseNumber {
    static BaseNumber binaryNumber;
    static BaseNumber octalNumber;
    static BaseNumber hexDecimalNumber;

    static BaseNumber example;
    @BeforeClass
    public static void makeValues(){
        try {
            binaryNumber = new BaseNumber("10", "2");
            octalNumber = new BaseNumber("11", "8");
            hexDecimalNumber = new BaseNumber("A", "16");
        } catch (BaseNumber.WrongBaseFormatException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testEquals() throws BaseNumber.WrongBaseFormatException {
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
            e.printStackTrace();
            Assert.assertTrue(e instanceof BaseNumber.WrongBaseFormatException);
        }

    }

    @Test
    public void testExample() throws BaseNumber.WrongBaseFormatException {
        example = new BaseNumber("B", "16");
        Assert.assertEquals(example.convertToBase("2"), "1011");
    }
}

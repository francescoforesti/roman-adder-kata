import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RomanNumbersAdderTest {

    private RomanNumbersAdder adder = new RomanNumbersAdder();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSumNoNumbers() {
        List<String> items = new ArrayList<>();
        String actualV = adder.sum(items);
        assertEquals("", actualV);
    }

    @Test
    public void testSumEmptyString() {
        List<String> items = Arrays.asList("");
        String actual = adder.sum(items);
        assertEquals("", actual);
    }

    @Test
    public void testSumTwoNumbers() {
        List<String> items = Arrays.asList("I", "IV");
        String actualV = adder.sum(items);
        assertEquals("V", actualV);
    }

    @Test
    public void testSumThreeNumbersAndAnEmptyString() {
        List<String> items = Arrays.asList("I", "IV", "", "D");
        String actualV = adder.sum(items);
        assertEquals("DV", actualV);
    }

    @Test
    public void testToDecimal() {
        Integer mcmlxxviii = adder.toDecimal("MCMLXXVIII");
        assertEquals(new Integer(1978), mcmlxxviii);
    }

    @Test
    public void testToDecimalWithTapioca() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("No TAPIOCA allowed here");
        adder.toDecimal("TAPIOCA");
    }

    @Test
    public void testToDecimalWithEmptyString() {
        assertEquals(new Integer(0),  adder.toDecimal(""));
    }

    @Test
    public void testToRoman() {
        assertEquals("MCMLXXIX", adder.toRoman(1979));
    }


}

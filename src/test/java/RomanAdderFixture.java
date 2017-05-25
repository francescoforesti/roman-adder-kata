import org.concordion.api.ExpectedToFail;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(ConcordionRunner.class)
public class RomanAdderFixture {

    RomanNumbersAdder adder = new RomanNumbersAdder();

    public String add(String items) {
        List<String> sumItems = new ArrayList<>();
        if(items != null) {
            String[] arrayItems = items.split(",");
            sumItems.addAll(Arrays.asList(arrayItems));
        }
        return adder.sum(sumItems);
    }

    public Integer toDecimal(String roman) {
        return adder.toDecimal(roman);
    }

    public String toRoman(String decimal) {
        Integer convertMe = Integer.valueOf(decimal);
        return adder.toRoman(convertMe);
    }
}

import java.util.*;

/**
 * An adder of numbers expressed in roman notation :
 *
 * - takes a list of numbers expressed in roman notation (as strings)
 * - adds all of them
 * - returns the sum expressed in roman notation (as a string)
 */

public class RomanNumbersAdder {

    private static Map<Integer,String> symbolFlyweight;
    private final TreeMap<Integer, String> conversionTable = new TreeMap<>();

    static {
        HashMap<Integer,String> initialMap = new HashMap<>();
        initialMap.put(1000, "M");
        initialMap.put(900, "CM");
        initialMap.put(500, "D");
        initialMap.put(400, "CD");
        initialMap.put(100, "C");
        initialMap.put(90, "XC");
        initialMap.put(50, "L");
        initialMap.put(40, "XL");
        initialMap.put(10, "X");
        initialMap.put(9, "IX");
        initialMap.put(5, "V");
        initialMap.put(4, "IV");
        initialMap.put(1, "I");
        initialMap.put(0, "");
        symbolFlyweight = Collections.unmodifiableMap(initialMap);
    }

    public RomanNumbersAdder() {
        conversionTable.putAll(symbolFlyweight);
    }

    public  String sum(List<String> items) {
        int integerSum = items.stream().mapToInt(item -> toDecimal(item)).sum();
        return toRoman(integerSum);
    }

    String toRoman(int number) {
        int l =  conversionTable.floorKey(number);
        if ( number == l ) {
            return conversionTable.get(number);
        }
        return conversionTable.get(l) + toRoman(number-l);
    }

    Integer toDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();

        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("No %s allowed here", romanNumber));
            }

        }
        return decimal;
    }

    private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }


}

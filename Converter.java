import java.util.TreeMap;


public class Converter {
    TreeMap<Character, Integer> romMap = new TreeMap<>();
    TreeMap<Integer, String> arabMap = new TreeMap<>();


    public boolean roman(String numOfExample) {
        return romMap.containsKey(numOfExample.charAt(0));
    }

    public Converter() {
        romMap.put('I', 1);
        romMap.put('V', 5);
        romMap.put('X', 10);
        romMap.put('L', 50);
        romMap.put('C', 100);

        arabMap.put(1, "I");
        arabMap.put(4, "IV");
        arabMap.put(5, "V");
        arabMap.put(9, "IX");
        arabMap.put(10, "X");
        arabMap.put(40, "XL");
        arabMap.put(50, "L");
        arabMap.put(90, "XC");
        arabMap.put(100, "C");
    }

    public String arabToRoman(int result) {
        String romNumber = "";
        int arabianNumber;
        do {
            arabianNumber = arabMap.floorKey(result);
            romNumber += arabMap.get(arabianNumber);
            result -= arabianNumber;
        } while (result != 0);
        return romNumber;
    }

    public int romanToArab(String numOfExample) {
        int end = numOfExample.length() - 1;
        char[] array = numOfExample.toCharArray();
        int arabian;
        int result = romMap.get(array[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romMap.get(array[i]);
            if (arabian < romMap.get(array[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}


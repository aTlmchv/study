import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        System.out.print("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ответ: " + calc(scanner.nextLine()));
    }

    public static  String calc(String input) {
        String example = input;
        example = example.replace(" ", "");
        String[] num = example.split(" ");
        String operation = "";


        if (example.contains("+")) {
            num = example.split("\\+");
            operation = "+";
        } else if (example.contains("-")) {
            num = example.split("-");
            operation = "-";
        } else if (example.contains("*")) {
            num = example.split("\\*");
            operation = "*";
        } else if (example.contains("/")) {
            num = example.split("/");
            operation = "/";
        }


        if (num.length < 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "throws Exception //т.к. строка не является математической операцией";
            }
        } else if (num.length > 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "trows Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
        }


        Converter converter = new Converter();
        if (converter.roman(num[0]) == converter.roman(num[1])) {
            int a,b;
            boolean roman = converter.roman(num[0]);
            if (roman) {
                a = converter.romanToArab(num[0]);
                b = converter.romanToArab(num[1]);
            } else {
                a = Integer.parseInt(num[0]);
                b = Integer.parseInt(num[1]);
            }
            if (a <= 0 || a > 10 ||  b <= 0 || b > 10) {
                return "Введите числа от 1 до 10";
            }

            int result;
            String resultToStr;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
                }

            if (result <=0 & roman) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    return "throws Exception //т.к. в римской системе нет отрицательных чисел";
                }
            } else if (roman) {
                return converter.arabToRoman(result);
            } else {
                resultToStr = Integer.toString(result);
                return resultToStr;
            }
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "throws Exception //т.к. используются одновременно разные системы счисления";
            }
        }
    }
}

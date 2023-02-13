import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scannerNew = new Scanner(System.in);
        calc(String.valueOf(scannerNew));
    }
    public static String calc(String input) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите выражение:");
        input = scanner.nextLine();
        String [] userInputSplit = input.split(" ");
        String first = userInputSplit[0];
        String action = userInputSplit[1];
        String second = userInputSplit[2];


        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String[] arabic ={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


        if (first.contains(".")||(second.contains(".")))
        {throw new Exception("Дробные не считает(");
        }


        if ((Arrays.asList(roman).contains(first) && Arrays.asList(arabic).contains(second))||
                ((Arrays.asList(arabic).contains(first)) && (Arrays.asList(roman).contains(second)))){
            throw new Exception("Оба числа должны быть из одной системы(");
        }


        int romanMarkerOne = 0;
        int romanMarkerTwo = 0;
        switch (first){
            case "I" -> {first = "1"; romanMarkerOne = 1;}
            case "II" -> {first = "2"; romanMarkerOne = 1;}
            case "III" -> {first = "3"; romanMarkerOne = 1;}
            case "IV" -> {first = "4"; romanMarkerOne = 1;}
            case "V" -> {first = "5"; romanMarkerOne = 1;}
            case "VI" -> {first = "6"; romanMarkerOne = 1;}
            case "VII" -> {first = "7"; romanMarkerOne = 1;}
            case "VIII" -> {first = "8"; romanMarkerOne = 1;}
            case "IX" -> {first = "9"; romanMarkerOne = 1;}
            case "X" -> {first = "10"; romanMarkerOne = 1;}
        }
        switch (second){
            case "I" -> {second = "1"; romanMarkerTwo = 1;}
            case "II" -> {second = "2"; romanMarkerTwo = 1;}
            case "III" -> {second = "3"; romanMarkerTwo = 1;}
            case "IV" -> {second = "4"; romanMarkerTwo = 1;}
            case "V" -> {second = "5"; romanMarkerTwo = 1;}
            case "VI" -> {second = "6"; romanMarkerTwo = 1;}
            case "VII" -> {second = "7"; romanMarkerTwo = 1;}
            case "VIII" -> {second = "8"; romanMarkerTwo = 1;}
            case "IX" -> {second = "9"; romanMarkerTwo = 1;}
            case "X" -> {second = "10"; romanMarkerTwo = 1;}
        }

        int firstInt = Integer.parseInt(first);
        int secondInt = Integer.parseInt(second);

        if (1 > firstInt || 1 > secondInt)
        {throw new Exception("Too small");}
        if (firstInt > 10 || secondInt > 10)
        {throw new Exception("Too big");}

        if (action.contains("-")||
                (action.contains("+"))||
                (action.contains("/"))||
                (action.contains("*")))
        {System.out.print("");
        }
        else {throw new Exception("Отсутствует знак вычисления(");
        }


        int x = switch (action) {
            case "-" -> (firstInt - secondInt);
            case "+" -> (firstInt + secondInt);
            case "/" -> (firstInt / secondInt);
            case "*" -> (firstInt * secondInt);
            default -> 0;
        };


        if (romanMarkerOne == 1 && romanMarkerTwo == 1 && x <= 0 ){
            throw new Exception("Нельзя считать отрицательные значения(");
        }


        if (userInputSplit.length != 3){throw new Exception("Некорректное выражение(");
        }

        String result = "";
        if (romanMarkerOne == 1 && romanMarkerTwo == 1){
            int index = x - 1;
            result = roman[index];
            System.out.println(result);
        } else{

            result = String.valueOf(x);
            System.out.println(result);
        }
        return (result);
    }

}
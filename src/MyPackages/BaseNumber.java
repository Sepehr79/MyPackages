package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *working with number at different bases
 * @author Sepehr79
 */
public class BaseNumber{

    private String number;
    private String base;
    private final HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() {{put('0', 0);put('1', 1);
    put('2', 2);put('3', 3);
    put('4', 4);put('5', 5);
    put('6', 6);put('7', 7);
    put('8', 8);put('9', 9);
    put('A', 10);put('B', 11);
    put('C', 12);put('D', 13);
    put('E', 14);put('F', 15);}};

    /**
     * @throws WrongBaseFormatException if base number is bigger than number.
     */
    public BaseNumber(String number, String base){
        this.number = number;
        this.base = base;

        try {
            checkValidNumber(this.number);
            checkValidBaseNumber(base);
        } catch (WrongBaseFormatException e) {
            e.printStackTrace();
        }
    }

    public BaseNumber(String number){
        this.number = number;
        this.base = "10";

        try {
            checkValidDecimalNumber(this.number);
            } catch (WrongBaseFormatException wrongBaseFormatException) {
            wrongBaseFormatException.printStackTrace();
        }
    }

    /**
     *
     * @return number at base 10.
     */
    public String convertToBaseTen(){
        int sum = 0;

        for (int i = number.length() - 1 ; i >= 0 ; i--){
            sum += hashMap.get(number.charAt(i)) * Math.pow(Integer.parseInt(base), number.length() - 1 - i);
        }
        this.number = String.valueOf(sum);
        this.base = String.valueOf(10);

        return number;
    }

    /**
     *
     * @param base new base of number.
     */
    public String convertToBase(String base){
        try {
            checkValidBaseNumber(base);
        } catch (WrongBaseFormatException e) {
            e.printStackTrace();
            return "";
        }

        int baseOfNumber = Integer.parseInt(base);
        int number = Integer.parseInt(convertToBaseTen());
        Stack<Character> stack = new Stack<>();

        while(number != 0) {
            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == number % baseOfNumber) {
                    stack.push(entry.getKey());
                }
            }
            number = number / baseOfNumber;
        }

        this.number = "";
        while (!stack.isEmpty()){
            this.number += stack.pop();
        }
        this.base = String.valueOf(baseOfNumber);
        return this.number;
    }

    //getters and setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws WrongBaseFormatException {
        this.number = number;

        checkValidNumber(this.number);
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.convertToBase(base);
    }


    //Method for making exceptions
    private void checkValidNumber(String number) throws WrongBaseFormatException {
        if(number.matches(".*[a-zG-Z].*")){
            throw new WrongBaseFormatException("wrong characters, valid characters are A to F");
        }
        for(int i = 0 ; i < number.length() ; i++){
            if( hashMap.get(number.charAt(i)) >= Integer.parseInt(base)){
                throw new WrongBaseFormatException("Some digits of number is more than its base");
            }
        }
    }

    private void checkValidDecimalNumber(String number) throws WrongBaseFormatException {
        if (number.matches(".*[a-zA-Z].*"))
            throw new WrongBaseFormatException("for decimal numbers you should enter characters between 0 to 9");
    }

    private void checkValidBaseNumber(String base) throws WrongBaseFormatException {
        if (base.matches(".*[^0-9].*") || (Integer.parseInt(base) > 16 && Integer.parseInt(base) > 1)){
            throw new WrongBaseFormatException("Base number must be less than 17 and only with number characters");
        }
    }


    /**
     * our Exception to control inputs at
     */
    static class WrongBaseFormatException extends Exception{
        public WrongBaseFormatException(){
            super();
        }
        public WrongBaseFormatException(String message){
            super(message);
        }
        @Override
        public String toString(){
            String text = "Wrong format of input numbers";
            return (!(this.getMessage() == null))? text + ": " + this.getMessage(): text;
        }
    }
}






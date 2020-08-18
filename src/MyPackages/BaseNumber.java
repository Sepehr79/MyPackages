package MyPackages;

import java.util.Stack;

/**
 *working with number at different bases
 */
public class BaseNumber {

    private String number;
    private String base;

    /**
     *
     * @param number
     * @param base
     * @throws WrongBaseFormatException if base number is bigger than number.
     */
    public BaseNumber(String number, String base) throws WrongBaseFormatException {
        this.number = number;
        this.base = base;

        for(int i = 0 ; i < number.length() ; i++){
            if (Character.getNumericValue(number.charAt(i)) >= Integer.parseInt(base)){
                throw new WrongBaseFormatException("Please change number or its base.");
            }
        }
    }
    public BaseNumber(String number){
        this.number = number;
        this.base = "10";
    }

    /**
     *
     * @return number at base 10.
     */
    public String convertToBaseTen(){
        int sum = 0;

        for (int i = number.length() - 1 ; i >= 0 ; i--){
            sum += Character.getNumericValue(number.charAt(i)) * Math.pow(Integer.parseInt(base), number.length() -1 - i);
        }
        this.number = String.valueOf(sum);
        this.base = String.valueOf(10);

        return number;
    }

    /**
     *
     * @param base new base of number.
     * @return number at base you want.
     */
    public String convertToBase(String base){
        int baseOfNumber = Integer.valueOf(base);
        int number = Integer.parseInt(convertToBaseTen());
        Stack<String> stack = new Stack<>();

        while(number != 0) {
            stack.push(String.valueOf(number % baseOfNumber));
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

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}


/**
 * our Exception to control inputs at
 */
class WrongBaseFormatException extends Exception{

    public  WrongBaseFormatException(){
        super();
    }
    public WrongBaseFormatException(String message){
        super(message);
    }

    @Override
    public String toString(){
        return (!(this.getMessage() == null))? "The input number is grater than its base" + ": " + this.getMessage(): "The input number is grater than its base";
    }
}

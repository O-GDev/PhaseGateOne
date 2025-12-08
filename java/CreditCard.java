import java.util.Scanner;
import java.util.Arrays;
public class CreditCard{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, kindly enter card details to verify");
        long cardNumber = input.nextLong();
        String cardsType = cardType(cardNumber);
        int lengthOfCreditCardNumber = lengthOfCardNumber(cardNumber);
        String isValid = ifDivisibleByTen(cardNumber);

        System.out.printf("*******************************************%n**Credit Card Type: %s%n**Credit Card Number: %d%n**Credit Card Digit length: %d%n**Credit Card Validity Status: %s%n*******************************************%n",cardsType,cardNumber,lengthOfCreditCardNumber,isValid);       

    }


    public static String cardType(long number){
    long[] numbers = convertToArray(number);
    String type = "Invalid Card Details";
    if(numbers[0]==4){
        type = "Visa Cards";
        }else if(numbers[0]==5){
        type = "MasterCard";
        }else if(numbers[0]==6){
        type = "Dicover cards";    
        }else if(numbers[0]==3 && numbers[1]==7){
        type = "American Express Cards";
        }else{
        type = "Invalid Card Details";
        }

        return type;
    }


    public static long[] convertToArray(long number){
        String stringNumber = number + "";
        int lengthOfDigit = stringNumber.length();
        long[] cardNumberArray = new long[lengthOfDigit];
        for(int count =lengthOfDigit-1;count>=0;count--){
            cardNumberArray[count] = number%10;
            number/=10;
        }
        return cardNumberArray;
    }

    public static long checkIfIsTwoDigit(long number){
        long newNumber = 0;
        if(number>9){
        for(int count=0; count<2;count++){
            long remainder=number%10;
            newNumber+=remainder;
            number/=10;
            }
        }else{
           newNumber = number;
        }
        return newNumber;
    }

    public static long doubleAndAddSecondDigit(long[] numbers){
        long sum=0;
        for(int count=numbers.length-2;count>=0;count-=2){
        long newNumber = numbers[count]*2;
        long number = checkIfIsTwoDigit(newNumber);
        sum+=number;
        }
        return sum;
    }

    public static long addAllOddIndex(long[] numbers){
        long sum=0;
        for(int count=numbers.length-1;count>=0;count-=2){
        sum+=numbers[count];
        }
        return sum;
    }

    public static long sumOfOddAndEvenIndex(long[] numbers){
    long doubleAndAddSecondDigits = doubleAndAddSecondDigit(numbers);
    long addAllOddIndexes = addAllOddIndex(numbers);
    
    long sum = doubleAndAddSecondDigits + addAllOddIndexes;

    return sum;
    }

    public static int lengthOfCardNumber(long number){
        long[] numbers = convertToArray(number);
        return numbers.length;
    }

    public static String ifDivisibleByTen(long number){
        long[] numbers = convertToArray(number);
        String status = "Invalid";
        long sum = sumOfOddAndEvenIndex(numbers);
        if(sum%10==0){
            return "Valid";
        }
        return "Invalid";
    }
}

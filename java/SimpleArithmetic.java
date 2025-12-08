import java.util.Random;
import java.util.Scanner;
public class SimpleArithmetic{
    public static void main(String[] args){
       int[] resultArr = askTenQuestion();

        System.out.printf("you passed %d question and you failed %d question in seconds",resultArr[1],resultArr[0]);
//System.currentTimeMillis()
    }

public static int[] randomSubtraction(int numberOne, int numberTwo){
    int moveOn = 1;
    int failed = 0;
    int passed = 0;
    int result = 0;
    int userResult = 0;
    int count = 0;
    Scanner input = new Scanner(System.in);
    if(numberOne>numberTwo){
         result = numberOne - numberTwo;     
        }else if(numberTwo>numberOne){
            result = numberTwo - numberOne;
            }
        if(numberOne>numberTwo){
        System.out.printf("%d - %d =%n", numberOne,numberTwo);
        System.out.println("Enter your answer: ");
        userResult = input.nextInt(); 
        }else if(numberTwo>numberOne){
        System.out.printf("%d - %d =%n",numberTwo, numberOne);
        System.out.println("Enter your answer: ");
        userResult = input.nextInt(); 
            }
        if(result == userResult){
            passed++;
            moveOn = 1;
            }else{
            moveOn = 0;
            count=0;
            while(count!=2 && moveOn==0){
        if(numberOne>numberTwo){
        System.out.printf("%d - %d =%n", numberOne,numberTwo);
        System.out.println("Enter your answer: ");
        userResult = input.nextInt(); 
        }else if(numberTwo>numberOne){
        System.out.printf("%d - %d =%n",numberTwo, numberOne);
        System.out.println("Enter your answer: ");
        userResult = input.nextInt(); 
            }
            if(userResult == result){
            count+=2;
            moveOn = 1;
            }else{
            count++;
            moveOn = 0;
            }

            }
            moveOn = 1;
if(userResult == result){passed++;}else{failed++;}
            }
    int[] finalResult = {failed,passed,moveOn};
    return finalResult;
}

public static int[] askTenQuestion(){
    Random random = new Random();
    int[] moveOn= new int[3];
    int questionCount=0;
    while(questionCount < 10){
        int numberOne = random.nextInt(1,100);
        int numberTwo = random.nextInt(1,100);
        moveOn = randomSubtraction(numberOne, numberTwo);
        if(moveOn[2] == 1){
        questionCount++;
        }
    }
    return moveOn;
    
}
}

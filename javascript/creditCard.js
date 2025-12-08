const input = require("prompt-sync")();

let cardNumber = input("Hello, kindly enter card details to verify: ");


console.log(`
*******************************************
** Credit Card Type: ${cardType(cardNumber)}
** Credit Card Number: ${cardNumber}
** Credit Card Digit Length: ${cardNumber.length}
** Credit Card Validity Status: ${ifDivisibleByTen(cardNumber)}
*******************************************
`);

    function cardType(number){
    const numbers = convertToArray(number);
    let type = "Invalid Card Details";
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


    function convertToArray(number){
        let stringNumber = number.toString();
        let lengthOfDigit = stringNumber.length;
        const cardNumberArray = [];
        for(let count =lengthOfDigit-1;count>=0;count--){
            cardNumberArray[count] = number%10;
            number =Math.floor(number/10);
        }
//        console.log(cardNumberArray);
        return cardNumberArray;
    }

    function checkIfIsTwoDigit(number){
        let newNumber = 0;
        if(number>9){
        for(let count=0; count<2;count++){
            let remainder=number%10;
            newNumber+=remainder;
            number = Math.floor(number/10);
            }
        }else{
           newNumber = number;
        }
        return newNumber;
    }

    function doubleAndAddSecondDigit(numbers){
        let sum=0;
        for(let count=numbers.length-2;count>=0;count-=2){
        let newNumber = numbers[count]*2;
        let number = checkIfIsTwoDigit(newNumber);
        sum+=number;
        }
        return sum;
    }

    function addAllOddIndex(numbers){
        let sum=0;
        for(let count=numbers.length-1;count>=0;count-=2){
        sum+=numbers[count];
        }
        return sum;
    }

    function sumOfOddAndEvenIndex(numbers){
    let doubleAndAddSecondDigits = doubleAndAddSecondDigit(numbers);
    let addAllOddIndexes = addAllOddIndex(numbers);
    
    let sum = doubleAndAddSecondDigits + addAllOddIndexes;

    return sum;
    }

    function lengthOfCardNumber(number){
        let numbers = convertToArray(number);
        return numbers.length;
    }

    function ifDivisibleByTen(number){
        let numbers = convertToArray(number);
        let status = "Invalid";
        let sum = sumOfOddAndEvenIndex(numbers);
        if(sum%10==0){
            return "Valid";
        }
        return "Invalid";
    }


const input = require("prompt-sync")();
let failed = 0
let passed = 0
let result = 0
let userResult = 0
let count = 0
let questionCount = 0
let startTime = 0
let endTime = 0
function randomSubtraction(numberOne, numberTwo){
    startTime= Date.now()
    moveOn = true
    if(numberOne>numberTwo){
         result = numberOne - numberTwo       
        }else if(numberTwo>numberOne){
            result = numberTwo - numberOne
            }
        if(numberOne>numberTwo){
        console.log(`${numberOne} - ${numberTwo} =`)
        userResult = input("Enter your answer: ")      
        }else if(numberTwo>numberOne){
        console.log(`${numberTwo} - ${numberOne} =`)
        userResult = input("Enter your answer: ")
            }
        if(result == userResult){
            passed++
            moveOn = true
            }else{
            moveOn = false
            count=0
            while(count!=1 && moveOn==false){
        if(numberOne>numberTwo){
        console.log(`${numberOne} - ${numberTwo} =`)
        userResult = input("Enter your answer: ")      
        }else if(numberTwo>numberOne){
        console.log(`${numberTwo} - ${numberOne} =`)
        userResult = input("Enter your answer: ")
            }
            if(userResult == result){
            count+=2
            moveOn = true
            }else{
            count++
            moveOn = false
            }

            }
            moveOn = true
if(userResult == result){passed++}else{failed++}
            }
    return moveOn;
}
function askTenQuestion(){
    
    while(questionCount < 10){
        const numberOne = parseInt(Math.random(1,100)*100)
        const numberTwo = parseInt(Math.random(1,100)*100)
        let moveOn = randomSubtraction(numberOne, numberTwo)
        if(moveOn == true){
        questionCount++
        }
    }
    startTime= Date.now()
    let totalTime = startTime - endTime
    console.log(`you passed ${passed} question and you failed ${failed} question in ${totalTime} seconds `)
}
askTenQuestion()

//console.log(startTime)

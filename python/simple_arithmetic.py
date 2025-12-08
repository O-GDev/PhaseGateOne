import random
#for count in range(0,11):



def try_again(result,first_random_number,second_random_number):
    count =0
    passed = 0
    failed = 0
    while count < 2:
        userResult = int(input(f"{first_random_number}-{second_random_number} = "))
        if(userResult == result):
            passed+=1
            count=2
            break;
        count+=1
        failed+=1
    return passed,failed,count


def ask_ten_question(result,first_random_number,second_random_number):
    counter=0
#    result = generate_question()
    while counter<11:
        result = try_again(result,first_random_number,second_random_number)
        if result[2] == 2:
             counter+=1



def generate_question():
    first_random_number = random.randint(0,100)
    second_random_number = random.randint(0,100)
    result=0
    if first_random_number > second_random_number:
    #   print()
       result = first_random_number-second_random_number

    if second_random_number>first_random_number:
       result = second_random_number-first_random_number
    question = ask_ten_question(result,first_random_number,second_random_number)
    return question

print(generate_question())

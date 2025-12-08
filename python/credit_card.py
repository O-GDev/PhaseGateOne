
print("Hello, kindly enter card details to verify")
card_number = input().strip()

if not card_number.isdigit():
    print("*******************************************")
    print("** Invalid input: Card number must contain only digits.")
    print("*******************************************")
#    return "Invalid"

number = int(card_number)


def convert_to_array(number):
    return [int(digit) for digit in str(number)]


def card_type(number):
    digits = convert_to_array(number)
    type_name = "Invalid Card Details"

    if digits[0] == 4:
        type_name = "Visa Cards"
    elif digits[0] == 5:
        type_name = "MasterCard"
    elif digits[0] == 6:
        type_name = "Discover Cards"
    elif digits[0] == 3 and len(digits) > 1 and digits[1] == 7:
        type_name = "American Express Cards"

    return type_name


def check_if_two_digit(number):
    if number > 9:
        return (number // 10) + (number % 10)
    return number


def double_and_add_second_digit(digits):
    total = 0
    for i in range(len(digits) - 2, -1, -2):
        doubled = digits[i] * 2
        total += check_if_two_digit(doubled)
    return total


def add_all_odd_index(digits):
    total = 0
    for i in range(len(digits) - 1, -1, -2):
        total += digits[i]
    return total


def sum_of_odd_and_even_index(digits):
    return double_and_add_second_digit(digits) + add_all_odd_index(digits)


def is_divisible_by_ten(number):
    digits = convert_to_array(number)
    total_sum = sum_of_odd_and_even_index(digits)
    return "Valid" if total_sum % 10 == 0 else "Invalid"


card_type_name = card_type(number)
length_of_card = len(card_number)
validity_status = is_divisible_by_ten(number)
print("*******************************************")
print(f"** Credit Card Type: {card_type_name}")
print(f"** Credit Card Number: {number}")
print(f"** Credit Card Digit length: {length_of_card}")
print(f"** Credit Card Validity Status: {validity_status}")
print("*******************************************")


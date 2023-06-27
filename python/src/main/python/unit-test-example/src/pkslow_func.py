import os


def Sum(number1, number2):
    return number1 + number2


def Random(number):
    return '%d%s' % (number, os.urandom(number))
# decorator function to convert to lowercase
def lowercase_decorator(function):
    def wrapper():
        func = function()
        string_lowercase = func.lower()
        return string_lowercase

    return wrapper


# decorator function to split words
def splitter_decorator(function):
    def wrapper():
        func = function()
        string_split = func.split()
        return string_split

    return wrapper


def logging_decorator(function):
    def wrapper():
        print('executing %s' % function)
        func = function()
        print('executed %s' % function)
        return func

    return wrapper


def printall(func):
    def inner(*args, **kwargs):
        print('Arguments for args: {}'.format(args))
        print('Arguments for kwargs: {}'.format(kwargs))
        return func(*args, **kwargs)

    return inner


@splitter_decorator  # this is executed next
@lowercase_decorator  # this is executed first
@logging_decorator
def hello():
    print('This is a hello function')
    return 'Hi, www.pkslow.com LARRY DENG'


@printall
def show(name, age, website='www.pkslow.com'):
    print('My name is ' + name + ', my age is ' + str(age) + ', my website is ' + website)


if __name__ == '__main__':
    print(hello())
    show('Larry', 18, website='www.pkslow.com')

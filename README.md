> Exception Handling
> - is the process of detecting, managing and responding to errors.
> - so that the application doesn't crash and recover.
> 
> Try catch
> - Mulitple catches if multiple types of errors are possible

> ExceptionHandler
> - @ExceptionHandler > small - mid size application
> 
> Checked Exception
> - SuperClass > java.lang.Exception
> - Compile-time > must be declared with throw in a method signature or caught in a try catch block
> - IOException/FileNotFoundException
> - SQLException
> - ClassNotFoundException
> 
> Unchecked Exceptions
> - SuperClass > java.lang.RunTimeException
> - NullPointerException
> - ArithmeticException

Spring ExceptionHandlerExceptionResolver - this will call the @Exception handler methods 

> ControllerAdvice - GlobalExceptionHandler

Flyway Migration
-----
Product > Production DB 6 columns

database > house
db schema > layout of your house

add a new bedroom(add new table)
kitchen > new sink > add a new column to the table

Database migration > Renovation Instructions

A migration is a set of instructions that allows to safely change the layout of the schema while people are still living the house

Flyway Migration - open source db migration tool, like a smart renovation manager


## Homework

1. Update the code to store the baseurl of fakestore in the env variables.
2. Integrate at least 2 more APIs of your choice (Get products of category, Get single product) using retrofit
3. Try and make another gateway which uses some other library like OkHTTP and see how you can manage two different gateway implementations

Checked Exception
- SuperClass > java.lang.Exception
- Compile-time > must be declared with throw in a method signature or caught in a try catch block
- IOException/FileNotFoundException
- SQLException
- ClassNotFoundException

Unchecked Exceptions
- SuperClass > java.lang.RunTimeException
- NullPointerException
- ArithmeticException

Spring ExceptionHandlerExceptionResolver - this will call the @Exception handler methods 

> ControllerAdvice - GlobalExceptionHandler


## Homework

1. Update the code to store the baseurl of fakestore in the env variables.
2. Integrate at least 2 more APIs of your choice (Get products of category, Get single product) using retrofit
3. Try and make another gateway which uses some other library like OkHTTP and see how you can manage two different gateway implementations
package sem3.error.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
Simple example used to demo:
 - Checked Exceptions
 - Un-checked Exceptions
 - Write and Throw our own Exceptions
 - Errors

 Just comment out the @Controller annotation below, when you have come to the part that focus on REST Error-handling
*/

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
@Controller
public class ExceptionDemoRunner implements CommandLineRunner {

    public void checkedExceptionDemo() throws FileNotFoundException {

    }

    public void runtimeExceptionDemo(){

    }

    public void ownException() throws MyException {

    }

    public void errorDemo() {

    }

    @Override
    public void run(String... args) throws Exception {
        try {
            //checkedExceptionDemo();
            //runtimeExceptionDemo();
            //ownException();
            errorDemo();
        }catch (Throwable e){  //You should "never" catch Throwable in "real life", since it will also catch Error's
            System.out.println("Exception Type: "+e.getClass());
            System.out.println("Message: "+e.getMessage());

        }
    }
}

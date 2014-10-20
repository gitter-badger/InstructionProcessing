# Instruction Processing Challenge - Travis Perkins
## By Adnan Gazi
## Created 20/10/2014

## Compiling and Testing
The code was written and tested in Intellij IDEA 13.1 using Maven 3.2.3 and JUnit 4.11. As such, it should be possible
to compile and test the code using `mvn compile` and `mvn test` respectively using this version of Maven.

## Feature Checklist
Using the provided spec, I have made a checklist of features which I will be completing throughout the challenge using
a test-driven approach.

The Instruction Queue:

 - [x] Supports any number of InstructionMessages - by nature of PriorityQueue class
 - [x] Prioritises InstructionMessages according to the values below
        
        0 < n < 11 -> High
        10 < n < 91 -> Medium
        90 < n < 100 -> Low
    where `n` is the InstructionType attribute.
 
 - [x] Has a method that returns the number of InstructionMessages on it - by nature of Collection class
 - [x] Has a method for placing InstructionMessages onto the queue - by nature of Collection class
 - [x] Has a method for removing InstructionMessages from the queue - by nature of Collection class
 - [x] Has a method for retrieving the InstructionMessage at the front of the queue - by nature of Collection class
 - [x] Has a method for determining if the queue is empty - by nature of Collection class
 - [x] Throws an InvalidMessageException if an invalid InstructionMessage is placed on it - in InstructionMessage
    constructor
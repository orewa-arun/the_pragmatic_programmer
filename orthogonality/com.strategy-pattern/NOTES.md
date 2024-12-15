## Three things should come to one's mind when they think of strategy pattern:
    1. Strategy, this should come first to your mind, it is the interface that emcompasses all the basic functions that our use case requires.
    2. Context, It simply describes the context of our problem, the environment of the problem.
    3. Processor, It is the class that encapsulates the strategy interface within it so that it can be used for polymorphism, enabling us to change horses even when the application is running. It also contains a higher level abstraction of the methods inside the strategy interface, skillfully isolating the inner workings of the processor from the outside world.


## Excercise problem :

Let’s see with an example of when the Strategy Pattern can be applied. Imagine that we want developing an app that prints the book’s title in a different format given an input.
For example, the title of the book is “Harry Potter”, and these are the possible format that our app supports:
- Print the first character of the title is in lowercase: Eg: “harry Potter.”
- Print the title in upper case: Eg: “HARRY POTTER.”
- Print the title in lower case. E.g., “harry potter.”

source : https://medium.com/@anca.rebeca/strategy-pattern-ff43da815104

### First thoughts :

1. Well, the strategy interface method will be format.
2. Context will contain the text and the formatType request.
3. FormatProcessor will encompass the strategy interface as its private member and will contain setFormatStrategy() method to apply polymorphism with multiple implementations of the format strategy.
4. Create a new implementation of formatStrategy every time a new formatter is created.


#### BONUS :
    In the article by rebeca, she mentions that this strategy implementation fulfills the O - "Open for extension, but closed for modification"( With respect to classes, modules, functions) principle in SOLID principle.
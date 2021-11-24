# Rect Compiler Java

This project aims to eventually produce a ReCT compiler written in Java. 
The project will begin with smaller steps; starting out with a reduced and simplified specification. The project will begin as an interpreter instead of a compiler as well. The end goal of this project is to produce a rival to the original ReCT compiler, rctc, written in C#.

## Version 1 specification
This is the first simplified specification the project will aim to achieve. 

### Local variables
Define and initiate local variables. Including `int`, `string`, and `bool` data types.
```js
var test <- 100;
var example string;
example <- "Hello, World!";
test <- 0;
```

### If statements
Standard if and else statements.
```js
if (true) {
    test <- 5;
} else {
    test <- 10;
}
```

### Expression evaluation
The interpreter should be able to work out `1 + 2 * 8 - 10 / 2` in the correct order.

### Pre-defined functions
List of pre-defined functions:
- `Print(string)`
- `die(int)`



package com.problems.java;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid.
That means the expression would always evaluate to a result, and there will not be any division by zero operation.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] input = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = evalRPN(input);
        System.out.println(result);
    }

    private static int evalRPN(String[] input) {
        int result = 0;
        String operators = "+-/*";
        Stack<String> stack = new Stack<>();
        for (String s: input){
            if(!operators.contains(s)){
                stack.push(s);
            } else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                switch (s){
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a / b));
                        break;
                }
            }
        }
        result = Integer.parseInt(stack.pop());
        return result;
    }

}

package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String expression;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter expression: ");
            expression= keyboard.nextLine();
            Tree tree = new Tree(expression);

        System.out.println( "\n" + "Result: ");

        if (Expression.check_brackets(expression)) {
                int result = Expression.calculate(tree.get_tree(), true);
               System.out.println( result);}
            else  System.out.println("\n" +   "The expression is incorrect");
    }
}
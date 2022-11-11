package org.example;

class Expression {

    static void print_details(Branch Tree, int f) {
        if (Tree != null) {
            print_details(Tree.right, f + 1);
            for (int i = 1; i <= f; i++) System.out.print("    ");
            System.out.println(Tree.elem);
            print_details(Tree.left, f + 1);
        }
    }
    static int calculate(Branch Tree, boolean f) {
        int first, second;
        if (Tree.left == null)
            return Tree.elem - '0';
        first = calculate(Tree.left, f);
        second = calculate(Tree.right, f);
        if (f){
        switch (Tree.elem) {
            case '+':
            {f=true;return  first + second;}
            case '-':
            {f=true;return  first - second;}
            case '*':
            {f=true;return  first * second;}
            case '/':
                if (second!=0) {f=true; return first / second;}
                else {
                    System.out.println("\n" +
                            "Error: division by zero");
                    f = false;
                }
        }}
        return -1;
    }


    static int Priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 5;
    }

    static boolean check_brackets(String Expr) {

        Stack stack = new Stack(null);
        int OK = 1;
        for (int i = 0; (OK == 1) && (i != Expr.length()); i++) {

            if (Expr.charAt(i) == '(') { // открывающая скобка
                stack.Push(Expr.charAt(i));
            } else if (Expr.charAt(i) == ')') { // закрывающая скобка
                if (stack.head == null)
                    OK = 0;
                else {
                    char upper = stack.Pop();
                    if (upper != '(')
                        OK = 0;
                }
            }

        }

        if ((stack.head == null) & (OK == 1)) {
            return true;
        } else {
            return false;
        }

    }
}

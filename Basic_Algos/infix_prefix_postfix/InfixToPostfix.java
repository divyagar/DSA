
/**
 * Infix to Postfix Conversion
 * Also known as Revese Polish Notation
 * 
 * Output : 
 * Enter Infix expression : a+b*(c^d-e)^(f+g*h)-i
 * Postfix expression : abcd^e-fgh*+^*+i-
 */

import java.util.*;
import java.lang.StringBuilder;

public class InfixToPostfix {
	private static int getPrecendence(char op) {
		if (op == '+' || op == '-')
			return 1;
		else if (op == '*' || op == '/')
			return 2;
		else if (op == '^')
			return 3;

		return 0;
	}

	private static String convertInfixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		int length = infix.length();

		for (int i = 0; i < length; ++i) {
			char ch = infix.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				postfix.append(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (!(stack.peek() == '(')) {
					postfix.append(stack.pop());
				}
				stack.pop();
			} else {
				int prec = getPrecendence(ch);
				while (!stack.isEmpty() && prec <= getPrecendence(stack.peek())) {
					postfix.append(stack.pop());
				}
				stack.push(ch);
			}
		}

		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	public static void main(String[] args) {
		System.out.print("Enter Infix expression : ");
		Scanner sc = new Scanner(System.in);
		String infix = sc.nextLine();

		System.out.println("Postfix expression : " + convertInfixToPostfix(infix));

	}
}
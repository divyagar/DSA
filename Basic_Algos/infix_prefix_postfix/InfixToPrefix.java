
/**
 * Infix to prefix conversion.
 * Prefix is also known as Polish Notation.
 * 
 * Output:
 * Enter Infix expression : x+y*z/w+u
 * Prefix expression : ++x/*yzwu
 * 
 */

import java.util.*;
import java.lang.StringBuilder;

public class InfixToPrefix {
	private static int getPrecendence(char op) {
		if (op == '+' || op == '-')
			return 1;
		else if (op == '*' || op == '/')
			return 2;
		else if (op == '^')
			return 3;

		return 0;
	}

	private static String convertInfixToPrefix(String infix) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		for (int i = infix.length() - 1; i >= 0; --i) {
			char ch = infix.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				sb.append(ch);
			} else if (ch == ')')
				stack.push(ch);
			else if (ch == '(') {
				while (stack.peek() != ')') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else {
				int prec = getPrecendence(ch);
				while (!stack.isEmpty() && prec < getPrecendence(stack.peek())) {
					sb.append(stack.pop());
				}
				stack.push(ch);
			}
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.print("Enter Infix expression : ");
		Scanner sc = new Scanner(System.in);
		String infix = sc.nextLine();

		System.out.println("Prefix expression : " + convertInfixToPrefix(infix));
	}

}

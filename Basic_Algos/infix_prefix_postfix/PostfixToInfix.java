
/**
 * Postfix to Infix conversion
 * 
 * Output: 
 * Enter postfix expression : ab*c+
 * Infix expression : ((a*b)+c)
 */

import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
	private static String convertPostfixToInfix(String postfix) {
		Stack<String> stack = new Stack<String>();
		int length = postfix.length();

		for (int i = 0; i < length; ++i) {
			char ch = postfix.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				stack.push(String.valueOf(ch));
			} else {
				String op1 = stack.pop(), op2 = stack.pop();
				stack.push('(' + op2 + ch + op1 + ')');
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter postfix expression : ");
		String postfix = sc.nextLine();

		System.out.println("Infix expression : " + convertPostfixToInfix(postfix));
	}

}

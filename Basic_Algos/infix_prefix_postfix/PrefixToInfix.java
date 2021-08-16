
/**
 * Prefix to Infix
 * 
 * Output: 
 * Enter prefix expression : *-A/BC-/AKL
 * Infix expression : ((A-(B/C))*((A/K)-L))
 */

import java.util.Scanner;
import java.util.Stack;
import java.lang.StringBuilder;

public class PrefixToInfix {
	private static String convertPrefixToInfix(String prefix) {
		int length = prefix.length();
		Stack<String> stack = new Stack<String>();

		for (int i = length - 1; i >= 0; --i) {
			char ch = prefix.charAt(i);
			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				stack.push(ch + "");
			} else {
				String op1 = stack.pop(), op2 = stack.pop();
				stack.push('(' + op1 + ch + op2 + ')');
			}
		}

		return new StringBuilder(stack.pop()).toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter prefix expression : ");
		String prefix = sc.nextLine();

		System.out.println("Infix expression : " + convertPrefixToInfix(prefix));
	}

}

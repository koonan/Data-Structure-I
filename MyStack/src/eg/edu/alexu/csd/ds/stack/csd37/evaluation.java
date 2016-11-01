package eg.edu.alexu.csd.ds.stack.csd37;

import java.util.Scanner;

import eg.edu.alexu.csd.ds.stack.MyStack;


public class evaluation {
	static MyStack expre = new stack();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		String infix = scr.nextLine();
		String[] arr1 = infix.split(" ");
		if (AreParanthesesBalanced(arr1) && ISFormula(arr1)) {
			String postfix = InfixtoPostfix(arr1);
			System.out.println(postfix);
			String[] arr2 = postfix.split(" ");
				try {
					Double res = evaluate(arr2);
					System.out.println(res);

				} catch (ArithmeticException aex) {
					System.out.println("denominator = 0");
				}
			
		} else {
			System.out.println("Error Input");
		}
		scr.close();
	}

	// evaluate the expression
	private static Double evaluate(String[] arr2) throws ArithmeticException {
		for (int i = 0; i < arr2.length; i++) {
			String c = arr2[i];
			if (!IsOperator(c)) {
				expre.push((Double.parseDouble(c)));
			} else {
				String n1 = "";
				n1 += expre.pop();
				Double num1 = Double.valueOf(n1);
				// System.out.println(num1);
				String n2 = "";
				n2 += expre.pop();
				Double num2 = Double.valueOf(n2);
				// System.out.println(num2);
				Double res = 0.0;
				char k = c.charAt(0);
				switch (k) {
				case '+':
					res = num1 + num2;
					break;
				case '-':
					res = num2 - num1;
					break;

				case '*':
					res = num1 * num2;
					break;
				case '/':
					if (num1 == 0) {
						throw new ArithmeticException();
					}
					res = num2 / num1;
					break;
				case '^':
					res = Math.pow(num2, num1);
					break;
				case '%':
					res = num2 % num1;
					break;

				}
				expre.push(res);
			}
		}
		return (Double) expre.peek();
	}

	// change from infix to postfix order
	public static String InfixtoPostfix(String[] infix) {
		String postfix = "";
		for (int i = 0; i < infix.length; i++) {
			String c = infix[i];
			char k = c.charAt(0);
			if (IsOperator(c)) {
				if (!expre.isEmpty()) {
					String l = (String) expre.peek();
					char o = l.charAt(0);
					while (!expre.isEmpty() && o != '('
							&& IsHigherPrecedence(o, k)&& k!='^') {
						postfix += (String) expre.peek();
						postfix += " ";
						expre.pop();
						if (!expre.isEmpty()) {
							l = (String) expre.peek();
							o = l.charAt(0);
						}
					}
				}

				if (!expre.isEmpty()) {
					String l = (String) expre.peek();
					char o = l.charAt(0);
					if (IsEgualPrecedence(o, k) && k!='^') {
						postfix += (char) expre.peek();
						postfix += " ";
						expre.pop();
					}
				}
				expre.push(c);
			} else if (k == '(') {
				expre.push(c);
			} else if (k == ')') {
				String l = (String) expre.peek();
				char o = l.charAt(0);
				while (!expre.isEmpty() && o != '(') {
					postfix += (String) expre.peek();
					postfix += " ";
					expre.pop();
					if (!expre.isEmpty()) {
						l = (String) expre.peek();
						o = l.charAt(0);
					}
				}
				expre.pop();
			} else {
				postfix += c;
				postfix += " ";

			}
		}
		while (!expre.isEmpty()) {
			postfix += (String) expre.peek();
			;
			postfix += " ";
			expre.pop();
		}

		return postfix;
	}

	// verify whether a character is operator symbol or not.
	public static boolean IsOperator(String i) {
		char c = i.charAt(0);
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%')
			return true;
		return false;
	}

	// get weight of an operator. An operator with higher weight will have
	// higher precedence.
	public static int GetOperatorWeight(char oper) {
		int weight = -1;
		switch (oper) {
		case '+':
		case '-':
			weight = 1;
			break;
		case '*':
		case '/':
		case '%':
			weight = 2;
			break;
		case '^':
			weight = 3;
			break;
		}

		return weight;
	}

	// verify which operator has first precedence
	public static boolean IsHigherPrecedence(char op1, char op2) {
		int w1 = GetOperatorWeight(op1);
		int w2 = GetOperatorWeight(op2);
		if (w1 == w2) {
			return true;
		} else if (w1 > w2) {
			return true;
		}
		return false;
	}

	// verify if two operators has the same precedence
	public static boolean IsEgualPrecedence(char op1, char op2) {
		int w1 = GetOperatorWeight(op1);
		int w2 = GetOperatorWeight(op2);
		if (w1 == w2) {
			return true;
		}
		return false;
	}

	// verify if the input is correct
	public static boolean AreParanthesesBalanced(String[] infix) {
		MyStack s = new stack();
		for (int i = 0; i < infix.length; i++) {
			if (infix[i].equals("(")) {
				s.push(infix[i]);
			}

			else if (infix[i].equals(")")) {

				if (s.isEmpty() || !ArePair((String) s.peek(), infix[i]))
					return false;
				else
					s.pop();
			}

		}
		return s.isEmpty();

	}

	// check pairs
	public static boolean ArePair(String first, String second) {
		if (first.equals("(") && second.equals(")")) {
			return true;
		} else
			return false;

	}

	// check correct input
	public static boolean ISFormula(String[] Formula) {
		int counter1 = 0;
		int counter2 = 0;

		for (int i = 0; i < Formula.length; i++) {

			if (isInteger(Formula[i])) {
				counter1++;

			}

			if (IsOperator(Formula[i])) {
				counter2++;
			}
		}
		if (counter1 == counter2 + 1)
			return true;
		return false;

	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}
	
}

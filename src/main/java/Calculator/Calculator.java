package Calculator;

import java.util.Scanner;

public class Calculator {
	public String input() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public int calculate(String input) {
		String[] arr = input.split(" ");

		int result = Integer.parseInt(arr[0]);
		String opration;

		for (int i = 1; i < arr.length; i = i + 2) {
			opration = arr[i];
			int num = Integer.parseInt(arr[i + 1]);
			result = operateResult(opration, num, result);
		}

		return result;
	}

	public int operateResult(String opration, int num, int result) {
		switch (opration) {
			case "+" :
				result = add(result, num);
				break;
			case "-" :
				result = subtraction(result, num);
				break;
			case "/" :
				result = divide(result, num);
				break;
			case "*" :
				result = multiply(result, num);
				break;
			default :
				throw new IllegalArgumentException("올바르지 않는 연산입니다.");
		}
		return result;
	}

	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int subtraction(int num1, int num2) {
		return num1 - num2;
	}

	public int divide(int num1, int num2) {
		return num1 / num2;
	}

	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
}

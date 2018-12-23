package algorithms;

import java.util.ArrayList;
import java.util.List;

public class EquationGenerator {

	public static void main(String[] args) {
		List<Integer> ans = generateEquation(15, 40, 20, 2);
		
		System.out.println("\n");
//		System.out.println("Answers: ");
//		for(int i = 0; i < ans.size(); i++) {
//			System.out.println((i+1) + ". " + ans.get(i));
//		}
	}

	/**
	 * 
	 * @param min			minimal value of the subtractor appears in the equation
	 * @param max			maximum value appears in the equation
	 * @param num			number of equation will be generated
	 * @param length		length of the equation
	 * @return
	 */
	private static List<Integer> generateEquation(int min, int max, int num, int length) {
		if(min >= max) return new ArrayList<Integer>();
		
		List<Integer> answers = new ArrayList<Integer>();
		List<String> equations = new ArrayList<String>();
		for(int i = 0; i < num; i++) {
			String equation = "";
			boolean plus = true;
			int lastTotal = 0;
			for(int j = 0; j < length; j++) {
				int val = 0;
				if (plus) {
					// plus
					val = ((int) (Math.random() * (max - min))) + min;
					lastTotal += val;
				} else {
					// last total too small, change it to plus
					if(lastTotal < min / 5 * 4) {
						val = ((int) (Math.random() * (max - min))) +  min / 2 * 3;
						lastTotal += val;
					} else {
						// last total large enough, do subtraction
						val = ((int) (Math.random() * lastTotal / 4 * 3)) + ((int) (Math.random() * lastTotal / 4));
						lastTotal -= val;
					}
				}
				
				if(j == length - 1) {
					equation += val;
				} else {
					plus = Math.random() >= 0.5;
					equation += val + " " + (plus? "+ ":"- ");
				}
			}
			equation += " =";
			//System.out.println(equation);
			answers.add(lastTotal);
			equations.add(equation);
		}
		
		for(int i = 0; i < equations.size(); i++) {
			System.out.println(equations.get(i));
			System.out.println("\n\n\n\n");
		}
		
		return answers;
	}
}

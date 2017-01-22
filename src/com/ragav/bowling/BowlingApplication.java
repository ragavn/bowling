package com.ragav.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BowlingApplication {
	
	private List<Integer> inputValues = new ArrayList<>();
	private int totalScore = 0;
		
	public BowlingApplication(List<Integer> inputValues) {
		super();
		this.inputValues = inputValues;
	}

	public List<Integer> getInputValues() {
		return inputValues;
	}

	public void setInputValues(List<Integer> inputValues) {
		this.inputValues = inputValues;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void calculateTotalScore() {
		int i = 0;
		while (i < inputValues.size()) {
			if(isStrike(i)) {
				totalScore += 10 + calculateStrikeBonus(i);
				i++;
			} else if(isSpare(i)) {
				totalScore += 10 + calculateSpareBonus(i);
				i += 2;
			} else {
				totalScore += inputValues.get(i) + inputValues.get(i + 1);
				i += 2;
			}
		}
	}
	
	public boolean isStrike(int index) {
		return inputValues.get(index) == 10;
	}
	
	public boolean isSpare(int index) {
		if((index + 1) < inputValues.size())
			return inputValues.get(index) + inputValues.get(index + 1) == 10;
		else
			return false;
	}
	
	public int calculateStrikeBonus(int index) {
		if((index + 2) < inputValues.size())
			return inputValues.get(index + 1) + inputValues.get(index + 2);
		else
			return 0;
	}
	
	public int calculateSpareBonus(int index) {
		if((index + 2) < inputValues.size())
			return inputValues.get(index + 2);
		else return 0;
	}
		
	public static void main(String...strings) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter input: ");
		String input = reader.nextLine();
		System.out.println(input);
		BowlingApplication app = new BowlingApplication(Arrays.asList(input.split(" "))
				.stream()
				.map(a -> Integer.parseInt(a))
				.collect(Collectors.toCollection(ArrayList::new)));
		app.calculateTotalScore();
		System.out.println("Total=" + app.getTotalScore());
	}
}

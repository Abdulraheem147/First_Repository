package com.sample;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	static int score = 0;

	public static void main(String[] args) {

		List<Question> quizQuestion = new ArrayList<Question>();
		Scanner scanner = new Scanner(System.in);
		// Adding sample quiz questions
		quizQuestion.add(
				new Question("What is the capital of India?", List.of("Delhi", "Chennai", "Kolkata", "Kerala"), 1));
		quizQuestion.add(new Question("Which one of the following is not a prime number?", List.of(31, 61, 71, 91), 4));
		quizQuestion.add(new Question("Neither i______Sam can help him", List.of("Neither", "Nor"), 2));
		quizQuestion.add(new Question("Shark are Mammals", List.of(true, false), 2));
		int totalQuestions = quizQuestion.size();
		quizQuestion.forEach(o -> {
			boolean isValidInput = false;
			System.out.println(o.getQuestion());
			o.getOption().forEach(option -> System.out.println((o.getOption().indexOf(option) + 1) + ":" + option));
			int userAnswer = 0;
			// boolean isValidInput = false;

			// Validate user input (using try-catch for InputMismatchException)
			while (!isValidInput) {
				try {
					System.out.print("Enter your answer (1-" + o.getOption().size() + "): ");
					userAnswer = scanner.nextInt();

					if (userAnswer >= 1 && userAnswer <= o.getOption().size()) {
						isValidInput = true;
						if (userAnswer == o.getCorrectoption()) {
							System.out.println("Correct!");
							score++;
						} else {
							System.out.println("Incorrect!");
						}
					} else {
						System.out.println("Invalid input. Please enter a number within the given range.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid number.");
					scanner.next(); // Consume invalid input to avoid an infinite loop`
				}
			}
			System.out.println();
			// System.out.print("Enter your answer (0-" + (o.getOption().size() ) + "): ");
			// int userAnswer = scanner.nextInt();
			// //int correctOptionIndex=o.getCorrectoption()-1;
			// if (userAnswer >= 1&& userAnswer <= o.getOption().size() && userAnswer ==
			// o.getCorrectoption()) {
			// System.out.println("Correct!");
			// score++;
			// } else {
			// System.out.println("Incorrect!");
			// }
			// System.out.println();
		});
		System.out.println("Quiz Completed");
		System.out.println("Your score is: " + score + " out of " + totalQuestions);
		scanner.close();

	}

}

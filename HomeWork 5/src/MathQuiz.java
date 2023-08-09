import java.util.Random;
import java.util.Scanner;

class MathQuiz {
    private static final int NUM_QUESTIONS = 6;
    private int score;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            char[] operators = {'+', '-', '*', '/'};
            char operator = operators[random.nextInt(operators.length)];

            int correctAnswer = calculateAnswer(num1, num2, operator);

            System.out.print("Question " + (i + 1) + ": " + num1 + " " + operator + " " + num2 + " = ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score += 5;
            } else {
                System.out.println("Incorrect!");
                score -= 5;
            }

            System.out.println("Your answer: " + userAnswer + ". Correct answer: " + correctAnswer +
                    ". Current score: " + score);
        }

        System.out.println("Quiz completed! Your final score: " + score);
    }

    private int calculateAnswer(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return Calculator.add(num1, num2);
            case '-':
                return Calculator.subtract(num1, num2);
            case '*':
                return Calculator.multiply(num1, num2);
            case '/':
                return Calculator.divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}

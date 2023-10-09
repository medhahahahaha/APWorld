package lessonOne;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5; 
        
        String[] questions = {
            "What were the primary items of trade on the Silk Roads?",
            "Which empires provided security for merchants?",
            "Why did Chinese emperors need horses from nomads?",
            "What technology was diffused along the Silk Roads in the post-classical age?",
            "Which empire invigorated Silk Road trade in the 13th century?",
            "What were the important innovations in transportation networks on the Silk Roads?",
            "What are caravanserai, and why were they significant?",
            "What role did the camel saddle play in Silk Road trade?",
            "What is 'flying money,' and how did it facilitate trade?",
            "What did merchants carry besides goods on the Silk Roads?"
        };

        String[] answers = {
            "Luxury goods",
            "Romans, Gupta, and Han",
            "Strong horses for military use",
            "Paper-making and gunpowder",
            "Mongol Empire",
            "Standardized caravan routes and resting points",
            "Inns for travelers; provided services and resting points",
            "Distributed weight evenly on a camel's back",
            "Documents for making payments; reduced the need for coins",
            "Cultural diffusion, including Buddhism, Christianity, and disease"
        };

        // create a list of question indices and shuffle it to randomize the order
        List<Integer> questionIndices = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            questionIndices.add(i);
        }
        Collections.shuffle(questionIndices);

        int score = 0;

        for (int i = 0; i < questionIndices.size(); i++) {
            int questionIndex = questionIndices.get(i);
            System.out.println("Question " + (i + 1) + ": " + questions[questionIndex]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            int attempts = 1;

            while (attempts < maxAttempts) {
                if (isAnswerCorrect(userAnswer, answers[questionIndex])) {
                    System.out.println("Correct!\n");
                    score++;
                    break;
                } else if (attempts == 2) {
                    System.out.println("Hint: " + getHint(questionIndex));
                } else {
                    System.out.println("Incorrect. Try again.");
                }

                System.out.print("Your answer (Attempt " + (attempts + 1) + "): ");
                userAnswer = scanner.nextLine();
                attempts++;
            }

            if (attempts >= maxAttempts) {
                System.out.println("Incorrect. The answer is: " + answers[questionIndex] + "\n");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questionIndices.size());
    }

    private static boolean isAnswerCorrect(String userAnswer, String correctAnswer) {
        // answer is correct if the user input contains 5-character segment anywhere in the correct answer
        return correctAnswer.toLowerCase().contains(userAnswer.toLowerCase().substring(0, Math.min(5, userAnswer.length())));
    }

    private static String getHint(int questionIndex) {
        // add ur own hints for questions here
        String[] hints = {
            "Trade focused on valuable, lightweight items.",
            "These empires provided security for merchants.",
            "Chinese horses were too frail for military use.",
            "Important technological innovations were spread.",
            "A powerful empire that unified the Silk Roads.",
            "Enhancements in the routes and resting places.",
            "These were like inns for travelers.",
            "It allowed camels to carry more goods.",
            "A method for making payments without transporting coins.",
            "Besides goods, merchants also carried something else."
        };

        return hints[questionIndex];
    }
}

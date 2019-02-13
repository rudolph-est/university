package za.co.bbd.university;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while(choice!=0) {

            System.out.println("What would you like to do?");
            System.out.println("1. Capture new student");
            System.out.println("2. Capture new course");
            System.out.println("3. Enroll student in course");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            Optional<Action> actionForChoice = Action.findActionForChoice(choice);
            if (actionForChoice.isPresent()) {
                actionForChoice.get().invoke();
            } else {
                System.out.println("Invalid choice");
            }
        }
        System.out.println("Bye!");
    }

    private static enum Action {
        CAPTURE_STUDENT(1){
            @Override
            public void invoke() {
                System.out.println("You chose capture student");
            }
        },
        CPATURE_COURSE(2){
            @Override
            public void invoke() {
                System.out.println("You chose capture course");
            }
        },
        ENROLL_STUDENT(3){
            @Override
            public void invoke() {
                System.out.println("You chose enroll student");
            }
        };

        private final int choiceNumber;

        Action(int choiceNumber) {
            this.choiceNumber = choiceNumber;
        }

        public static Optional<Action> findActionForChoice(int choiceNumber) {
            return Arrays.stream(Action.values())
                    .filter(a -> a.getChoiceNumber() == choiceNumber)
                    .findFirst();
        }

        public abstract void invoke();

        public int getChoiceNumber() {
            return choiceNumber;
        }
    }
}

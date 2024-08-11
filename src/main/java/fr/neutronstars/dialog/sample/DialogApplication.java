package fr.neutronstars.dialog.sample;

import java.util.List;
import java.util.Scanner;

public class DialogApplication {
    public static void main(String... args) {
        final Scanner scanner = new Scanner(System.in);
        final DialogManager dialogManager = new DialogLoader().load("/dialog.json");

        Dialog dialog = dialogManager.get(0);

        if (dialog == null) {
            System.err.println("Dialog not found with id: 0");
            return;
        }

        while (true) {
            System.out.println(dialog.getMessage());

            final List<Suggestion> suggestions = dialog.getSuggestions();

            if (suggestions.isEmpty()) {
                break;
            }

            for (int i = 0; i < suggestions.size(); i++) {
                System.out.printf("[%d] : %s%n", i + 1, suggestions.get(i).getText());
            }

            boolean success = false;

            do {
                int answer = scanner.nextInt();
                if (answer > 0 && answer <= suggestions.size()) {
                    dialog = suggestions.get(answer - 1).getToDialog();
                    success = true;
                } else {
                    System.out.println("Suggestion not found! Please try again: ");
                }
            } while (!success);
        }
    }
}

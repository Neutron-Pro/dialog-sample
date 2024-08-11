package fr.neutronstars.dialog.sample;

import java.util.ArrayList;
import java.util.List;

public class Dialog {

    private final List<Suggestion> suggestions = new ArrayList<>();
    private final int identifier;
    private final String message;

    public Dialog(int identifier, String message) {
        this.identifier = identifier;
        this.message = message;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public String getMessage() {
        return this.message;
    }

    public List<Suggestion> getSuggestions() {
        return new ArrayList<>(this.suggestions);
    }

    public Suggestion getSuggestion(int index) {
        return this.suggestions.get(index);
    }

    public void add(Suggestion suggestion) {
        this.suggestions.add(suggestion);
    }
}

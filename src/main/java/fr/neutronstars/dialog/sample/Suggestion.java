package fr.neutronstars.dialog.sample;

public class Suggestion {
    private final String text;
    private final Dialog dialog;

    public Suggestion(String text, Dialog dialog) {
        this.text = text;
        this.dialog = dialog;
    }

    public String getText() {
        return this.text;
    }

    public Dialog getToDialog() {
        return this.dialog;
    }
}

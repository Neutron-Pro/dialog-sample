package fr.neutronstars.dialog.sample;

import java.util.HashMap;
import java.util.Map;

public class DialogManager {
    private final Map<Integer, Dialog> dialogMap = new HashMap<>();

    public Dialog get(int identifier) {
        return this.dialogMap.get(identifier);
    }

    public void register(Dialog dialog) {
        this.dialogMap.put(dialog.getIdentifier(), dialog);
    }
}

package fr.neutronstars.dialog.sample;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DialogLoader {
    public DialogManager load(String data) {
        final DialogManager dialogManager = new DialogManager();

        try (final InputStream inputStream = DialogLoader.class.getResourceAsStream(data)){

            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + data);
            }

            final JSONArray array = new JSONArray(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8));

            for (int i = 0; i < array.length(); i++) {
                final JSONObject object = array.getJSONObject(i);
                dialogManager.register(new Dialog(object.getInt("id"), object.getString("message")));
            }

            for (int x = 0; x < array.length(); x++) {
                final JSONObject object = array.getJSONObject(x);
                if (!object.has("suggestions")) {
                    continue;
                }
                final JSONArray suggestions = object.getJSONArray("suggestions");
                final Dialog dialog = dialogManager.get(object.getInt("id"));

                for (int y = 0; y < suggestions.length(); y++) {
                    final JSONObject suggestion = suggestions.getJSONObject(y);
                    dialog.add(new Suggestion(
                        suggestion.getString("text"),
                        dialogManager.get(suggestion.getInt("dialog"))
                    ));
                }
            }
        } catch (IOException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        return dialogManager;
    }
}

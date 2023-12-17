package starter.utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static JSONObject getAdmin() {
        try {
            String filePath = "src/test/resources/sample/admin.json";

            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            return new JSONObject(content);

        } catch (IOException e) {
            throw new RuntimeException("Error reading admin.json", e);

        }
    }

    public static JSONObject getUser() {
        try {
            String filePath = "src/test/resources/sample/user.json";

            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            return new JSONObject(content);

        } catch (IOException e) {
            throw new RuntimeException("Error reading admin.json", e);

        }

    }
}

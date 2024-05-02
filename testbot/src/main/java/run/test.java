package run;

import com.google.gson.Gson;
import storage.model.database.Database;
import util.JsonLoader;

public class test {
    public static void main(String[] args) {
        String filePath = "path/to/your/json/file.json";
        JsonLoader.loadJsonFile(filePath);
    }
}

package util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import crawl.BaseBot;
import crawl.StoryBot;

import java.io.FileReader;

public class JsonLoader {
    public static void loadJsonFile(String filePath) {
        try {
            // Phân tích tệp JSON
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(filePath)).getAsJsonObject();

            // Trích xuất dữ liệu từ JSON và sử dụng khi cần
            String baseBotUrl = jsonObject.get("baseBotUrl").getAsString();
            String storyBotUrl = jsonObject.get("storyBotUrl").getAsString();

            // instances của BaseBot và StoryBot với các URL trích xuất
            BaseBot baseBot = new BaseBot(baseBotUrl);
            StoryBot storyBot = new StoryBot(storyBotUrl);

            // Thực hiện các hành động bằng cách sử dụng các instance BaseBot và StoryBot
            // Ví dụ:
            baseBot.crawl(baseBotUrl);
            storyBot.crawl(storyBotUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/json/file.json";
        loadJsonFile(filePath);
    }
}



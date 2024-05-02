package run;

import crawl.GeneralBot;

public class main {
    public static void main(String[] args) {
        String baseUrl = "https://cotich.net/"; //

        // Create instances of each bot
        GeneralBot general = new GeneralBot(baseUrl);
        general.run();
    }
}

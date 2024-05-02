package storage.model.database;

import com.google.gson.annotations.SerializedName;

public class Table {
    @SerializedName("news")
    private String news;

    // Constructors, Getters, and Setters

    public Table(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}

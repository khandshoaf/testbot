package storage.model.database;

import com.google.gson.annotations.SerializedName;

public class Manga {
    @SerializedName("maxThread")
    private int maxThread;

    @SerializedName("restTime")
    private int restTime;

    // Constructors, Getters, and Setters


    public Manga(int maxThread, int restTime) {
        this.maxThread = maxThread;
        this.restTime = restTime;
    }

    public int getMaxThread() {
        return maxThread;
    }

    public void setMaxThread(int maxThread) {
        this.maxThread = maxThread;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }
}

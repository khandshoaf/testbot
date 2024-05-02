package storage.model.database;

import com.google.gson.annotations.SerializedName;

public class Setting {
    @SerializedName("timeCheck")
    private int timeCheck;

    // Constructors, Getters, and Setters

    public Setting(int timeCheck) {
        this.timeCheck = timeCheck;
    }

    public int getTimeCheck() {
        return timeCheck;
    }

    public void setTimeCheck(int timeCheck) {
        this.timeCheck = timeCheck;
    }
}

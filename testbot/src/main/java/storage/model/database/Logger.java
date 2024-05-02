package storage.model.database;

import com.google.gson.annotations.SerializedName;

public class Logger {
    @SerializedName("isLog")
    private boolean isLog;

    @SerializedName("isFile")
    private boolean isFile;

    @SerializedName("level")
    private String level;

    @SerializedName("directory")
    private String directory;

    // Constructors, Getters, and Setters

    public Logger(boolean isLog, boolean isFile, String level, String directory) {
        this.isLog = isLog;
        this.isFile = isFile;
        this.level = level;
        this.directory = directory;
    }

    public Logger() {
    }

    public boolean isLog() {
        return isLog;
    }

    public void setLog(boolean log) {
        isLog = log;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}

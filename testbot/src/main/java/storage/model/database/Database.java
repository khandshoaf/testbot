package storage.model.database;
import com.google.gson.annotations.SerializedName;

public class Database {
    @SerializedName("domain")
    private String domain;

    @SerializedName("port")
    private int port;

    @SerializedName("schema")
    private String schema;

    @SerializedName("user")
    private String user;

    @SerializedName("pass")
    private String pass;

    @SerializedName("table")
    private Table table;

    @SerializedName("manga")
    private Manga manga;

    @SerializedName("setting")
    private Setting setting;

    @SerializedName("logger")
    private Logger logger;
}


package crawl;

import crawl.Entity.Truyen;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.*;

public class StoryBot extends BaseBot{
    private static final String URL = "jdbc:mysql://localhost:3306/dbStories";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    public StoryBot(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public void crawl(String baseUrl){
        super.crawl(baseUrl);
        for (String url : visitedUrls) {
            processPageData(url);
        }
    }

    protected void processPageData(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            String type = ".news-item"; // Thể loại truyện
            Elements data = doc.select(type);
            String tag = ".title > h1 > a";
            Elements tags = doc.select(tag);
            if (!tags.html().isEmpty()) {
                System.out.println("Tags: " + tags.html());
            }
            for (Element item : data) {
                String title = item.select("h4 > a").html();
                String linkUrl = item.select("h4 > a").attr("href");
                String img = item.select(".img > a > img").attr("src");
                String info = item.select(".info-post").text();
                String sapo = item.select(".sapo").text();

                Truyen truyen = new Truyen(title, img, linkUrl, info, sapo);
                System.out.println(truyen);
                String sql = "INSERT INTO truyen (header, img, url, info, sapo) VALUES (?, ?, ?, ?, ?)";

                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                     PreparedStatement statement = conn.prepareStatement(sql)) {
                    String selectQuery = "SELECT COUNT(*) AS count FROM truyen WHERE header = ? AND url = ?";
                    PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
                    selectStatement.setString(1, truyen.getHeader());
                    selectStatement.setString(2, truyen.getUrl());
                    ResultSet resultSet = selectStatement.executeQuery();
                    if (resultSet.next()) {
                        int count = resultSet.getInt("count");
                        if (count == 0) {
                            // Chèn dữ liệu nếu không có bản ghi trùng lặp
                            statement.setString(1, truyen.getHeader());
                            statement.setString(2, truyen.getImg());
                            statement.setString(3, truyen.getUrl());
                            statement.setString(4, truyen.getInfo());
                            statement.setString(5, truyen.getContent());
                            statement.executeUpdate();
                        } else {
                            System.out.println("Bản ghi trùng lặp. Bỏ qua chèn dữ liệu.");
                        }
                    }
                    resultSet.close();
                    selectStatement.close();
                    statement.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

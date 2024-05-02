//package crawl;
//
//import javax.swing.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class NewStoryBot extends BaseBot{
//    private JTextArea textArea;
//
//    public NewStoryBot(String baseUrl) {
//        super(baseUrl);
//        initializeUI();
//    }
//
//    private void initializeUI() {
//        setTitle("New Story Reader");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        textArea = new JTextArea();
//        textArea.setEditable(false);
//
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//        getContentPane().add(scrollPane, BorderLayout.CENTER);
//
//        JButton displayButton = new JButton("Display New Story");
//        displayButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                displayNewStory();
//            }
//        });
//
//        getContentPane().add(displayButton, BorderLayout.SOUTH);
//    }
//
//    private void displayNewStory() {
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbStories", "root", "123");
//            Statement statement = conn.createStatement();
//
//            String query = "SELECT * FROM truyen WHERE title = 'New Story'";
//            ResultSet resultSet = statement.executeQuery(query);
//
//            if (resultSet.next()) {
//                String title = resultSet.getString("title");
//                String info = resultSet.getString("info");
//                String content = resultSet.getString("content");
//
//                textArea.setText("Title: " + title + "\n\n");
//                textArea.append("Info: " + info + "\n\n");
//                textArea.append("Content: " + content);
//            }
//
//            resultSet.close();
//            statement.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                NewStoryBot newStoryBot = new NewStoryBot("https://your-base-url.com");
//                newStoryBot.setVisible(true);
//            }
//        });
//    }
//}

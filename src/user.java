import java.sql.Connection;
import java.sql.PreparedStatement;

public class user {
    private String enteredUsername;
    private String enteredPassword,name;
    private int userId;
    public int getID(){
        return userId;
    }
    public String getname(){
        return name;
    }
    public int login(String enteredUsername, String enteredPassword) {
        this.enteredUsername = enteredUsername;
        this.enteredPassword = enteredPassword;
        System.out.println(enteredUsername+" "+enteredPassword);
        DataBaseConnection d = new DataBaseConnection();
        try (Connection con = d.connectDatabase()) {
            if (con != null) {
                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, enteredUsername);
                    preparedStatement.setString(2, enteredPassword);

                    var resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        userId = resultSet.getInt("user_id");
                        name=resultSet.getString("name");

                        return 1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;

public class registerUser {
    private String name,email, password,username,usertype;

    public int register(String name, String email, String password, String username) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;

        DataBaseConnection d = new DataBaseConnection();
        try (Connection con = d.connectDatabase()) {
            if (con != null) {
                String query = "INSERT INTO users (name, email, password, username) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, username);
//                    preparedStatement.setString(5, usertype);

                    int result = preparedStatement.executeUpdate();
                    return result > 0 ? 1 : 0;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}

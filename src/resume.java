import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class resume {
    private int id;
    private String email,phone_no,city,country,Skills,He,hec,yohe,pro,cover_letter;
    resume(){}
    resume(int id){
        DataBaseConnection d = new DataBaseConnection();
        try (Connection con = d.connectDatabase()) {
            if (con != null) {

                String query = "Select * from resume where id=?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setInt(1, id);

                    ResultSet result = preparedStatement.executeQuery();
                    if(result.next()){
                        email=result.getString("email");
                        phone_no=result.getString("phone_no");
                        city=result.getString("city");
                        country=result.getString(country);
                        Skills=result.getString("skills");
                        He=result.getString("highest_degree");
                        hec=result.getString("college");
                        yohe=result.getString("year");
                        pro=result.getString("proficiency_level");
                        cover_letter=result.getString("cover_letter");
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone_no() {
        return phone_no;
    }
    public String getHe() {
        return He;
    }

    public String getHec() {
        return hec;
    }

    public String getYohe() {
        return yohe;
    }

    public String getCover_letter() {
        return cover_letter;
    }
    public String getPro(){
        return pro;
    }

    public int getId() {
        return id;
    }

    public String getSkills() {
        return Skills;
    }

    public String getemail(){
        return email;
    }
    public int create_resume(String Name,String email2,String phone_no,String city,String country,String skills,String HE,String HEC,String YOHE,String pro,String cover_letter){
        // System.out.println("in resume-creation");
        user r=new user();
        System.out.println(r.getID());
        DataBaseConnection d = new DataBaseConnection();
        try (Connection con = d.connectDatabase()) {
            if (con != null) {

                String query = "INSERT INTO resume (user_id, email, phone_no, city, country,skills,highest_degree,college,year,proficiency_level,cover_letter,name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setInt(1, r.getID());
                    preparedStatement.setString(2, email2);
                    preparedStatement.setString(3, phone_no);
                    preparedStatement.setString(4, city);
                    preparedStatement.setString(5, country);
                    preparedStatement.setString(6, skills);
                    preparedStatement.setString(7, HE);
                    preparedStatement.setString(8, HEC);
                    preparedStatement.setString(9, YOHE);
                    preparedStatement.setString(10, pro);
                    preparedStatement.setString(11, cover_letter);
                    preparedStatement.setString(12, Name);

                    int result = preparedStatement.executeUpdate();
                    return result > 0 ? 1 : 0;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;

    }
}

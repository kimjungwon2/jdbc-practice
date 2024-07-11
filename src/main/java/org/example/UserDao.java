package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {


    public void create(User user) throws SQLException{
        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = getConnection();
            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
        } finally{
            if(pstmt != null){
                pstmt.close();
            }

            if(con!=null){
                con.close();
            }
        }
    }

    private Connection getConnection(){
        String url ="jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
        String id = "sa";
        String pw = "";

        try{
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch(Exception ex){
            return null;
        }
    }

    public User findByUserId(String wizard) {
        return null;
    }
}

package wap.news.dao;

import wap.news.model.Category;
import wap.news.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private JDBCConnection jdbcConnection;
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public UserDao() {
        jdbcConnection = new JDBCConnection();
    }

    public Map<Integer, User> getUserByUserNameAndPass(String userName,String password) {
        try {
            Map<Integer, User> mapWithId = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM user WHERE userName = ? and password=? ";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setString(1, (userName));
            pstmt.setString(2, (password));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(2), rs.getString(3));
                mapWithId.put(rs.getInt(1), user);
            }
            return mapWithId;

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        return null;
    }
}

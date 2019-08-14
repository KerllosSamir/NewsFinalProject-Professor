package wap.news.dao;

import wap.news.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CategoryDao {

    private JDBCConnection jdbcConnection;
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public CategoryDao() {
        jdbcConnection = new JDBCConnection();
    }

    public void addCategory(String name,boolean isActive) {
        try {
            Category category = new Category(name,isActive);
            conn = jdbcConnection.getConnection();
            String sql = "INSERT INTO category(name,isActive) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setBoolean(2, category.getIsActive());
            //System.out.println("sql =" + sql);
            pstmt.executeUpdate();
            //System.out.println("Inserted records into the table...");

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

    }

    public Map<Integer, Category> getAllCategories() {
        try {
            Map<Integer, Category> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM category ";
            pstmt = conn.prepareStatement(query); // create a statement
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getString(2), rs.getBoolean(3));
                map.put(rs.getInt(1), category);
            }
            System.out.println(map);
            return map;
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
    public Map<Integer, Category> getActiveCategories() {
        try {
            Map<Integer, Category> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM category where isactive=1";
            pstmt = conn.prepareStatement(query); // create a statement
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt(1),rs.getString(2), rs.getBoolean(3));
                map.put(rs.getInt(1), category);
            }
            System.out.println(map);
            return map;
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

    public Map<Integer, Category> getCategoryById(String id) {
        try {
            Map<Integer, Category> mapWithId = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM category WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Category contact = new Category(rs.getString(2), rs.getBoolean(3));
                mapWithId.put(Integer.parseInt(id), contact);
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

    // delete records based on id
    public void deleteCategory(String id) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "DELETE FROM category WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setInt(1, Integer.parseInt(id));
            // execute delete SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is deleted!");
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

    }

    // delete records based on id
    public void updateCategory(String id, String name, Boolean isActive) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "UPDATE Category SET name = ?, isActive = ? WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setString(1, name);
            pstmt.setBoolean(2, isActive);
            pstmt.setInt(3, Integer.parseInt(id));
            // execute update SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is Updated!");
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

    }

}

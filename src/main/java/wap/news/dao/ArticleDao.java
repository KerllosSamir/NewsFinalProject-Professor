package wap.news.dao;

import wap.news.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ArticleDao {
    private JDBCConnection jdbcConnection;
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public ArticleDao() {
        jdbcConnection = new JDBCConnection();
    }

    public void addArticle(String title, String body, int categoryId, String mainImage, Boolean isNaveBar, Boolean isRotating, Boolean isActive) {
        try {
            Article Article = new Article(title, body, categoryId, mainImage, isNaveBar, isRotating, isActive);
            conn = jdbcConnection.getConnection();
            String sql = "INSERT INTO Article(title, body, categoryId, mainImage, isNaveBar, isRotating, isActive) VALUES (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Article.getTitle());
            pstmt.setString(2, Article.getBody());
            pstmt.setInt(3, Article.getCategoryId());
            pstmt.setString(4, Article.getMainImage());
            pstmt.setBoolean(5, Article.getIsNaveBar());
            pstmt.setBoolean(6, Article.getIsRotating());
            pstmt.setBoolean(7, Article.getIsActive());
            //System.out.println("sql =" + sql);
            pstmt.executeUpdate();
            //System.out.println("Inserted records into the table...");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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

    public Map<Integer, Article> getAllArticles() {
        try {
            Map<Integer, Article> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM article ";
            pstmt = conn.prepareStatement(query); // create a statement
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Article Article = new Article(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8));
                map.put(rs.getInt(1), Article);
            }
            System.out.println(map);
            return map;
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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

    public Map<Integer, Article> getActiveArticles() {
        try {
            Map<Integer, Article> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM article where isactive=1";
            pstmt = conn.prepareStatement(query); // create a statement
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Article Article = new Article(rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8));
                map.put(rs.getInt(1), Article);
            }
            System.out.println(map);
            return map;
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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

    public Map<Integer, Article> getArticleById(String id) {
        try {
            Map<Integer, Article> mapWithId = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM article WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Article Article = new Article(rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8));
                mapWithId.put(Integer.parseInt(id), Article);
            }
            return mapWithId;

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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
    public void deleteArticle(String id) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "DELETE FROM Article WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setInt(1, Integer.parseInt(id));
            // execute delete SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is deleted!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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
    public void updateArticle(String id, String title, String body, int categoryId, String mainImage, Boolean isNaveBar, Boolean isRotating, Boolean isActive) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "UPDATE Article SET title = ?, body = ? , categoryId = ? , mainImage = ? , isNaveBar = ? , isRotating = ? ,  isActive = ? WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement

            pstmt.setString(1, title);
            pstmt.setString(2, body);
            pstmt.setInt(3, categoryId);
            pstmt.setString(4, mainImage);
            pstmt.setBoolean(5, isNaveBar);
            pstmt.setBoolean(6, isRotating);
            pstmt.setBoolean(7, isActive);
            pstmt.setInt(8, Integer.parseInt(id));
            // execute update SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is Updated!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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

    public Map<Integer, Article> getNavigationArticles() {
        try {
            Map<Integer, Article> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM article where isNaveBar=1 and Isactive=1";
            pstmt = conn.prepareStatement(query); // create a statement
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Article Article = new Article(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8));
                map.put(rs.getInt(1), Article);
            }
            System.out.println(map);
            return map;
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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

    public Map<Integer, Article> getArticlesByCategoryId(String categoryId) {
        try {
            Map<Integer, Article> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT article.*,category.name FROM article inner join category on article.categoryId=category.id  where categoryId = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setString(1, categoryId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Article Article = new Article(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), rs.getBoolean(8),rs.getString(9));
                map.put(rs.getInt(1), Article);
            }
            System.out.println(map);
            return map;
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.fortitle
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
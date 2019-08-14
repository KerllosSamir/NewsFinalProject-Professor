package wap.news.dao;

import wap.news.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ContactUsDao {

    private JDBCConnection jdbcConnection= null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public ContactUsDao() {
        jdbcConnection = new JDBCConnection();
    }

    public void addContact(String name, String email, String message) {
        try {
            Contact contact = new Contact(name,email, message);
            conn = jdbcConnection.getConnection();
            String sql = "INSERT INTO contactus(name, email, message) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3,contact.getMessage());

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

    //get all contacts
    public Map<Integer, Contact> getAllContacts() {
        try {
            Map<Integer, Contact> map = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM contactus ";
            pstmt = conn.prepareStatement(query); // create a statement
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact(rs.getString(2), rs.getString(3), rs.getString(4));
                map.put(rs.getInt(1), contact);
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

    //get contact by id
    public Map<Integer, Contact> getContactById(String id) {
        try {
            Map<Integer, Contact> mapWithId = new HashMap<>();
            conn = jdbcConnection.getConnection();
            String query = "SELECT * FROM contactus WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact(rs.getString(2), rs.getString(3), rs.getString(4));
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
    public void deleteCContact(String id) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "DELETE FROM contactus WHERE id = ?";
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
    public void updateContact(String id, String name, String email, String message) {
        try {
            conn = jdbcConnection.getConnection();
            String query = "UPDATE contactus SET name = ?, email = ?, message = ? WHERE id = ?";
            pstmt = conn.prepareStatement(query); // create a statement
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, message);
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

package com.colby.repositories.JDBC;

import com.colby.models.User;
import com.colby.repositories.UserRepo;
import com.colby.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJDBC implements UserRepo {
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();



    public User add(User user) {

        try (Connection conn = cu.getConnection()) {
            System.out.println("Adding user to db");
            String sql = "insert into users values (default,?,?,?,?,?,? )";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setBoolean(5, user.getIs_admin());
            ps.setString(6, user.getTitle());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setEmp_id(user.getEmp_id());
            }
            if (user != null) {
                System.out.println("welcome new user");
                return user;
            } else {
                System.out.println("error when adding to db");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } // end add user



    public User getById(Integer emp_id){
        try( Connection conn = cu.getConnection()){
            String sql = "select * from users where emp_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,emp_id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User u = new User(
                        rs.getInt("emp_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin"),
                        rs.getString("title"));
//                        User.PermEmp.valueOf(rs.getString("perm_level")));
                return u;

            }


        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }




    public User getByUsername(String username) { //whyyyy the s
        try (Connection conn = cu.getConnection()) {

            String sql = "select * from users where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getInt("emp_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin"),
                        rs.getString("title"));
//                        User.PermEmp.valueOf(rs.getString("perm_level")));
                System.out.println(u);
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<User> getAll() {
//        return null;
//    }
//    public User(Integer emp_id, String first_name, String last_name, String username, String password, Boolean is_admin, User.PermEmp perm_level) {
//        this.emp_id = emp_id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.username = username;
//        this.password = password;
//        this.is_admin = is_admin;
//        this.perm_level = perm_level;
//    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection conn = cu.getConnection()) {

            String sql = "select * from users";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User u = new User();
                u.setEmp_id(rs.getInt("emp_id"));
                u.setFirst_name(rs.getString("first_name"));
                u.setLast_name(rs.getString("last_name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setIs_admin(rs.getBoolean("is_admin"));
                u.setTitle(rs.getString("title"));
//                u.setPerm_level(rs.getObject("perm_level", User.PermEmp.class));

                users.add(u);
            }
            return users;


        }
        catch(SQLException e) {

            e.printStackTrace();
        }
        return null;
    }


    public void update(User user){

        try(Connection conn = cu.getConnection()){
            String sql = "update users set password = ? where emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setInt(2, user.getEmp_id());

            ps.executeQuery();



        }catch(SQLException e){
            e.printStackTrace();
        }



    }

    public void delete(Integer id){

    }

}

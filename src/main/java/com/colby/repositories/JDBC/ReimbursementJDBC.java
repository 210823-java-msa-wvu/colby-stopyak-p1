package com.colby.repositories.JDBC;

import com.colby.models.Reimbursement;
import com.colby.models.User;
import com.colby.repositories.ReimbursementRepo;
import com.colby.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementJDBC implements ReimbursementRepo {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    //    @Override
    public Reimbursement add(Reimbursement r) {

        try(Connection conn = cu.getConnection()){
            System.out.println("Adding reimbursement to db");

            String sql = "insert into reimbursement (rm_id, description, location, amount, work_related, status, is_approved, created_at, updated_at, emp_id) values(default,?,?,?,?,?,?,?,?,?) returning *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,r.getDescription());
            ps.setString(2,r.getLocation());
            ps.setFloat(3, r.getAmount());
            ps.setString(4, r.getWork_related());
            ps.setString( 5, r.getStatus());
            ps.setBoolean(6, r.getIs_approved());
            ps.setTimestamp(7, r.getCreated_at());
            ps.setTimestamp(8,r.getUpdated_at());
            ps.setInt(9, r.getUser().getEmp_id());



            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                r.setRm_id(rs.getInt("rm_id"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Reimbursement getById(Integer id) {
        return null;
    }



    public List <Reimbursement> getByEmpId(Integer id){
        List<Reimbursement> reimbursement = new ArrayList<>();
        try(Connection conn = cu.getConnection()){
            String sql = "select * from reimbursement where emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reimbursement rm = new Reimbursement();

                rm.setRm_id(rs.getInt("rm_id"));
                rm.setDescription(rs.getString("description"));
                rm.setLocation(rs.getString("location"));
                rm.setAmount(rs.getFloat("amount"));
                rm.setWork_related(rs.getString("work_related"));
                rm.setStatus(rs.getString("status"));
                rm.setIs_approved(rs.getBoolean("is_approved"));
                rm.setCreated_at(rs.getTimestamp("created_at"));
                rm.setUpdated_at(rs.getTimestamp("updated_at"));
                User u = new User();
                u.setEmp_id(rs.getInt("emp_id"));


                reimbursement.add(rm);


            }
            return reimbursement;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAll() {
        List<Reimbursement> reimbursement = new ArrayList<>();

        try(Connection conn = cu.getConnection()) {
            String sql = "select * from Reimbursement";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reimbursement rm = new Reimbursement();
                rm.setRm_id(rs.getInt("rm_id"));
                rm.setDescription(rs.getString("description"));
                rm.setLocation(rs.getString("location"));
                rm.setAmount(rs.getFloat("amount"));
                rm.setWork_related(rs.getString("work_related"));
                rm.setStatus(rs.getString("status"));
                rm.setIs_approved(rs.getBoolean("is_approved"));
                rm.setCreated_at(rs.getTimestamp("created_at"));
                rm.setUpdated_at(rs.getTimestamp("updated_at"));


                User u = new User();
                u.setEmp_id(rs.getInt("emp_id"));
                System.out.println(reimbursement);
//                rm.setUser(rs.getInt("emp_id"));
//                rm.setUser(rm.getUser(rs.getInt("emp_id"))));

//                        rs.getString("emp_id")


                reimbursement.add(rm);
            }
            return reimbursement;

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Reimbursement r) {

        try(Connection conn = cu.getConnection()){
            String sql = "update reimbursement set amount = ?, status = ?, is_approved = ? where rm_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setFloat(1, r.getAmount());
            ps.setString(2, r.getStatus());
            ps.setBoolean(3, r.getIs_approved());
            ps.setInt(4, r.getRm_id());

            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public Reimbursement updateByEmpId(Reimbursement r) {

        try(Connection conn = cu.getConnection()){
            String sql = "update reimbursement set rm_id = ?, amount=?, status = ?, is_approved = ?, where emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,r.getRm_id());
            ps.setFloat(2, r.getAmount());
            ps.setString(3, r.getStatus());
            ps.setBoolean(4, r.getIs_approved());
            ps.setInt(5, r.getUser().getEmp_id());

            ps.execute();
             return r;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }





    //    @Override
    public void delete(Integer id) {

        try(Connection conn = cu.getConnection()){
            String sql = "delete from reimbursement where rm_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }


}

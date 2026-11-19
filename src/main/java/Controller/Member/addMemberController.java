package Controller.Member;

import Model.Entity.MemberEntity;
import Model.MemberDTO;
import db.DBConnection;
import db.HibernateUtil;
import scene.SceneManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addMemberController {
//    Connection connection = DBConnection.getInstance().getConnection();

    public void databaseSaveMemberDetails (MemberDTO member){

        try {
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setMemberId(member.getMemberId());
            memberEntity.setFullName(member.getFullName());
            memberEntity.setEmail(member.getEmail());
            memberEntity.setPhoneNumber(member.getPhoneNumber());
            memberEntity.setAddress(member.getAddress());

            HibernateUtil.executeInTransaction(session -> session.persist(memberEntity));

            SceneManager.switchPage("/view/successNotification/AddMemberSuccessNotification.fxml");
        } catch (Exception e) {
            SceneManager.switchPage("/view/FailedNotification/AddMemberFailedNotification.fxml");
            throw new RuntimeException(e);
        }

//        String addMemberSql = "INSERT INTO members (member_id, full_name, email, phone_number, address) VALUES (?,?,?,?,?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(addMemberSql);
//            preparedStatement.setString(1,member.getMemberId());
//            preparedStatement.setString(2,member.getFullName());
//            preparedStatement.setString(3,member.getEmail());
//            preparedStatement.setString(4,member.getPhoneNumber());
//            preparedStatement.setString(5,member.getAddress());
//
//            int addMemberQuaryResult = preparedStatement.executeUpdate();
//            if (addMemberQuaryResult > 0){
//                SceneManager.switchPage("/view/successNotification/AddMemberSuccessNotification.fxml");
//            }else {
//                SceneManager.switchPage("/view/FailedNotification/AddMemberFailedNotification.fxml");
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}

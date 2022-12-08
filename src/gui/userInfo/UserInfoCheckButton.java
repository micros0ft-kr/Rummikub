package gui.userInfo;

import javax.swing.JButton;

import gui.select_user.SelectUserGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoCheckButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private UserInfoGUI userInfo_gui;

    // 생성 메소드
    public UserInfoCheckButton(String btn_text, UserInfoGUI g){
        super(btn_text);
        userInfo_gui = g;


        addActionListener(this);
    }


    // 액션 리스너
    public void actionPerformed(ActionEvent e) {

        userInfo_gui.setVisible(false);

        /*
         * To DO 1. userNum = 0 될 때까지 UserInfoGUI 객체 생성
         * 만약, userNum = 0이면, UserSequsenceResultGUI로 전환 (userNum, UserInfoModel 배열 객체 가지고 전환)
         */


    }

}

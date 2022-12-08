package gui.select_user;

import javax.swing.JButton;

import gui.userInfo.UserInfoGUI;
import gui.userInfo.UserInfoModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUserButton extends JButton implements ActionListener {

    // 필드변수 정의
    private int user_num; // 루미큐브 유저 수

    private SelectUserGUI select_gui;
    private UserInfoModel userInfo_model; // 루미큐브 유저 정보 객체

    // 생성 메소드
    public SelectUserButton(String btn_text, int userNum, SelectUserGUI gui){
        super(btn_text);

        user_num = userNum;
        select_gui = gui;

        addActionListener(this);
    }

    
    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
    

        select_gui.setVisible(false);

        new UserInfoGUI();
        /*
         *  UserInfoGUI로 전환
         *      UserInfoGUI [userNum] 생성
         *      userInfo_model = new UserInfoModel[user_num];
         *      new UserInfoGUI(user_num, userInfoModels)
         *
        */

    }

}

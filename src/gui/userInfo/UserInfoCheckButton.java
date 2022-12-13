package gui.userInfo;

import javax.swing.JButton;

import gui.select_user.SelectUserGUI;
import gui.user_sequence.UserSequenceResultGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoCheckButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private UserInfoGUI userInfo_gui; // 유저 정보 입력 GUI 객체

    private int user_num; // 유저 전체 수
    private int user_idx; // 현재 버튼의 유저 인덱스
    private UserInfoModel[] userInfo; // 유저 정보 모델 클래스 객체

    // 생성 메소드
    public UserInfoCheckButton(String btn_text, UserInfoGUI g, int userNum , int userIdx, UserInfoModel[] userInfo_model){
        super(btn_text);
        userInfo_gui = g;

        user_num = userNum;
        user_idx = userIdx;
        userInfo = userInfo_model;
        

        addActionListener(this);
    }


    // 액션 리스너
    public void actionPerformed(ActionEvent e) {

        user_idx++; // 유저 인덱스 증가
        if(user_idx == user_num + 1){
            // 마지막 남은 UserInfoModel 객체 생성해주고, userInfoGUI 객체 가리고,
            // UserSequenceResultGUI로 전환 (UserInfo)
            userInfo[user_idx - 2] = new UserInfoModel(userInfo_gui.userName_textFiled.getText(), user_idx - 1);
            userInfo_gui.setVisible(false);

            // UserInfoModel 객체 체크 - 디버깅
            // for(int i = 0; i< user_num; i ++){
            //     System.out.println(userInfo[i].name);
            // }
            new UserSequenceResultGUI(user_num, userInfo);

        } else{
            userInfo[user_idx - 2] = new UserInfoModel(userInfo_gui.userName_textFiled.getText(), user_idx - 1);
            userInfo_gui.gui_update();
            // UserInfoModel 객체 생성해주고,
            // UserInfoGUI로 전환 & 업데이트 - gui_update() 메소드 호출
        }


        /*
         * To DO 1. userNum = 0 될 때까지 UserInfoGUI 객체 생성
         * 만약, userNum = 0이면, UserSequsenceResultGUI로 전환 (userNum, UserInfoModel 배열 객체 가지고 전환)
         */


    }

}

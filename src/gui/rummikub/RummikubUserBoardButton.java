package gui.rummikub;

import java.awt.*;
import javax.swing.JButton;

import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;
import gui.user_sequence.UserSequenceResultGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RummikubUserBoardButton extends JButton implements ActionListener {
    

    // 필드변수 정의


    // 생성 메소드
    public RummikubUserBoardButton(String btn_num){
        super(btn_num);

        addActionListener(this);
    }

    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
    

        // 보드 버튼 클릭 시 게임 진행
        


    }
}

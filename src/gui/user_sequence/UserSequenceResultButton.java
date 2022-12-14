package gui.user_sequence;

import javax.swing.JButton;

import gui.game_rule.GameRuleGUI;
import gui.rummikub.RummikubGUI;
import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSequenceResultButton extends JButton implements ActionListener {


    // 필드변수 정의
    private int user_num; // 유저 전체 수
    private UserInfoModel[] user_info; // 유저 정보 모델 클래스 객체
    private UserSequenceResultGUI sequence_gui;

    // 생성 메소드
    public UserSequenceResultButton(String btn_text, UserSequenceResultGUI gui ,int userNum, UserInfoModel[] userInfo){
        super(btn_text);
        
        user_num = userNum;
        user_info = userInfo;
        sequence_gui = gui;

        addActionListener(this);
    }




    // 액션 리스너
    public void actionPerformed(ActionEvent e) {

        /*
         *  GameRuleGUI로 전환
         */
        sequence_gui.setVisible(false);
        new GameRuleGUI(user_num, user_info);



    }
}

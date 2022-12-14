package gui.game_rule;

import javax.swing.JButton;

import field.FieldDeck;
import gui.rummikub.RummikubGUI;
import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;
import gui.user_sequence.UserSequenceResultGUI;
import order.OrderDeck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameRuleCheckButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private int user_num;
    private UserInfoModel[] user_info;
    private GameRuleGUI gameRule_gui;

    // 생성 메소드
    public GameRuleCheckButton(String btn_text, GameRuleGUI gui, int userNum, UserInfoModel[] userInfo){
        super(btn_text);

        user_num = userNum;
        user_info = userInfo;
        gameRule_gui = gui;

        addActionListener(this);
    }



    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
        
        // GameRuleGUI 가리기
        gameRule_gui.setVisible(false);



        // RummikubGUI로 전환
        // TO DO. 객체 생성인자에 FieldDeck & OrderDeck 추가
        FieldDeck field_m = new FieldDeck();
        OrderDeck order_m = new OrderDeck(user_info, user_num); 

        new RummikubGUI(user_num, user_info, order_m, field_m);
        

    }


}

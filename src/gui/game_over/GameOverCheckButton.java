package gui.game_over;

import javax.swing.JButton;

import field.FieldDeck;
import gui.rummikub.RummikubGUI;
import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;
import gui.user_sequence.UserSequenceResultGUI;
import order.OrderDeck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverCheckButton extends JButton implements ActionListener {
    

    // 필드변수 정의



    // 생성 메소드
    public GameOverCheckButton(String btn_text){
        super(btn_text);

        addActionListener(this);
    }



    // 액션 리스너
    public void actionPerformed(ActionEvent e) {


        System.exit(0);

    }


}

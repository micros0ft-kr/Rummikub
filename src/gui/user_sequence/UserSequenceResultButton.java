package gui.user_sequence;

import javax.swing.JButton;

import gui.select_user.SelectUserGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSequenceResultButton extends JButton implements ActionListener {


    // 필드변수 정의


    // 생성 메소드
    public UserSequenceResultButton(String btn_text){
        super(btn_text);
        

        addActionListener(this);
    }




    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
        
    }
}

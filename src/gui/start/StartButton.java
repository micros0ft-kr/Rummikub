package gui.start;

import javax.swing.JButton;

import gui.select_user.SelectUserGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private StartGUI start_gui;
    
    // 생성 메소드
    public StartButton(String btn_text, StartGUI g){
        super(btn_text);

        start_gui = g;

        addActionListener(this);
    }

    // 액션 리스너
    public void actionPerformed(ActionEvent e) {

        start_gui.setVisible(false);
        // SelectUserGUI로 전환
        new SelectUserGUI();


    }

}

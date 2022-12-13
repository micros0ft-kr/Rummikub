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
    private RummikubGUI rummikub_gui;
    private int this_row;
    private int this_col;

    // 생성 메소드
    public RummikubUserBoardButton(String btn_num, RummikubGUI gui, int row, int col){
        super(btn_num);

        rummikub_gui = gui;
        this_row = row;
        this_col = col;

        addActionListener(this);
    }

    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
    

        // 보드 버튼 클릭 시 게임 진행
        if(rummikub_gui.board_btn_event == 1){
            // 클릭된 유저 카드 필드 배치
            System.out.println("두번째 클릭된 버튼의 row : " + this_row + "\t두번째 클릭된 버튼의 col : " + this_col + "  첫번째 클릭된 버튼의 row : " + rummikub_gui.board_row + "\t첫번째 클릭된 버튼의 col : " + rummikub_gui.board_col);            // 관리변수 초기화
            rummikub_gui.board_btn_event = 0;
        }

        System.out.println("지나가라 지나가라");


    }
}

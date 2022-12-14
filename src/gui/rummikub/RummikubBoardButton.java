package gui.rummikub;

import java.awt.*;
import javax.swing.JButton;

import field.FieldDeck;
import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;
import gui.user_sequence.UserSequenceResultGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RummikubBoardButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private RummikubGUI rummikub_gui;

    private int this_row; // 현재 버튼의 row
    private int this_col; // 현재 버튼의 col
    private FieldDeck field_model;

    // 생성 메소드
    public RummikubBoardButton(String btn_num, RummikubGUI gui, int row, int col, FieldDeck field_m){
        super(btn_num);

        rummikub_gui = gui;
        this_row = row;
        this_col = col;
        field_model = field_m;
        
        addActionListener(this);
    }

    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
    

        // 유저 보드 버튼 클릭 시 게임 진행

        /*
         * 버튼 클릭이벤트 관리변수 조정
         * 기본전제 : 보드판 버튼 한번 클릭 시 +1
         * 
         * 2가 되면, 루미큐브 필드 덱 체인지
         * 1이면서, 유저 덱 클릭 시 유저 덱 한장 필드 배치
         */
        rummikub_gui.board_btn_event = rummikub_gui.board_btn_event + 1;


        if(rummikub_gui.board_btn_event == 2){
            // 루미큐브 필드 덱 체인지
            System.out.println("두번째 클릭된 버튼의 row : " + this_row + "\t두번째 클릭된 버튼의 col : " + this_col + "첫번째 클릭된 버튼의 row : " + rummikub_gui.board_row + "\t첫번째 클릭된 버튼의 col : " + rummikub_gui.board_col);
            
            // 관리변수 초기화
            rummikub_gui.board_btn_event = 0;
        }
        else{
            rummikub_gui.board_row = this_row;
            rummikub_gui.board_col = this_col;
        }

        System.out.println("지나가라 지나가라");

    }
}

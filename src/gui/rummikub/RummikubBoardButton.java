package gui.rummikub;

import java.awt.*;
import javax.swing.JButton;

import field.FieldDeck;
import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;
import gui.user_sequence.UserSequenceResultGUI;
import order.CardModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RummikubBoardButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private RummikubGUI rummikub_gui;

    private int this_row; // 현재 버튼의 row
    private int this_col; // 현재 버튼의 col
    private int user_idx;
    private FieldDeck field_model;
    private UserInfoModel[] user_info;
    

    // 생성 메소드
    public RummikubBoardButton(String btn_num, RummikubGUI gui, int row, int col, int userIdx, FieldDeck field_m, UserInfoModel[] userInfo){
        super(btn_num);

        rummikub_gui = gui;
        this_row = row;
        this_col = col;
        field_model = field_m;
        user_info = userInfo;
        user_idx = userIdx;

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
        rummikub_gui.click_cnt++;
        
        if(rummikub_gui.click_cnt == 1){
            // 게임 진행 전 유저 패 & 필드 복사
            user_info[user_idx].rememberDeck();
            field_model.rememberDeck();
            
        }

        if(rummikub_gui.board_btn_event == 2){
            // 루미큐브 필드 덱 체인지
            CardModel change_deck;
            change_deck = field_model.field[this_row][this_col];

            field_model.field[this_row][this_col] = field_model.field[rummikub_gui.board_row][rummikub_gui.board_col];
            field_model.field[rummikub_gui.board_row][rummikub_gui.board_col] = change_deck;
            // System.out.println("두번째 클릭된 버튼의 row : " + this_row + "\t두번째 클릭된 버튼의 col : " + this_col + "첫번째 클릭된 버튼의 row : " + rummikub_gui.board_row + "\t첫번째 클릭된 버튼의 col : " + rummikub_gui.board_col);
            
            // 관리변수 초기화
            rummikub_gui.board_btn_event = 0;
            rummikub_gui.gui_update();

        }
        else{
            rummikub_gui.board_row = this_row;
            rummikub_gui.board_col = this_col;
        }


    }
}

package gui.rummikub;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import field.FieldDeck;
import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;
import gui.user_sequence.UserSequenceResultGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RummikubUserBoardButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private RummikubGUI rummikub_gui;
    public int this_row;
    public int this_col;
    private UserInfoModel[] user_info;
    private FieldDeck field_model;



    // 생성 메소드
    public RummikubUserBoardButton(String btn_num, RummikubGUI gui, int row, int col, UserInfoModel[] userInfo, FieldDeck field_m){
        super(btn_num);

        // userIdx = user_idx;
        rummikub_gui = gui;
        this_row = row;
        this_col = col;
        user_info = userInfo;
        field_model = field_m;

        addActionListener(this);
    }

    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
    

        // 보드 버튼 클릭 시 게임 진행
        if(rummikub_gui.board_btn_event == 1){
            /*
                클릭된 유저 카드 필드 배치
            */
            if (field_model.field[rummikub_gui.board_row][rummikub_gui.board_col] != null){
                JOptionPane.showMessageDialog(null, "필드의 빈칸 타일을 클릭하세요.", "루미큐브 관리자", JOptionPane.WARNING_MESSAGE);
                rummikub_gui.board_btn_event = 0;
            }
            else {
            // 필드 카드 배치
            field_model.field[rummikub_gui.board_row][rummikub_gui.board_col] = user_info[rummikub_gui.user_idx - 1].user_deck[this_row][this_col];

            // 유저 카드 1개 필드 배치 - 지정된 카드 제거
            user_info[rummikub_gui.user_idx - 1].submitCard(this_row, this_col);
            // System.out.println("두번째 클릭된 버튼의 row : " + this_row + "\t두번째 클릭된 버튼의 col : " + this_col + "  첫번째 클릭된 버튼의 row : " + rummikub_gui.board_row + "\t첫번째 클릭된 버튼의 col : " + rummikub_gui.board_col);            
            
            // 관리변수 초기화
            rummikub_gui.gui_update();
            
            System.out.println("============\n 필드 유저 클릭시 현재필드");
            for(int i = 0; i<6; i++){
                for(int j = 0; j<18; j++){
                    if(field_model.field[i][j]==null){
                        System.out.print(field_model.field[i][j]+ " ");
                    }
                    else{
                        System.out.print(field_model.field[i][j].num+ " ");
                    }
                }
                System.out.print("\n");
            }
            System.out.println("========");
            rummikub_gui.board_btn_event = 0;
            }
        }

        

    }
}

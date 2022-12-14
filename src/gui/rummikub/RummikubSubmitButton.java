package gui.rummikub;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import field.FieldDeck;
import gui.select_user.SelectUserGUI;
import gui.userInfo.UserInfoModel;
import gui.user_sequence.UserSequenceResultGUI;
import order.OrderDeck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RummikubSubmitButton extends JButton implements ActionListener {
    

    // 필드변수 정의
    private RummikubGUI rummikub_gui;
    private FieldDeck field_model; // 필드 카드덱 생성 & 관리
    private UserInfoModel[] user_info;
    private OrderDeck order_model;

    private int[] rank_check;

    // 생성 메소드
    public RummikubSubmitButton(String btn_num, RummikubGUI gui, UserInfoModel[] userInfo, FieldDeck field_m, OrderDeck order_m){
        super(btn_num);

        rummikub_gui = gui;
        user_info = userInfo;
        field_model = field_m;
        order_model = order_m;
        rank_check = new int[rummikub_gui.user_num];
        
        for(int i = 0; i<rummikub_gui.user_num; i++){
            rank_check[i] = 0;
        }

        addActionListener(this);
    }

    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
        
        
        rummikub_gui.click_cnt = 0; // 유저 패 & 필드 덱 복제 이벤트 초기화

        
        /*
         * 조건 검사  - 1 & 2
         */
        if(field_model.checkField()){

            // 조건 검사 통과
            JOptionPane.showMessageDialog(null, user_info[rummikub_gui.user_idx - 1].name + "님의 필드 배치 성공입니다.", "루미큐브 관리자", JOptionPane.INFORMATION_MESSAGE);
            
            // 유저 패 검사 - 승리 조건
            if(user_info[rummikub_gui.user_idx - 1].card_count == 0){

                rummikub_gui.change_user_num--; // 유저 수 한명 감소
                user_info[rummikub_gui.user_idx - 1].rank = rummikub_gui.user_num - rummikub_gui.change_user_num; //  유저 랭크 기록
                user_info[rummikub_gui.user_idx - 1].user_status = false;
                rank_check[user_info[rummikub_gui.user_idx - 1].rank - 1] = 1;
            }

        }
        else{
            // 유저 패, 필드 덱 초기화
            user_info[rummikub_gui.user_idx - 1].resetDeck();
            field_model.resetDeck();

            // 유저 덱 수 검사 - 40개 시 패배
            if(user_info[rummikub_gui.user_idx - 1].card_count == 40){
                user_info[rummikub_gui.user_idx - 1].rank = rummikub_gui.change_user_num;
                user_info[rummikub_gui.user_idx - 1].user_status = false;
                rank_check[user_info[rummikub_gui.user_idx - 1].rank - 1] = 1;
                rummikub_gui.change_user_num--;
            } else{
                // 유저 덱에 운영진 카드 한장 먹이기
                order_model.addUserCardDeck(rummikub_gui.user_idx - 1);
            }

        }
        



        /*
             유저 순서 바꿔주기
         */
        if(rummikub_gui.user_idx + 1 == rummikub_gui.user_num + 1){
            // 유저 순서 초기화
            rummikub_gui.user_idx = 1;
        }
        else{
            rummikub_gui.user_idx++;
            // rummikub_gui.gui_update();
        }
        
        // 유저 순서 "활성화 된" 유저로 변경
        while(user_info[rummikub_gui.user_idx - 1].user_status == false){

            if(rummikub_gui.user_idx + 1 == rummikub_gui.user_num + 1){
                // 유저 순서 초기화
                rummikub_gui.user_idx = 1;
            }
            else{
                rummikub_gui.user_idx++;
                rummikub_gui.gui_update();
            }
        }


        // 게임 종료 체크
        if(rummikub_gui.change_user_num == 1){
            // user_info[rummikub_gui.user_idx - 1].rank = 
            for(int i = 0; i<rummikub_gui.user_num; i++){
                if(rank_check[i] == 0){
                    user_info[rummikub_gui.user_idx - 1].rank = i + 1;
                    break;
                }
            }

            // 게임 종료 GUI 전환
            rummikub_gui.setVisible(false);
            JOptionPane.showMessageDialog(null, "게임 종료요", "루미큐브 관리자", JOptionPane.WARNING_MESSAGE);
        }
        rummikub_gui.gui_update();










        // 종료 조건
        /*
         * 승리로 게임 종료
         * 1. 유저 패 모두 소모
         */

         /*
          *  패배로 게임 종료
          *  1. 유저 패 41개 이상
          */

          /*
           * 공통 종료 조건
           * 1. 운영진 카드덱 모두 소모 시 유저 카드 덱 남은 수 검사 후 종료
           */






    }
}
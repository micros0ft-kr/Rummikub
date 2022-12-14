package gui.rummikub;

import java.awt.*;
import javax.swing.JButton;

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

    // 생성 메소드
    public RummikubSubmitButton(String btn_num, RummikubGUI gui, UserInfoModel[] userInfo, FieldDeck field_m, OrderDeck order_m){
        super(btn_num);

        rummikub_gui = gui;
        user_info = userInfo;
        field_model = field_m;
        order_model = order_m;


        addActionListener(this);
    }

    // 액션 리스너
    public void actionPerformed(ActionEvent e) {
        

        // GUI 업데이트 테스트
        // rummikub_gui.gui_update();
        // System.out.println("1231");

        // 제출 버튼 클릭 시 게임 진행



    }
}
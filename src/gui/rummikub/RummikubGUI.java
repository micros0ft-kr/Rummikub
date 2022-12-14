package gui.rummikub;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import field.FieldDeck;
import gui.userInfo.UserInfoModel;
import order.OrderDeck;


public class RummikubGUI extends JFrame {
    
    
    // 필드변수 정의 - GUI 필드
    private JButton rummikub_board_btns[][]; // 루미큐브 보드판 버튼

    private JLabel user_nowSequence_text; // 루미큐브 현재 순서 텍스트
    private JLabel user_nextSequence_text; // 루미큐브 유저 순서 텍스트
    
    private JButton rummikub_userBoard_btns[][]; // 루미큐브 유저 보드판 버튼
    private JLabel orderDeck_num;

    /* 
     * GUI 관리 필드변수 
    */
    public int user_idx; // 유저 순서 관리 인덱스
    public int board_btn_event; // 버튼 클릭 이벤트 관리변수
    // public int user_btn_event;

    public int board_row;
    public int board_col;

    public int click_cnt = 0; // 유저 패 복사 & 필드 복사 이벤트 변수


    /*
     * Rummikub Model 클래스
     */
    private UserInfoModel[] user_info; // 루미큐브 유저 정보 모델 클래스
    private OrderDeck orderDeck_model; // 운영진 카드덱 생성 & 관리 클래스
    private FieldDeck fieldDeck_model; // 필드덱 생성 & 관리 클래스
    public int user_num; // 루미큐브 전체 유저 수
    public int change_user_num; // 게임진행 시 바뀌는 유저 수



    // 생성 메소드
    public RummikubGUI(int userNum, UserInfoModel[] userInfo, OrderDeck order_m, FieldDeck field_m){


        orderDeck_model = order_m;
        fieldDeck_model = field_m;
        user_num = userNum;
        change_user_num = userNum;
        user_info = userInfo;

        user_idx = 1; // 유저 순서 인덱스 [초기 설정 : 1]
        board_btn_event = 0; // 게임 보드판 클릭이벤트 (2: 활성, 0,1 비활성화)

        rummikub_board_btns = new RummikubBoardButton[6][18]; // 루미큐브 보드판 버튼
        rummikub_userBoard_btns = new RummikubUserBoardButton[2][20]; // 루미큐브 유저 보드판 버튼

        // RummikubGUI 컨테이너 정의
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());



        //BorderLayout - NORTH
        // RummikubGUI Title 텍스트
        user_nowSequence_text = new JLabel(userInfo[user_idx - 1].name+"의 순서", SwingConstants.CENTER);
        user_nowSequence_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));




        // BorderLayout - CENTER
        // Rummikub 보드판 버튼 - [6][18]
        JPanel p_board_btn = new JPanel(new GridLayout(6, 18, 5, 5));

        for(int row = 0; row < 6; row ++){
            for(int col = 0; col < 18; col ++){
                rummikub_board_btns[row][col] = new RummikubBoardButton("",this, row, col, user_idx, fieldDeck_model, userInfo);
                p_board_btn.add(rummikub_board_btns[row][col]);
            }
        }
        p_board_btn.setBorder(BorderFactory.createEmptyBorder(30,10,0,10)); // 버튼 패널 마진 주기







        // BorderLayout - SOUTH
        // 제출 & 순서 텍스트 패널 + 유저 카드 덱 버튼 패널
        JPanel p_submitBtn_sequence_userBoardBtn = new JPanel(new BorderLayout());

        // 제출 & 순서 텍스트 패널 - SOUTH 패널 Part 1.
        JPanel p_submitBtn_sequence = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        
        // 제출 버튼
        JButton submit_btn = new RummikubSubmitButton("제출", this, user_info, fieldDeck_model, orderDeck_model);
        // 버튼색상 설정
        submit_btn.setBackground(Color.gray);
        submit_btn.setOpaque(true);
        submit_btn.setBorderPainted(false);
        
        submit_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        submit_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        submit_btn.setPreferredSize(new Dimension(150, 55)); // 버튼 크기 설정

        // 유저 순서 텍스트
        user_nextSequence_text = new JLabel("다음 순서 : " + userInfo[user_idx].name);
        user_nextSequence_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));


        /*
            TO DO. 운영진 카드덱 수
         */
        orderDeck_num = new JLabel("남은 타일 수 : " + (104 - orderDeck_model.Idx_Order));
        orderDeck_num.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));

        // 제출 & 순서 텍스트 패널 요소 add
        p_submitBtn_sequence.add(submit_btn);
        p_submitBtn_sequence.add(user_nextSequence_text);
        p_submitBtn_sequence.add(orderDeck_num);
        p_submitBtn_sequence.setBorder(BorderFactory.createEmptyBorder(30,160,30,0)); // 패널 마진 주기

        // 유저 카드 덱 버튼 패널 - SOUTH 패널 Part 2.
        JPanel p_userBoard_btn = new JPanel(new GridLayout(2, 20, 5, 10));
        for(int row = 0; row < 2; row ++){
            for(int col = 0; col < 20; col ++){
                rummikub_userBoard_btns[row][col] = new RummikubUserBoardButton("", this, row, col, user_idx, user_info, fieldDeck_model);
                p_userBoard_btn.add(rummikub_userBoard_btns[row][col]);
            }
        }
        p_userBoard_btn.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));

        // BorderLayout SOUTH 패널 요소 add
        p_submitBtn_sequence_userBoardBtn.add(p_submitBtn_sequence, BorderLayout.NORTH);
        p_submitBtn_sequence_userBoardBtn.add(p_userBoard_btn, BorderLayout.CENTER);

        



        /*
         * 컨테이너 요소 add
         */
        cp.add(user_nowSequence_text, BorderLayout.NORTH);
        cp.add(p_board_btn, BorderLayout.CENTER);
        cp.add(p_submitBtn_sequence_userBoardBtn, BorderLayout.SOUTH);

        gui_update();


        setTitle("모두의 루미큐브");
        setSize(850,700);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }




    // 게임 진행하며 gui 업데이트 메소드
    public void gui_update(){


        // 현재 순서 Title 텍스트 업데이트
        user_nowSequence_text.setText(user_info[user_idx - 1].name+"의 순서");

        // 루미큐브 필드 보드판 업데이트
        for(int row = 0; row < 6; row ++){
            for(int col = 0; col < 18; col ++){
                if(fieldDeck_model.field[row][col] != null){
                rummikub_board_btns[row][col].setText(Integer.toString(fieldDeck_model.field[row][col].num));
                rummikub_board_btns[row][col].setForeground(fieldDeck_model.field[row][col].color);
            }
                else{
                    rummikub_board_btns[row][col].setText("");
                }
            }
        }

        // 다음 순서 텍스트 업데이트
        // 유저 순서 "활성화 된" 유저로 변경
        // int check_next_idx = user_idx;
        // while(user_info[check_next_idx].user_status == false){

        //     if(check_next_idx == user_num + 1){
        //         // 유저 순서 초기화
        //         check_next_idx = 1;
        //     }
        //     else{
        //         check_next_idx++;
        //     }
        // }
        // user_nextSequence_text = new JLabel("다음 순서 : " + user_info[check_next_idx -1].name);


        // 남은 타일 수 업데이트

        // 루미큐브 유저덱 업데이트
        for(int row = 0; row < 2; row ++){
            for(int col = 0; col < 20; col ++){
                if(user_info[user_idx - 1].user_deck[row][col] != null){
                    rummikub_userBoard_btns[row][col].setText(Integer.toString(user_info[user_idx - 1].user_deck[row][col].num));
                    rummikub_userBoard_btns[row][col].setForeground(user_info[user_idx - 1].user_deck[row][col].color);
            
                }
                else{
                    rummikub_userBoard_btns[row][col].setText("");

                }
                
            }
        }


    }


}

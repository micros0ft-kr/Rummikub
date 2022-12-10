package gui.rummikub;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class RummikubGUI extends JFrame {
    
    
    // 필드변수 정의
    private JButton rummikub_board_btns[][]; // 루미큐브 보드판 버튼
    private JLabel user_sequence_text; // 루미큐브 유저 순서 텍스트
    private JButton rummikub_userBoard_btns[][]; // 루미큐브 유저 보드판 버튼


    // 생성 메소드
    public RummikubGUI(){

        rummikub_board_btns = new RummikubBoardButton[6][18]; // 루미큐브 보드판 버튼
        rummikub_userBoard_btns = new RummikubUserBoardButton[2][20]; // 루미큐브 유저 보드판 버튼

        // RummikubGUI 컨테이너 정의
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());





        //BorderLayout - NORTH
        // RummikubGUI Title 텍스트
        JLabel title_text = new JLabel("김동욱의 순서", SwingConstants.CENTER);
        title_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 30));






        // BorderLayout - CENTER
        // Rummikub 보드판 버튼 - [6][18]
        JPanel p_board_btn = new JPanel(new GridLayout(6, 18, 5, 5));

        for(int row = 0; row < 6; row ++){
            for(int col = 0; col < 18; col ++){
                rummikub_board_btns[row][col] = new RummikubBoardButton("");
                p_board_btn.add(rummikub_board_btns[row][col]);
            }
        }
        p_board_btn.setBorder(BorderFactory.createEmptyBorder(30,10,0,10)); // 버튼 패널 마진 주기







        // BorderLayout - SOUTH
        // 제출 & 순서 텍스트 패널 + 유저 카드 덱 버튼 패널
        JPanel p_submitBtn_sequence_userBoardBtn = new JPanel(new BorderLayout());

        // 제출 & 순서 텍스트 패널 - SOUTH 패널 Part 1.
        JPanel p_submitBtn_sequence = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 0));
        
        // 제출 버튼
        JButton submit_btn = new RummikubSubmitButton("제출");
        // 버튼색상 설정
        submit_btn.setBackground(Color.gray);
        submit_btn.setOpaque(true);
        submit_btn.setBorderPainted(false);
        
        submit_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        submit_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        submit_btn.setPreferredSize(new Dimension(150, 55)); // 버튼 크기 설정

        // 유저 순서 텍스트
        user_sequence_text = new JLabel("다음순서 : 조현호");
        user_sequence_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));

        // 제출 & 순서 텍스트 패널 요소 add
        p_submitBtn_sequence.add(submit_btn);
        p_submitBtn_sequence.add(user_sequence_text);
        p_submitBtn_sequence.setBorder(BorderFactory.createEmptyBorder(30,160,30,0)); // 패널 마진 주기

        // 유저 카드 덱 버튼 패널 - SOUTH 패널 Part 2.
        JPanel p_userBoard_btn = new JPanel(new GridLayout(2, 20, 5, 10));
        for(int row = 0; row < 2; row ++){
            for(int col = 0; col < 20; col ++){
                rummikub_userBoard_btns[row][col] = new RummikubUserBoardButton("");
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
        cp.add(title_text, BorderLayout.NORTH);
        cp.add(p_board_btn, BorderLayout.CENTER);
        cp.add(p_submitBtn_sequence_userBoardBtn, BorderLayout.SOUTH);





        
        setTitle("모두의 루미큐브");
        setSize(850,700);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }


    // 게임 진행하며 gui 업데이트 메소드
    public void gui_update(){


    }


}

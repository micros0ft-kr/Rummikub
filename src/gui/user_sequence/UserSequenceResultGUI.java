package gui.user_sequence;


import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.userInfo.UserInfoModel;

public class UserSequenceResultGUI extends JFrame {


    // 필드변수 정의



    // 생성 메소드 정의
    public UserSequenceResultGUI(int userNum, UserInfoModel[] userInfo){

        // UserSequenceResultGUI 컨테이너 정의
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // BorderLayout - NORTH
        // UserSequenceResultGUI의 Title 텍스트
        JPanel p_title_text = new JPanel(new FlowLayout());
        JLabel title_text = new JLabel("루미큐브 게임 순서",  SwingConstants.CENTER);
        title_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 50));
        p_title_text.add(title_text);
        p_title_text.setBorder(BorderFactory.createEmptyBorder(0,0,50,0)); // 버튼 패널 마진 주기

        // BorderLayout - CENTER
        // 유저 이름 & 순서 텍스트
        JPanel p_name_sequence = new JPanel(new GridLayout(2, userNum, (userNum + 100)/userNum, 0)); // 유저 이름 & 순서 패널생성

        // 유저 이름 텍스트 - JLabel 배열
        JLabel user_names[] = new JLabel[userNum];
        for( int i = 0; i < userNum; i ++){
            user_names[i] = new JLabel(userInfo[i].name, SwingConstants.CENTER);
            user_names[i].setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
            p_name_sequence.add(user_names[i]); // 패널 요소 add
        }

        // 유저 순서 텍스트 - JLabel 배열
        JLabel user_sequences[] = new JLabel[userNum];
        for( int i = 0; i < userNum; i ++){
            user_sequences[i] = new JLabel(Integer.toString(userInfo[i].sequence), SwingConstants.CENTER);
            user_sequences[i].setFont(new Font("Aharoni 굵게", Font.BOLD, 25));
            p_name_sequence.add(user_sequences[i]); // 패널 요소 add
        }

        // BorderLayout - SOUTH
        // 게임 시작 버튼
        JPanel p_start_btn = new JPanel(new FlowLayout()); // 버튼 패널 생성
        JButton start_btn =  new UserSequenceResultButton("게임시작");

        // 버튼색상 설정
        start_btn.setBackground(Color.gray);
        start_btn.setOpaque(true);
        start_btn.setBorderPainted(false);
        
        start_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        start_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        start_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정

        // 버튼 패널 요소 add
        p_start_btn.add(start_btn);
        p_start_btn.setBorder(BorderFactory.createEmptyBorder(30,0,20,0)); // 버튼 패널 마진 주기



        /*
         * UserSequenceResultGUI 컨테이너 요소 add
         */
        cp.add(p_title_text, BorderLayout.NORTH);
        cp.add(p_name_sequence, BorderLayout.CENTER);
        cp.add(p_start_btn, BorderLayout.SOUTH);



        setTitle("모두의 루미큐브");
        setSize(650,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        



    }
}

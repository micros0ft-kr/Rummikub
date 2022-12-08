package gui.select_user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class SelectUserGUI extends JFrame {
    
    // 필드변수 정의


    // 생성 메소드
    public SelectUserGUI(){

        // SelectUserGUI의 컨테이너 Layout 생성
        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());



        // BorderLayout - NORTH
        JLabel selectUserTitle = new JLabel("<html><body><center>루미큐브<br>유저 수 선택</center></body></html>",SwingConstants.CENTER);
        selectUserTitle.setFont(new Font("Aharoni 굵게", Font.BOLD, 50)); // 폰트 설정



        // BorderLayout - CENTER
        JPanel p_userNum_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 0)); // FlowLayout 요소들 간격 설정
        
        // 유저 수 2명버튼
        JButton userNum_btn_2 = new SelectUserButton("2명", 2, this);
        // 버튼색상 설정
        userNum_btn_2.setBackground(Color.gray);
        userNum_btn_2.setOpaque(true);
        userNum_btn_2.setBorderPainted(false);
        
        userNum_btn_2.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        userNum_btn_2.setSize(50, 50); // 버튼 텍스트 크기 설정
        userNum_btn_2.setPreferredSize(new Dimension(100, 70)); // 버튼 크기 설정

        // 유저 수 3명버튼
        JButton userNum_btn_3 = new SelectUserButton("3명", 3, this);
        // 버튼색상 설정
        userNum_btn_3.setBackground(Color.gray);
        userNum_btn_3.setOpaque(true);
        userNum_btn_3.setBorderPainted(false);
        
        userNum_btn_3.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        userNum_btn_3.setSize(50, 50); // 버튼 텍스트 크기 설정
        userNum_btn_3.setPreferredSize(new Dimension(100, 70)); // 버튼 크기 설정

        // 유저 수 4명버튼
        JButton userNum_btn_4 = new SelectUserButton("4명", 4, this);
        // 버튼색상 설정
        userNum_btn_4.setBackground(Color.gray);
        userNum_btn_4.setOpaque(true);
        userNum_btn_4.setBorderPainted(false);
        
        userNum_btn_4.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        userNum_btn_4.setSize(50, 50); // 버튼 텍스트 크기 설정
        userNum_btn_4.setPreferredSize(new Dimension(100, 70)); // 버튼 크기 설정
        
        // 패널 요소 add
        p_userNum_btn.add(userNum_btn_2);
        p_userNum_btn.add(userNum_btn_3);
        p_userNum_btn.add(userNum_btn_4);
        p_userNum_btn.setBorder(BorderFactory.createEmptyBorder(130,0,0,0)); // 버튼 패널 마진 주기


        /*
         * 컨테이너에 요소 add
         */
        cp.add(selectUserTitle, BorderLayout.NORTH);
        cp.add(p_userNum_btn, BorderLayout.CENTER);


        setTitle("모두의 루미큐브");
        setSize(650,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }




}

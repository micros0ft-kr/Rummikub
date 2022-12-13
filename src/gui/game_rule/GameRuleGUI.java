package gui.game_rule;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.userInfo.UserInfoModel;

public class GameRuleGUI extends JFrame {
    
    // 필드변수 정의


    // 생성 메소드
    public GameRuleGUI(int userNum, UserInfoModel[] userInfo){
        
        // GameRuleGUI 컨테이너 정의
        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());


        // BorderLayout - NORTH
        // GameRuleGUI Title 텍스트
        JLabel des_title = new JLabel("게임 설명", SwingConstants.LEFT);
        des_title.setFont(new Font("Aharoni 굵게", Font.BOLD, 50));
        des_title.setBorder(BorderFactory.createEmptyBorder(0,30,0,0)); // 텍스트 마진 주기

        // BorderLayout - CENTER
        // 게임 설명 텍스트
        JLabel des_center = new JLabel("<html><body><center>정해진 순서대로 게임이 진행되며,<br>패가 0개가 아닌 유저가 한명이<br>되면, 즉시 게임이 종료되며,<br>게임의 카드덱의 갯수가 0개가 되면<br>남은 패의 갯수로 순위가 결정되며<br>게임이 종료됩니다.<br>*게임 진행 규칙은 루미큐브 규칙과 동일합니다.*</center></body></html>");
        des_center.setFont(new Font("Aharoni 굵게", Font.HANGING_BASELINE, 30));
        des_center.setBorder(BorderFactory.createEmptyBorder(0,40,0,0)); // 텍스트 마진 주기
        
        
        // BorderLayout - SOUTH
        // 완료 버튼
        JPanel p_check_btn = new JPanel(new FlowLayout());
        JButton check_btn = new GameRuleCheckButton("완료", this,  userNum, userInfo);
        // 버튼색상 설정
        check_btn.setBackground(Color.gray);
        check_btn.setOpaque(true);
        check_btn.setBorderPainted(false);
        
        check_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        check_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        check_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정

        // 버튼 패널 요소 add
        p_check_btn.add(check_btn);
        p_check_btn.setBorder(BorderFactory.createEmptyBorder(0,0,20,0)); // 버튼 패널 마진 주기


        /*
         *  GameRuleGUI 컨테이너 요소 add
         */
        cp.add(des_title, BorderLayout.NORTH);
        cp.add(des_center, BorderLayout.CENTER);
        cp.add(p_check_btn, BorderLayout.SOUTH);

        setTitle("모두의 루미큐브");
        setSize(650,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

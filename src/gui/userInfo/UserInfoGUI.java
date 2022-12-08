package gui.userInfo;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UserInfoGUI extends JFrame {

    // 필드변수 정의


    // 생성 메소드
    public UserInfoGUI(){
        
        // UserInfoGUI 컨테이너 정의
        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

        
        // BorderLayout - NORTH
        // UserInfoGUI의 Title 텍스트
        JPanel p_userInfo_title_desText = new JPanel(new FlowLayout()); // NORTH 부분의 텍스트 패널 생성

        // UserInfoGUI의 Title 텍스트
        JLabel title_text = new JLabel("유저 정보 입력", SwingConstants.CENTER);
        title_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 50));

        // 텍스트 패널 요소 add
        p_userInfo_title_desText.add(title_text);
        // p_userInfo_title_desText.add(des_text);

        



        // BorderLayout - CENTER
        // 유저 정보 입력 설명 텍스트 & 유저 이름 입력받는 텍스트 필드
        JPanel p_textField = new JPanel(new FlowLayout(FlowLayout.CENTER, 500, 10));

        // UserInfoGUI의 Des 텍스트
        JLabel des_text = new JLabel("유저의 이름을 입력하세요", SwingConstants.CENTER);
        des_text.setFont(new Font("Aharoni 굵게", Font.BOLD, 25));

        JTextField userName_textFiled = new JTextField(); // 유저 이름 입력받는 JTextField 생성
        userName_textFiled.setFont(new Font("Aharoni 굵게", Font.BOLD, 30)); // TextFiled 입력 텍스트 크기 설정
        userName_textFiled.setPreferredSize(new Dimension(350, 50)); // TextFiled 창 사이즈 설정

        // 텍스트 필드 패널 마진 주기
        p_textField.setBorder(BorderFactory.createEmptyBorder(110,0,0,0));

        // 텍스트 필드 패널 요소 add
        p_textField.add(des_text);
        p_textField.add(userName_textFiled);



        // BorderLayout - SOUTH
        // 완료 버튼
        JPanel p_check_btn = new JPanel(new FlowLayout()); // 버튼 패널 생성
        JButton check_btn = new UserInfoCheckButton("완료", this);
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
         * UserInfoGUI 컨테이너 요소 add
         */
        cp.add(p_userInfo_title_desText, BorderLayout.NORTH);
        cp.add(p_textField, BorderLayout.CENTER);
        cp.add(p_check_btn, BorderLayout.SOUTH);


        setTitle("모두의 루미큐브");
        setSize(650,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



}

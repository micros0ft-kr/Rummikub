package gui.start;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class StartGUI extends JFrame {
    

    // 필드변수 정의


    // 생성 메소드
    public StartGUI() throws IOException {

        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());


        // BorderLayout - NORTH
        JLabel startTitle = new JLabel("모두의 루미큐브", SwingConstants.CENTER); // StartGUI의 타이틀 텍스트 [JLabel - 가운데 정렬]
        startTitle.setFont(new Font("Aharoni 굵게", Font.BOLD, 50)); // 폰트 설정


        // BorderLayout - CENTER
        File boardImgFile = new File("src/gui/image/board-game.png");
        BufferedImage boardImg = ImageIO.read(boardImgFile); // 이미지 파일 경로 예외처리 & 이미지 경로 받기
        ImageIcon boardImgIcon = new ImageIcon(boardImg); // 이미지 객체 생성
        Image getBoardImg = boardImgIcon.getImage(); // 이미지 가져오기

        // 이미지 사이즈 조절
        Image checkBoardImg = getBoardImg.getScaledInstance(270, 270, Image.SCALE_SMOOTH); // 이미지 사이즈 조절
        ImageIcon checkBoardImgIcon = new ImageIcon(checkBoardImg); // 사이즈 조절한 이미지로 이미지 객체 생성
        JLabel j_boardImg = new JLabel(checkBoardImgIcon); // 이미지 객체 JLabel 객체의 요소로 만듦.


        // BorderLayout - SOUTH
        JPanel p_start_btn = new JPanel(new FlowLayout());
        JButton start_btn = new StartButton("Start", this);

        // 버튼색상 설정
        start_btn.setBackground(Color.gray);
        start_btn.setOpaque(true);
        start_btn.setBorderPainted(false);
        
        start_btn.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        start_btn.setSize(50, 50); // 버튼 텍스트 크기 설정
        start_btn.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정
        p_start_btn.add(start_btn);
        p_start_btn.setBorder(BorderFactory.createEmptyBorder(0,0,20,0)); // 버튼 패널 마진 주기





        /*
         * 컨테이너 BorderLayout 요소 add
         */
        cp.add(startTitle, BorderLayout.NORTH);
        cp.add(j_boardImg, BorderLayout.CENTER);
        cp.add(p_start_btn, BorderLayout.SOUTH);


        setTitle("모두의 루미큐브");
        setSize(650,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        

    }



}

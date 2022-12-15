package gui.game_over;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.userInfo.UserInfoModel;

public class GameOverGUI extends JFrame {
    


    // 필드변수 정의
    private JLabel[] rank_JLabel;

    // 생성 메소드
    public GameOverGUI(int userNum, UserInfoModel[] userInfo){
        

        rank_JLabel = new JLabel[userNum];

        // GameRuleGUI 컨테이너 정의
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());


        JLabel title = new JLabel("게임 종료", SwingConstants.CENTER);
        title.setFont(new Font("Aharoni 굵게", Font.BOLD, 50));
        title.setBorder(BorderFactory.createEmptyBorder(0,30,0,0)); // 텍스트 마진 주기
        cp.add(title, BorderLayout.NORTH);


        JPanel p_rank = new JPanel(new GridLayout(userNum, 1, 20, 20));
        for(int i = 0; i < userNum; i ++){
            int j = 0;
            while(userInfo[j].rank != i + 1){
                j++;
            }
            rank_JLabel[i] = new JLabel(Integer.toString(userInfo[j].rank)+" 등   "+userInfo[j].name, SwingConstants.CENTER);
            rank_JLabel[i].setFont(new Font("Aharoni 굵게", Font.BOLD, 30));
        }

        for(int i = 0; i < userNum; i ++){
            p_rank.add(rank_JLabel[i]);
        }
        cp.add(p_rank, BorderLayout.CENTER);


        JPanel p_btn = new JPanel(new FlowLayout());
        JButton btn_check = new GameOverCheckButton("확인");
        // 버튼색상 설정
        btn_check.setBackground(Color.gray);
        btn_check.setOpaque(true);
        btn_check.setBorderPainted(false);
        
        btn_check.setFont(new Font("Aharoni 굵게", Font.BOLD, 20)); // 버튼 폰트 설정
        btn_check.setSize(50, 50); // 버튼 텍스트 크기 설정
        btn_check.setPreferredSize(new Dimension(200, 70)); // 버튼 크기 설정

        p_btn.add(btn_check);

        cp.add(p_btn, BorderLayout.SOUTH);

        setTitle("루미큐브 종료");
        setSize(650,500);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

}

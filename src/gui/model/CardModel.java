package gui.model;

import java.awt.*;

public class CardModel {

    public static final String RED = "red";
    public static final String BLACK = "black";
    public static final String YELLOW = "yellow";
    public static final String BLUE = "blue";

    public Color color; //색깔
    public int num;  // 숫자

    // 생성 메소드
    public CardModel(Color Card_Color, int Card_Num) {
        color = Card_Color;
        num = Card_Num;
    }


    // 카드 숫자 - 문자열 반환
    public String getCardNum(){
        String num_str = Integer.toString(num);
        return num_str;
    }


}

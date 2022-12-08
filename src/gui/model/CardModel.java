package gui.model;

public class CardModel {

    public static final String RED = "red";
    public static final String BLACK = "black";
    public static final String YELLOW = "yellow";
    public static final String BLUE = "blue";

    public String color; //색깔
    public int num;  // 숫자

    // 생성 메소드
    public CardModel(String Card_Color, int Card_Num) {
        color = Card_Color;
        num = Card_Num;
    }


    // 카드 숫자 - 문자열 반환
    public String getCardNum(){
        String num_str = Integer.toString(num);
        return num_str;
    }


}

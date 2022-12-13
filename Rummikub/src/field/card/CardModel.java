package field.card;
import java.awt.*;

public class CardModel {
    public static final Color RED = Color.RED;
    public static final Color BLACK = Color.BLACK;
    public static final Color YELLOW = Color.YELLOW;
    public static final Color BLUE = Color.BLUE;
    public static final Color MAGENTA = Color.MAGENTA;

    private Color color; //무늬
    private int num;  	// 숫자

    public CardModel(Color Card_Color, int Card_Num) {
        color = Card_Color;
        num = Card_Num;
    }
    
    public CardModel(CardModel _needCopy) {
        color = _needCopy.color();
        num = _needCopy.num();
    }
    
    public Color color() {
    	return color;
    }
    
    public int num() {
    	return num;
    }
}

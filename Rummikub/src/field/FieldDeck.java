package field;
import java.awt.*;
import field.card.CardModel;

public class FieldDeck {
	
	CardModel[][] field = new CardModel[6][18];
	CardModel[][] last_field = new CardModel[6][18];
	Color[] kind_color = new Color[6];
	
	
	//흰색으로 기본값 넣어놓기
	public FieldDeck() {
		for(int i = 0 ; i < 6 ; i++) {
			kind_color[i] = Color.WHITE;
		}
	}
	
	//조건 통과 안되면 이전 덱으로 유지, 배열 깊은 복사
	public void resetDeck() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 18 ; j++) {
				field[i][j] = null;
				field[i][j] = new CardModel(last_field[i][j]);
				// field[i][j] = new CardModel(last_field[i][j].color(), last_field[i][j].num());
			}
		}
	}
	
	//조건이 통과시 field가 업데이트 되야하므로 하기 전에 last_field에 복사(last_field 업데이트)
	public void rememberDeck() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 18 ; j++) {
				last_field[i][j] = null;
				last_field[i][j] = new CardModel(field[i][j]);
			}
		}
	}
	
	public boolean checkFieldCard(int row, int col) {
		if(field[row][col] != null) {
			return true;	//카드 있음
		}
		return false;	//카드 없음
	}
	
	public boolean checkField_Rule_1() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 18 ; j++) {
				if(field[i][j] != null) {
					Color same_color = field[i][j].color();
					int plus_num = field[i][j].num();
					int card_count = 1;
					j++;
					while(field[i][j] != null ) {
						if(field[i][j].color() != same_color || field[i][j].num() != plus_num + 1) {
							return false;
						}
						plus_num ++;
						card_count ++;
						j++;
					}
					if(card_count < 3) return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	public boolean checkField_Rule_2() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 18 ; j++) {
				if(field[i][j] == null) {
					int same_num = field[i][j].num();
					int card_count = 1;
					j++;
					
					while(field[i][j] != null) {
						if(checkColor(field[i][j].color()) != false || field[i][j].num() != same_num) return false;
						
						putColor(i,j);
						card_count ++;
						j++;
					}
					if(card_count < 3) return false;
				}
				
			}
		}
		return true;
	}
	
	
	
	//round가 1일때는 필드에 있는 카드가 선택되지 않아야함. 자신의 패에서 숫자합이 30이 넘도록
	public boolean checkField_Rule_3() {
		//if(자신이 누른 버튼의 위치를 받아와서 합이 30이상이고 
			if(checkField_Rule_1() == true && checkField_Rule_2() == true) {
				return true;
			}
		return false;
	}
	
	
	
	//겹치는 색깔이 있는지 검사
	public boolean checkColor(Color color) {
		for(int i = 0 ; i < kind_color.length ; i++) {
			if(kind_color[i] == color) return true;
		}
		return false;
	}
	
	
	
	//색깔 배열에 색깔 넣기
	public void putColor(int i, int j) {
		for(int k = 0 ; k < kind_color.length ; k++) {	
			if(kind_color[k] == Color.WHITE) {
				kind_color[k] = field[i][j].color();
				break;
			}
		}
	}
	
	
	
	
}

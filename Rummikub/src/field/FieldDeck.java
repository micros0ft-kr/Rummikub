package field;
import java.awt.*;
import field.card.CardModel;

public class FieldDeck {
	
	CardModel[][] field = new CardModel[6][19];
	CardModel[][] last_field = new CardModel[6][19];
	Color[] kind_color = new Color[6];

	
	
	//흰색으로 기본값 넣어놓기
	public FieldDeck() {
		intial_KindColor();
		
		field[0][1] = new CardModel(Color.RED, 1);
		field[0][2] = new CardModel(Color.RED, 2);
		field[0][3] = new CardModel(Color.RED, 3);
		field[0][4] = new CardModel(Color.RED, 4);
		
		field[0][6] = new CardModel(Color.BLACK, 5);
		field[0][7] = new CardModel(Color.BLACK, 6);
		field[0][8] = new CardModel(Color.BLACK, 7);
		
		field[3][14] = new CardModel(Color.BLACK, 10);
		field[3][15] = new CardModel(Color.YELLOW, 10);
		field[3][16] = new CardModel(Color.BLUE, 10);
		field[3][17] = new CardModel(Color.RED, 10);
		
		field[4][14] = new CardModel(Color.BLACK, 11);
		field[4][15] = new CardModel(Color.YELLOW, 11);
		field[4][16] = new CardModel(Color.BLUE, 11);
		field[4][17] = new CardModel(Color.RED, 11);
		
		
//		if(checkField_Rule_1() == true) System.out.println("good");
//		else if(checkField_Rule_1() == false) System.out.println("bad");
//		if(checkField_Rule_2() == true )System.out.println("good");
//		else if(checkField_Rule_2() == false )System.out.println("bad");
		
//		if(checkField_Rule_1() || checkField_Rule_2()) System.out.println("perfect");
		if(checkField() == true) System.out.println("perfect");
		else {
			System.out.println("I am so sad");
		}
	}
	
	//조건 통과 안되면 이전 덱으로 유지, 배열 깊은 복사
	public void resetDeck() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 19 ; j++) {
				field[i][j] = null;
				field[i][j] = new CardModel(last_field[i][j]);
				// field[i][j] = new CardModel(last_field[i][j].color(), last_field[i][j].num());
			}
		}
	}
	
	//인자로 위치, 카드 받아서 필드에 배치
	public void updateDeck(int row, int col, CardModel card) {
		field[row][col] = card;
	}
	
	
	//조건이 통과시 field가 업데이트 되야하므로 하기 전에 last_field에 복사(last_field 업데이트)
	public void rememberDeck() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 19 ; j++) {
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
	
	//나의 눈물이 담긴 버려지는 코드들 ㅠㅠ
//	public boolean checkField_Rule_1() {
//		for(int i = 0 ; i < 6 ; i++) {
//			for(int j = 0 ; j < 18 ; j++) {
//				if(field[i][j] != null) {
//					Color same_color = field[i][j].color();
//					int plus_num = field[i][j].num();
//					int card_count = 1;
//					j++;
//					while(field[i][j] != null ) {
//						if(field[i][j].color() != same_color || field[i][j].num() != plus_num + 1) {
//							return false;
//						}
//						plus_num ++;
//						card_count ++;
//						j++;
//					}
//					if(card_count < 3) return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	
//	public boolean checkField_Rule_2() {
//		for(int i = 0 ; i < 6 ; i++) {
//			for(int j = 0 ; j < 18 ; j++) {
//				if(field[i][j] != null) {
//					int same_num = field[i][j].num();
//					int card_count = 1;
//					putColor(i,j);
//					j++;
//					
//					while(field[i][j] != null) {
//						if(checkColor(field[i][j].color()) != false || field[i][j].num() != same_num) return false;
//						
//						putColor(i,j);
//						card_count ++;
//						j++;
//					}
//					if(card_count < 3) return false;
//					intial_KindColor();
//				}
//				
//			}
//		}
//		return true;
//	}
	
	
	public boolean checkField() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 18 ; j++) {
				if(field[i][j] != null) {
					Color same_color = field[i][j].color();
					int plus_num = field[i][j].num();
					int same_num = field[i][j].num();
					int card_count = 1;
					putColor(i,j);
					j++;
					
					while(field[i][j] != null) {
						if((checkColor(field[i][j].color()) == false && field[i][j].num() == same_num) 
								|| (field[i][j].color() == same_color && field[i][j].num() == plus_num + 1));
						else return false;
						
						putColor(i,j);
						card_count++;
						plus_num++;
						j++;
					}
					if(card_count < 3) return false;
					intial_KindColor();
				}
				
			}
		}
		return true;
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
	
	public void intial_KindColor() {
		for(int i = 0 ; i < 6 ; i++) {
			kind_color[i] = Color.WHITE;
		}
	}
	
	
	
}

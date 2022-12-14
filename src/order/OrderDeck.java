package order;

import java.awt.*;

import gui.userInfo.UserInfoModel;

//gameovergui import 추가하기
public class OrderDeck {
	
	//운영진 카드덱
	int Order_CardCount = 0;
	int UserNum; //유저의수
	int NowSequence;
	public int Idx_Order=0;//운영자 덱 인덱스 = 덱의 남은 수 108이 max
	
	CardModel[] Order_CardDeck;
	private UserInfoModel[] userinfo;//유저정보 모델 클래스 객체
	

	//생성메소드
	//원영진 카드덱 생성 (랜덤으로 108개)
	public OrderDeck(UserInfoModel[] u, int n) {
		userinfo = u;
		UserNum = n;
		Order_CardDeck =  new CardModel[108];

		int ran1, ran2, num=0;
		int [][] ran_card = new int[4][13];
		Color color;
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				ran_card[i][j] = 2 ;
			}
		}
			//int ttt=0;
		while(num < 104) {
			ran1 = ((int)((Math.random()*4)));
			ran2 = ((int)((Math.random()*13)));
			
			if(ran_card[ran1][ran2] !=0) {
				if(ran1 == 0) color = Color.RED;
				else if(ran1 == 1) color = Color.BLACK;
				else if(ran1 == 2) color = Color.YELLOW;
				else color = Color.BLUE;
				Order_CardDeck[num] = new CardModel(color,ran2+1);
				ran_card[ran1][ran2]--;
				num++;
				
				// 현호 조의 디버깅 흔적. 기적의  8 x 13 = 108
				// for(int i=0;i<4;i++) {
				// 	for(int j=0;j<13;j++) {
				// 		System.out.print(ran_card[i][j]);
				// 	}
				// 	System.out.print("\n");
				// }

			}
			
		}
		createUserCardDeck(UserNum);
	}


	
	//*게임 시작 후 처음에 호출*
	// 일단 순서로 함
	//모든 유저한테 카드 14장씩 먹이기
	public void createUserCardDeck(int n) {
		for(int i=0; i<UserNum; i++) {
			for(int j=0;j<14; j++) {
				userinfo[i].receiveCard(Order_CardDeck[Idx_Order]);
				Idx_Order++;
			}
		}
	}
	
	
	//운영진 카드덱에서 (지정 받은) 유저 카드 한장 먹이기
	public void addUserCardDeck(int n){
		userinfo[n].receiveCard(Order_CardDeck[Idx_Order]);
	}
	

	//운영진 카드덱 갯수 0개 체크
	public boolean checkOrderCardCount(){
		if(Idx_Order>=108) {
			return true; //true = 0
		}
		else {
			return false;
		}
	}
	
	//card_count 못가져옴 메소드 만들어야할듯, 아니면 public으로 하든가
	//인자로 유저순서든 , 번호든 받아야됨 그래야지 할 수 있음
//	public void minusUserNum(int n) {
//		if(!userinfo[n].checkLoseCount()||userinfo[n].checkWinCount()) {
//			UserNum--;
//			if(UserNum==1) {
//				new GameOverGui();
//			}
//		}
	//}
	
}

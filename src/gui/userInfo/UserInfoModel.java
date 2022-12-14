package gui.userInfo;

import order.CardModel;

// import gui.model.CardModel;

public class UserInfoModel {
    
    // 필드변수 정의
    // public int user_num; // 루미큐브 유저 수
    public String name; // 유저 이름
    public int rank; // 유저 랭크
    public int sequence; // 유저 순서
    public boolean user_status; // 유저상태 체크

    private CardModel[][] user_deck; // 유저 루미큐브 카드덱
    private int card_count; // 유저 루미큐브 카드 덱 갯수
    private CardModel[][] remember_user_deck; // 유저 이전 턴 루미큐브 카드 덱 백업
    private int rememberCard_count; // 유저 이전 턴 루미큐브 카드 덱 갯수 - 카드 덱 업데이트 하기 위해서 기록


    // 생성 메소드
    public UserInfoModel(String userName, int user_sequence){
        name = userName; // 유저 이름
        sequence = user_sequence; // 유저 순서
        // user_num = userNum; // 루미큐브 유저 수
        rank = 0; // 유저 랭크 Default 0

        user_deck = new CardModel[2][20];
        card_count = 0;
        remember_user_deck = new CardModel[2][20];
        rememberCard_count = 0;
        user_status = true; // 유저 상태 [ture : 유저 게임 진행 중, false : 유저 게임 끝]

    }





    // 실행 메소드

    /*
     * To DO 1. 유저 카드 한장 받기
     *  운영진 카드덱 클래스에서 호출 (운영진 덱에서 한장 받음)
     */
    public void receiveCard(CardModel input_card){
        
        // 유저 카드 수 한장 증가
        card_count++;

        // count 1 ~ 20
        if (card_count / 21 == 0){
            user_deck[0][card_count - 1] = input_card;
        }
        // count 21 ~ 40
        else {
            user_deck[1][(card_count % 20) - 1] = input_card;
        }
    }

    /*
     * To DO 2. 유저 카드 한장 필드에 배치 (유저 덱에서 카드 한장 빼기)
     * params : 배열의 인덱스로 row & col
     */
    public void submitCard(int row, int col){

        // 유저 카드 한장 감소
        card_count--;

        if(row == 0){
            for(int i = col; i<19; i ++){
                user_deck[0][col] = user_deck[0][col+1];
            }
            user_deck[0][19] = user_deck[1][0];
            for(int j = 0; j<19; j ++){
                user_deck[1][j] = user_deck[1][j+1];
            }
        }

        //row == 1
        else{
            for(int z = col; z<19; z ++){
                user_deck[1][col] = user_deck[1][col+1];
            }
            if(col == 19){
                // row = 1 col 19 일 때 처리
                user_deck[1][col] = null;
            }
        }

    }

    /*
     * To DO 3. 유저 카드 덱 수 40 초과 체크
     * True = 40초과
     * False = 40 이하
     */
    public boolean checkLoseCount(){
        if(card_count >= 41){
            return false;
        }
        else {
            return true;
        }
    }


    /*
     * To DO 4. 유저 카드 덱 수 0개 체크
     * True = 0개
     * false != 0개
     */
    public boolean checkWinCount(){
        if(card_count == 0){
            return false;
        }
        else {
            return true;
        }
    }


    /*
     * To DO 5. * 게임 진행 전 호출 * 이전 턴에 대한 유저 덱 백업
     */
    public void rememberDeck(){

        // 2차원 배열 복제
       for(int i=0; i<user_deck.length; i++){
        System.arraycopy(user_deck[i], 0, remember_user_deck[i], 0, user_deck[0].length);
        }

        // 백업 유저 카드덱수 저장
        rememberCard_count = card_count;
    }

    /*
     * To DO 6. 필드 덱에 제출 조건 미통과 시 호출
     * 이전 유저 덱으로 업데이트 (턴 넘어가기 전 호출)
     */
    public void resetDeck(){

        // user_deck = remember_user_deck;

        // 2차원 배열 복제
       for(int i=0; i<remember_user_deck.length; i++){
        System.arraycopy(remember_user_deck[i], 0, user_deck[i], 0, remember_user_deck[0].length);
        }
        card_count = rememberCard_count;
    }

    /*
     * To DO 7. *유저 승리 시 호출*
     * 랭크 업데이트 - 승리
     */
    public void addWinRank(int rank_idx){
        user_status = false;

        // RummikubGUI에서 랭크 Idx 기록
        rank = rank_idx;
    }

    /*
     * To DO 8. *유저 카드 덱 40개 초과 시 호출*
     * 랭크 업데이트 - 패배
     */
    public void addLoseRank(int change_userNum){
        user_status = false;

        // RummikubGUI에서 게임 진행 중인 유저 수
        rank = change_userNum + 1;
    }


}

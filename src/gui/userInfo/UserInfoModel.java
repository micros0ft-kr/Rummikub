package gui.userInfo;

import gui.model.CardModel;

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
     */
    public void receiveCard(){

    }

    /*
     * To DO 2. 유저 카드 한장 필드에 배치 (유저 덱에서 카드 한장 빼기)
     */
    public void submitCard(){

    }

    /*
     * To DO 3. 유저 카드 덱 수 40 초과 체크
     */
    public boolean checkLoseCount(){
        return true;
    }


    /*
     * To DO 4. 유저 카드 덱 수 0개 체크
     */
    public boolean checkWinCount(){
        return true;
    }


    /*
     * To DO 5. * 게임 진행 전 호출 * 이전 턴에 대한 유저 덱 백업
     */
    public void rememberDeck(){

    }

    /*
     * To DO 6. 필드 덱에 제출 조건 미통과 시 호출
     * 이전 유저 덱으로 업데이트 (턴 넘어가기 전 호출)
     */
    public void resetDeck(){

    }

    /*
     * To DO 7. *유저 승리 시 호출*
     * 랭크 업데이트 - 승리
     */
    public void addWinRank(){

    }

    /*
     * To DO 8. *유저 카드 덱 40개 초과 시 호출*
     * 랭크 업데이트 - 패배
     */
    public void addLoseRank(){

    }


}

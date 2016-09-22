package pgcon;

import java.util.Scanner;

public class Q2 {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
		String answer = "";

		//マルバツゲームフィールドデータの取得
		String[] tictacData = new String[3];//行数確保
		for(int i = 0; i < 3; i++){ // while(i < 3){
			tictacData[i] = sc.nextLine();
		}
		sc.close();

		//マルバツゲームフィールドデータの展開
		String tictacField[][] = new String[3][3];
		tictacField[0][0] = tictacData[0].substring(0,1);
		tictacField[0][1] = tictacData[0].substring(1,2);
		tictacField[0][2] = tictacData[0].substring(2,3);

		tictacField[1][0] = tictacData[1].substring(0,1);
		tictacField[1][1] = tictacData[1].substring(1,2);
		tictacField[1][2] = tictacData[1].substring(2,3);

		tictacField[2][0] = tictacData[2].substring(0,1);
		tictacField[2][1] = tictacData[2].substring(1,2);
		tictacField[2][2] = tictacData[2].substring(2,3);


		//マルバツゲーム判定


		//○と×の数計測(進行手番判定用)
		int tic = 0; // ○の数
		int tac = 0; // ×の数
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tictacField[i][j].equals("o")){
					tic += 1;
				}else if(tictacField[i][j].equals("x")){
					tac += 1;
				}
			}
		}

		//○と×の数計測(次手勝敗判定用)
		// 初期化
		int nextWinTic = 0;
		int ticLine[] = new int[3];
		int ticStraight[] = new int[3];
		int ticSland[] = new int[2];


		// 判定開始(列)
		for(int i = 0; i < 3; i++){
			nextWinTic = 0;
			for(int j = 0; j < 3; j++){
				if(tictacField[i][j].equals("o")){
					nextWinTic += 1;
				}else if(tictacField[i][j].equals("x")){
					nextWinTic -= 1;
				}
			}
			ticStraight[i] = nextWinTic;
		}

		nextWinTic = 0;
		// 判定開始(行)
		for(int i = 0; i < 3; i++){
			nextWinTic = 0;
			for(int j = 0; j < 3; j++){
				if(tictacField[j][i].equals("o")){
					nextWinTic += 1;
				}else if(tictacField[j][i].equals("x")){
					nextWinTic -= 1;
				}
			}
			ticLine[i] = nextWinTic;
		}

		if(tictacField[0][0].equals("o")){
			ticSland[0] += 1;
		}else if(tictacField[0][0].equals("x")){
			ticSland[0] -= 1;
		}
		if(tictacField[1][1].equals("o")){
			ticSland[0] += 1;
			ticSland[1] += 1;
		}else if(tictacField[1][1].equals("x")){
			ticSland[0] -= 1;
			ticSland[1] -= 1;
		}
		if(tictacField[2][2].equals("o")){
			ticSland[0] += 1;
		}else if(tictacField[2][2].equals("x")){
			ticSland[0] -= 1;
		}
		if(tictacField[0][2].equals("o")){
			ticSland[1] += 1;
		}else if(tictacField[0][2].equals("x")){
			ticSland[1] -= 1;
		}
		if(tictacField[2][0].equals("o")){
			ticSland[1] += 1;
		}else if(tictacField[2][0].equals("x")){
			ticSland[1] -= 1;
		}

		int ticNextWin = 0;
		for(int i = 0; i < 3; i++){
			if(ticLine[i] == 2){
				ticNextWin = 2;
				break;
			}
			if(ticStraight[i] == 2){
				ticNextWin = 2;
				break;
			}
		}
		if((ticNextWin != 2) && (ticSland[0] == 2) || (ticSland[1] == 2) ){
			ticNextWin = 2;
		}

		int blankCnt = 0;
		//盤面が全て埋まっているか判定
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tictacField[i][j].equals("-")){
					blankCnt += 1;
				}
			}
		}

		int ticCnt = 0; //勝利判定
		int tacCnt = 0; //敗北判定

		//盤面が全て埋まっている
		if(blankCnt < 9){
			//行単位の勝利判定
			for(int i = 0; i<3; i++){
				if(ticLine[i] == 3){
					ticCnt++;
				}else if(ticLine[i] == -3){
					tacCnt++;
				}
			}

			//列単位の勝利判定
			for(int i = 0; i<3; i++){
				if(ticStraight[i] == 3){
					ticCnt++;
				}else if(ticStraight[i] == -3){
					tacCnt++;
				}
			}

			//斜め単位の勝利判定
			for(int i = 0; i < 2; i++){
				if(ticSland[i] == 3){
					ticCnt++;
				}else if(ticSland[i] == -3){
					tacCnt++;
				}
			}

			//総合判定
			if(blankCnt == 0){ // 盤面が全て『埋まっている』場合
				if((ticCnt == 0) && (tacCnt == 0)){
					answer = "FIN";
				}else if(ticCnt != 0){
					answer = "WIN";
				}else if(tacCnt != 0){
					answer = "LOSE";
				}else if(tic > tac){
					answer = "NG";
				}else if(ticNextWin == 2){
					answer = "OK";
				}else{
					answer = "NO";
				}
			}else { // 盤面が『埋まり切っていない』場合
				if(ticCnt != 0){
					answer = "WIN";
				}else if(tacCnt != 0){
					answer = "LOSE";
				}else if(tic > tac){
					answer = "NG";
				}else if(ticNextWin == 2){
					answer = "OK";
				}else{
					answer = "NO";
				}
			}
		}else {// 盤面が全て『空』の場合
			answer = "NO";
		}
		System.out.println(answer);
    }

}

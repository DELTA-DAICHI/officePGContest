/* 
  動作はしますが、ゲーム判定部が動作不良を起こします。
  具体的には WIN LOSE OK NG は判定しますが、NOは判定してくれませんでした。
*/

package pgcon;

import java.util.Scanner;

public class Q2 {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
		String answer = "";

		//マルバツゲームフィールドデータの取得
		String[] tictacData = new String[3];//行数確保
		int i = 0;
		try{
			while(i < 3){
				tictacData[i] = sc.nextLine();
				i++;
			}
		} finally{
			sc.close();
		}

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
		for(i = 0; i < 3; i++){
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
		int ticNextLineWin = 0;
		int ticNextStraightWin = 0;
		int ticNextSlandWin = 0;
		for(i = 0; i < 3; i++){
			ticLine[i] = 0;
			ticStraight[i] = 0;
		}
		ticSland[0] = 0;
		ticSland[1] = 0;



		// 判定開始(列)
		for(i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tictacField[i][j].equals("o")){
					nextWinTic += 1;
				}else if(tictacField[i][j].equals("x")){
					nextWinTic -= 1;
				}
			}
			ticStraight[i] = nextWinTic;
			nextWinTic = 0;
		}

		nextWinTic = 0;
		// 判定開始(行)
		for(i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tictacField[j][i].equals("o")){
					nextWinTic += 1;
				}else if(tictacField[j][i].equals("x")){
					nextWinTic -= 1;
				}
			}
			ticLine[i] = nextWinTic;
			nextWinTic = 0;
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

//		for(i = 0; i < 3; i++){
//			System.out.println("ticStraight[" + i + "]：" + ticStraight[i]);
//			System.out.println("ticLine[" + i + "]：" + ticLine[i]);
//		}
//		for(i = 0; i < 2; i++){
//			System.out.println("ticSland[" + i + "]：" + ticSland[i]);
//		}



		for(i = 0; i < 3; i++){
			if(ticLine[i] == 2){
				ticNextLineWin = 2;
			}
			if(ticStraight[i] == 2){
				ticNextStraightWin = 2;
			}
		}
		if( (ticSland[0] == 2) || (ticSland[1] == 2) ){
			ticNextSlandWin = 2;
		}

		int blankCnt = 0;
		//盤面が全て埋まっているか判定
		for(i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tictacField[i][j].equals("-")){
					blankCnt += 1;
				}
			}
		}

		int rowCnt_o = 0; //行判定
		int rowCnt_x = 0; //行判定
		int colCnt_o = 0; //列判定
		int colCnt_x = 0; //列判定
		int slaCnt_o = 0; //斜め判定
		int slaCnt_x = 0; //斜め判定

		//盤面が全て埋まっている
		if(blankCnt < 9){
			//行単位の勝利判定
			for(i = 0; i<3; i++){
				if(tictacField[i][0].equals("o") && tictacField[i][1].equals("o") && tictacField[i][2].equals("o")){
					rowCnt_o += 1;
				}else if(tictacField[i][0].equals("x") && tictacField[i][1].equals("x") && tictacField[i][2].equals("x")){
					rowCnt_x += 1;
				}
			}

			//列単位の勝利判定
			for(i = 0; i<3; i++){
				if(tictacField[0][i].equals("o") && tictacField[1][i].equals("o") && tictacField[2][i].equals("o")){
					colCnt_o += 1;
				}else if(tictacField[0][i].equals("x") && tictacField[1][i].equals("x") && tictacField[2][i].equals("x")){
					colCnt_x += 1;
				}
			}

			//斜め単位の勝利判定
			if(tictacField[0][0].equals("o") && tictacField[1][1].equals("o") && tictacField[2][2].equals("o")){
				slaCnt_o += 1;
			}else if(tictacField[0][0].equals("x") && tictacField[1][1].equals("x") && tictacField[2][2].equals("x")){
				slaCnt_x += 1;
			}

			if(tictacField[0][2].equals("o") && tictacField[1][1].equals("o") && tictacField[2][0].equals("o")){
				slaCnt_o += 1;
			}else if(tictacField[0][2].equals("x") && tictacField[1][1].equals("x") && tictacField[2][0].equals("x")){
				slaCnt_x += 1;
			}


			//総合判定
			if(blankCnt == 0){ // 盤面が全て『埋まっている』場合
				if(rowCnt_o == 0 && colCnt_o == 0 && slaCnt_o == 0 && rowCnt_x == 0 && colCnt_x == 0 && slaCnt_x == 0){
					answer = "FIN";
				}else if(rowCnt_o != 0 || colCnt_o != 0 || slaCnt_o != 0){
					answer = "WIN";
				}else if(rowCnt_x != 0 || colCnt_x != 0 || slaCnt_x != 0){
					answer = "LOSE";
				}else if( (tic > tac) || (tac == 0 && tic == 1)){
					answer = "NG";
				}else if( (tac >= tic) && (ticNextLineWin == 2 || ticNextStraightWin == 2 || ticNextSlandWin == 2)){
					answer = "OK";
				}else if( (tac >= tic) && (ticNextLineWin != 2 || ticNextStraightWin != 2 || ticNextSlandWin != 2)){
					answer = "NO";
				}
			}else { // 盤面が『埋まり切っていない』場合
				if(rowCnt_o != 0 || colCnt_o != 0 || slaCnt_o != 0){
					answer = "WIN";
				}else if(rowCnt_x != 0 || colCnt_x != 0 || slaCnt_x != 0){
					answer = "LOSE";
				}else if(tic > tac || (tac == 0 && tic == 1)){
					answer = "NG";
				}else if( (tac >= tic) && (ticNextLineWin == 2 || ticNextStraightWin == 2 || ticNextSlandWin == 2)){
					answer = "OK";
				}else if( (tac >= tic) && (ticNextLineWin != 2 || ticNextStraightWin != 2 || ticNextSlandWin != 2)){
					answer = "NO";
				}
			}
		}else {// 盤面が全て『空』の場合
			answer = "NO";
		}
		System.out.println(answer);
    }

}

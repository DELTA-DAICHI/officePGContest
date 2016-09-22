package pgcon;

import java.io.IOException;
import java.util.Scanner;

public class Q1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//問題文の取得
		String[] kansuData = new String[3];//行数確保
		for(int i = 0; i < 3; i++){
			kansuData[i] = sc.nextLine();
		}
		sc.close();
		int zenkan = Integer.parseInt(kansuData[0]);//全巻数

		int[] allNumber = new int[zenkan]; //全巻数の箱

		String[] haveList = kansuData[1].split(" "); //『所持巻数』リスト
		if(!haveList[0].equals("0")){
			for(int i = 0; i < haveList.length; i++){
				int haveNumber = Integer.parseInt(haveList[i])-1;
				if(haveNumber >= 0 && haveNumber < zenkan){
					allNumber[ haveNumber ] += 2;
				}
			}
		}

		String[] sellList = kansuData[2].split(" "); //『古本屋巻数』リスト
		if(!sellList[0].equals("0")){
			for(int i = 0; i < sellList.length; i++){
				int sellNumber = Integer.parseInt(sellList[i])-1;
				if(sellNumber >= 0 && sellNumber < zenkan){
					allNumber[ sellNumber ] += 1;
				}
			}
		}

		StringBuffer answerTmp = new StringBuffer();
		for(int i = 0; i < allNumber.length; i++){
			if(allNumber[i] == 1){
				answerTmp.append(i + 1);
				answerTmp.append(" ");
			}
		}

		String answer = "";
		answer = answerTmp.toString().trim();
		if(answer.length() == 0){
			answer = "None";
		}
		System.out.println(answer);
	}
}

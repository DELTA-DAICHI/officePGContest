package pgcon;

import java.io.IOException;
import java.util.Scanner;

public class Q1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String answer = "";
		String answerTmp = "";
		//問題文の取得
		String[] kansuData = new String[3];//行数確保
		int i = 0;
		try{
			while(i < 3){
				kansuData[i] = sc.nextLine();
				i++;
			}
		} finally{
			sc.close();
		}
		Integer zenkan = Integer.parseInt(kansuData[0]);//全巻数

		Integer[] allNumber = new Integer[zenkan]; //全巻数の箱
		for(i = 0; i< allNumber.length; i++){
			allNumber[i] = 0;
		}

		String[] haveList = kansuData[1].split(" "); //『所持巻数』リスト
		if(!haveList[0].equals("0")){
			for(i = 0; i < haveList.length; i++){
				Integer haveNumber = Integer.parseInt(haveList[i])-1;
				if(haveNumber != -1 && haveNumber >= 0 && haveNumber < zenkan){
					allNumber[ haveNumber ] += 2;
				}
			}
		}

		String[] sellList = kansuData[2].split(" "); //『古本屋巻数』リスト
		if(!sellList[0].equals("0")){
			for(i = 0; i < sellList.length; i++){
				Integer sellNumber = Integer.parseInt(sellList[i])-1;
				if(sellNumber != -1 && sellNumber >= 0 && sellNumber < zenkan){
					allNumber[ sellNumber ] += 1;
				}
			}
		}

		for(i = 0; i < allNumber.length; i++){
			if(allNumber[i] == 1){
				answerTmp += String.valueOf(i+1);
				answerTmp += " ";
			}
		}
		answer = answerTmp.trim();
		if(answer == null || answer.length() == 0){
			answer = "None";
		}
		System.out.println(answer);
	}
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// ボール並び取得
		String strBallList = sc.nextLine();
		sc.close();

		int redCnt = 0;
		int greenCnt = 0;
		int blueCnt = 0;
		for(char x: strBallList.toCharArray()){
			if(x == 'R'){
				redCnt++;
			}else if(x == 'G'){
				greenCnt++;
			}else if(x == 'B'){
				blueCnt++;
			}
		}

		int allCnt = 0;
		if(redCnt % 2 != 0){
			allCnt++;
		}
		if(greenCnt % 2 != 0){
			allCnt++;
		}
		if(blueCnt % 2 != 0){
			allCnt++;
		}
		System.out.println(allCnt);
	}
}

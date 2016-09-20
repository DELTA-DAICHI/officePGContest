import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// 1行だけ取得
		String strReverse = sc.nextLine();
		sc.close();

		StringBuffer sr = new StringBuffer(strReverse);
		String strR = sr.reverse().toString();
		System.out.println(strR);
	}
}

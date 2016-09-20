/*
 * 動作しません。
 * 問題に設定されたエスケープコマンドの解析にてこずっています。
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int inputLineNum = Integer.parseInt(sc.nextLine());

		String[] inputLineData = new String[inputLineNum];//行数確保
		String[][] outputScreenData = new String[25][80];

		for(int i = 0; i < 25; i++){
			for(int j = 0; j < 80; j++){
				outputScreenData[i][j] = " ";
			}
		}
		int cnt = 0;
		try{
			while(cnt < inputLineNum){
				inputLineData[cnt] = sc.nextLine();
				cnt++;
			}
		} finally{
			sc.close();
		}

		byte[] data = inputLineData[0].getBytes();
		String strData = DatatypeConverter.printHexBinary(data);
		String strEscKeyCode = "1B5B";
		String strEscClear = strEscKeyCode + "324A";
		String strEscMoveC = strEscKeyCode + "(....)3B(....)48";

//		Pattern p = Pattern.compile(strEscClear);
//		Matcher m = p.matcher(strData);


		System.out.println(strData);
		System.out.println("compileCode:" + strEscClear);
		String[] aryStrEscClear = regCompileClear(strEscClear, strData);
		for(int i = 0; i < aryStrEscClear.length; i++){
			System.out.println(aryStrEscClear[i]);
		}
//		while(m.find()){
//			System.out.println("[" + m.group() + "]" + m.start() + " ⇒ " + m.end());
//		}
		System.out.println("");

		System.out.println(strData);
		System.out.println("compileCode:" + strEscMoveC);
		String[] aryStrEscMoveC = regCompileMoveC(strEscMoveC, strData);
		for(int i = 0; i < aryStrEscMoveC.length; i++){
			String[] aryViewLines = aryStrEscMoveC[i].split(",");
			String[] aryMovePositions = aryViewLines[1].split("-");
			System.out.println("エスケープコマンド位置：" + aryViewLines[0] + " / 移動位置：" + aryMovePositions[0] + "行" + aryMovePositions[1] + "列");
		}
//		p = Pattern.compile(strEscMoveC);
//		m = p.matcher(strData);
//		while(m.find()){
//			System.out.println("全体[" + m.group() + "]" + m.start() + " ⇒ " + m.end());
//			System.out.println("行数[" + m.group(1) + "]" + m.start(1) + " ⇒ " + m.end(1));
//			System.out.println("列数[" + m.group(2) + "]" + m.start(2) + " ⇒ " + m.end(2));
//		}
//		System.out.println(inputLineData[0]);

//		for(int i = 0; i < 25; i++){
//			for(int j = 0; j < 80; j++){
//				System.out.print(outputScreenData[i][j]);
//			}
//			System.out.println("");
//		}
	}

    // 基本挿入法（クイックソート）*********************************
	// 配列, 最小値[0],最大値[配列数-1]
    public static void quickSort(int[] arr, int left, int right){
        if (left <= right) {
            int p = arr[(left+right) / 2];
            int l = left;
            int r = right;

            while(l <= r) {
                while(arr[l] < p){ l++; }
                while(arr[r] > p){ r--; }

                if (l <= r) {
                    int tmp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = tmp;
                    l++;
                    r--;
                }
            }
            quickSort(arr, left, r);
            quickSort(arr, l, right);
        }
    }

    public static String[] regCompileClear(String compilePtn, String chkData){
		Pattern p = Pattern.compile(compilePtn);
		Matcher m = p.matcher(chkData);
		ArrayList<String> checkedList = new ArrayList<String>();
		int i = 0;
		while(m.find()){
			checkedList.add(i , m.start() + "-" + m.end() + "," + m.group());
			i++;
		}
		return (String[])checkedList.toArray(new String[0]);
    }

    public static String[] regCompileMoveC(String compilePtn, String chkData){
		Pattern p = Pattern.compile(compilePtn);
		Matcher m = p.matcher(chkData);
		ArrayList<String> checkedList = new ArrayList<String>();
		int i = 0;
		while(m.find()){
			checkedList.add(i , m.start() + "-" + m.end() + "," + (Integer.parseInt(m.group(1).substring(0, 2))-30) + (Integer.parseInt(m.group(1).substring(2, 4))-30) + "-" + (Integer.parseInt(m.group(2).substring(0, 2))-30) + (Integer.parseInt(m.group(2).substring(2, 4))-30));
			i++;
		}

		return (String[])checkedList.toArray(new String[0]);
    }

    public static int moveCursorPosition(){
		return 0;

    }

}

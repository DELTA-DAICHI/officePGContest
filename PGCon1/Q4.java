package pgcon;

import java.util.Scanner;

public class Q4 {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	//出力用配列確保
		String[] pixelOut = new String[24];

		//問題文取得
		String bitStr = sc.nextLine();
		sc.close();

		//半角空白で区切って配列化
		String[] pixelArray = bitStr.split("\\s");

		//16進数⇒10進数⇒2進数へ変換後、全てをくっつける
		String pixelChara = "";
		for(int i=0; i < pixelArray.length; i++){

		  Long bitHex = Long.parseLong(pixelArray[i],16);

		  String pixelTemp = Long.toBinaryString(bitHex);
		  if(pixelTemp.length() < 8){
			  pixelTemp =  "00000000" + pixelTemp;
			  pixelChara += pixelTemp.substring(pixelTemp.length() - 8, pixelTemp.length());
		  }else{
			  pixelChara += pixelTemp;
		  }
		}

		//指定文字列変換
		for(int i = 0; i < 24; i++){
			String pixelOutTemp =pixelChara.substring(24 * i, 24 *(i + 1));
			pixelOutTemp = pixelOutTemp.replace('0','.');
			pixelOut[i] = pixelOutTemp.replace('1','X');
		}

		//画面出力(24ずつ:for文利用) 通常
		for(int i = 0; i < pixelOut.length; i++){
			System.out.println(pixelOut[i]);
		}
		//空行追加
		System.out.println("");

		//画面出力(24ずつ:for文利用) 右90度回転
		for(int j = 0; j < pixelOut.length; j++){
			for(int i = pixelOut.length-1; i >= 0 ; i--){
				System.out.print(pixelOut[i].substring(j,j+1));
			}
			System.out.println("");
		}
    }
}

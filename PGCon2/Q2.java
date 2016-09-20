import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// カード並び取得
		String strCardList = sc.nextLine();
		sc.close();

		// 空白でバラす
		String[] cardArray = strCardList.split("\\s");


		// 各トランプ用整数配列
		int[] heartList = new int[13];
		int[] cloverList = new int[13];
		int[] diamondList = new int[13];
		int[] spadeList = new int[13];

		int hNum = 0;
		int cNum = 0;
		int dNum = 0;
		int sNum = 0;

		for(int i = 0;i < cardArray.length; i++){
			String strMark = cardArray[i].substring(0,1);
			int cardNumber = MarkReplacerInt(cardArray[i].substring(1));

			switch(strMark){
				case "S":
					spadeList[sNum] = cardNumber;
					sNum++;
					break;
				case "D":
					diamondList[dNum] = cardNumber;
					dNum++;
					break;
				case "C":
					cloverList[cNum] = cardNumber;
					cNum++;
					break;
				case "H":
					heartList[hNum] = cardNumber;
					hNum++;
					break;
			}
		}

		quickSort(spadeList, 0, sNum-1);
		quickSort(diamondList, 0, dNum-1);
		quickSort(cloverList, 0, cNum-1);
		quickSort(heartList, 0, hNum-1);

		if(sNum > 0){
			System.out.print("S:");
			for(int i = 0; i < sNum-1; i++){
				System.out.print(MarkReplacerStr(spadeList[i]) + ",");
			}
			System.out.println(MarkReplacerStr(spadeList[sNum-1]));
		}

		if(dNum > 0){
			System.out.print("D:");
			for(int i = 0; i < dNum-1; i++){
				System.out.print(MarkReplacerStr(diamondList[i]) + ",");
			}
			System.out.println(MarkReplacerStr(diamondList[dNum-1]));
		}

		if(cNum > 0){
			System.out.print("C:");
			for(int i = 0; i < cNum-1; i++){
				System.out.print(MarkReplacerStr(cloverList[i]) + ",");
			}
			System.out.println(MarkReplacerStr(cloverList[cNum-1]));
		}

		if(hNum > 0){
			System.out.print("H:");
			for(int i = 0; i < hNum-1; i++){
				System.out.print(MarkReplacerStr(heartList[i]) + ",");
			}
			System.out.println(MarkReplacerStr(heartList[hNum-1]));
		}
	}


	// マーク変換(数字⇒文字)
	public static String MarkReplacerStr(int a){
		String mrs = null;

		if(a == 1){
			mrs = "A";
		}else if(a == 10){
			mrs = "0";
		}else if(a == 11){
			mrs = "J";
		}else if(a == 12){
			mrs = "Q";
		}else if(a == 13){
			mrs = "K";
		}else{
			mrs = String.valueOf(a);
		}

		return mrs;
	}

	// マーク変換(文字⇒数字)
	public static int MarkReplacerInt(String b){
		int mri = 0;

		if(b.equals("A")){
			mri = 1;
		}else if(b.equals("0")){
			mri = 10;
		}else if(b.equals("J")){
			mri = 11;
		}else if(b.equals("Q")){
			mri = 12;
		}else if(b.equals("K")){
			mri = 13;
		}else{
			mri = Integer.parseInt(b);
		}
		return mri;
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

}

package pgcon;

import java.util.Scanner;


public class Q3 {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    	int beforeTaxRate = 100 + sc.nextInt(); // 変更前税率
    	int afterTaxRate = 100 + sc.nextInt();  // 変更後税率
    	int beforeTaxSum = sc.nextInt();  // 変更前２商品合計
    	int afterSumMax = 0;

    	for(int i = 1; i < beforeTaxSum-1; i++){
    		for(int j = i; j < beforeTaxSum-1; j++){
    			int beforeTaxCalcA = (i * beforeTaxRate/100);
    			int beforeTaxCalcB = (j * beforeTaxRate/100);
    			int beforeCalcSum = beforeTaxCalcA + beforeTaxCalcB;

    			if(beforeCalcSum == beforeTaxSum){
    				int afterTaxCalcA = (i * afterTaxRate/100)*100;
    				int afterTaxCalcB = (j * afterTaxRate/100)*100;
    				int afterCalcSum = afterTaxCalcA + afterTaxCalcB;
    				if(afterCalcSum > afterSumMax){
    					afterSumMax = afterCalcSum;
    				}
    			}
    		}
    	}
    	afterSumMax /= 100;
    	System.out.println(afterSumMax);
    }

}

package huifufx;

import java.math.BigDecimal;

public class FXTest {

    public static double getFx(double awx_fx, int bp, int frp) {
        double hadSundFx = 0.0;
        if (bp == 0) {
            hadSundFx = awx_fx * (1 + (double) frp * 0.01);
            System.out.println("FPR汇率" + awx_fx);
        } else
            hadSundFx = awx_fx + (double) bp * 0.0001;

        return (new BigDecimal(hadSundFx).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
    public static int calAmt(String buy_cur, String sell_cur, double buy_amt, double sell_amt, double fx) {
        StringBuilder ccPairstringBuilder = new StringBuilder(buy_cur);
        ccPairstringBuilder.append(sell_cur);
        int ccyCode = WordConvert.getConvertResult(ccPairstringBuilder.toString());
        String ccPair = CurPairEnum.ccPair(ccyCode);
        BigDecimal calAmt;
        BigDecimal finalAmt;
        if (buy_amt == 0.0) {//buy amount 无值
            if (ccPair.substring(0, 3).equals(buy_cur)) {//buy cur 是大币种的计算方式
                calAmt = new BigDecimal(sell_amt).divide(new BigDecimal(fx),2,BigDecimal.ROUND_HALF_UP);
            } else //buy cur 是小币种的计算方式
                calAmt = new BigDecimal(sell_amt).multiply(new BigDecimal(fx));;
        } else {
            if (ccPair.substring(0, 3).equals(buy_cur)) {//buy cur 是大币种的计算方式

                calAmt = new BigDecimal(buy_amt).multiply(new BigDecimal(fx));
            } else //buy cur 是小币种的计算方式

                calAmt = new BigDecimal(buy_amt).divide(new BigDecimal(fx),2,BigDecimal.ROUND_HALF_UP);

        }
        BigDecimal midAmt = calAmt.multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(midAmt);
        return midAmt.intValue();

    }

    public static boolean isResultCorrect(int expect, int actual) {
        return expect == actual;
    }


    public static void main(String[] args) {
        //  System.out.println(getFx(7.013207,6,1));
        int amt = calAmt("USD", "CNY", 100000.0, 0.0, 7.013207);
        System.out.println(amt);

    }


}




package huifufx;
public enum CurPairEnum {
    USDCNY(WordConvert.getConvertResult("USDCNY"), "USDCNY"),
    CNYJPY(WordConvert.getConvertResult("CNYJPY"), "CNYJPY"),
    AUDCNY(WordConvert.getConvertResult("AUDCNY"), "AUDCNY"),
    GBPCNY(WordConvert.getConvertResult("GBPCNY"), "GBPCNY"),
    EURCNY(WordConvert.getConvertResult("EURCNY"), "EURCNY"),
    UNDEFINE(-1, "不存在货币对");

    private int code;
    private String ccPair;

    CurPairEnum(int code, String ccPair) {
        this.code = code;
        this.ccPair = ccPair;
    }

    public static String ccPair(int code) {
        for (CurPairEnum m : CurPairEnum.values()) {
            if (m.getCode() == code) {
                return m.getCcPair();
            }
        }
        return UNDEFINE.getCcPair();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCcPair() {
        return ccPair;
    }

    public void setCcPair(String ccPair) {
        this.ccPair = ccPair;
    }
}


package huifufx;

public class WordConvert {
    public static int getConvertResult(String word) {
        int[] arr = new int[word.length()];
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = word.charAt(i);
            result += arr[i];
        }
        return result;
    }

}

public class DartGame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String testCase[] = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
        for (String dartResult : testCase) {
            System.out.println(Solution(dartResult));
        }
    }

    private static int Solution(String dartResult) {
        // TODO Auto-generated method stub
        //숫자만 분리
        String[] num = dartResult.split("[SDT][\\#]*[\\*]*");

        //문자만 분리
        String[] str = dartResult.split("\\d{1,2}[\\#]*[\\*]*");
        int i;
        int answer = 0;
        int length = num.length;


        int[] Score = new int[length];

        for (i = 0; i < length; i++) {
            //문자와 특수문자 분리
            int parseint = Integer.parseInt(num[i]);
            String strIndex = str[i + 1];
            char c = strIndex.charAt(0);

            switch (c) {
                case 'S':
                    Score[i] = parseint;
                    break;
                case 'D':
                    Score[i] = parseint * parseint;
                    break;
                case 'T':
                    Score[i] = parseint * parseint * parseint;
                    break;
            }


            if (strIndex.length() > 1) {
                //문자와 특수문자 분리
                char cc = strIndex.charAt(1);

                switch (cc) {
                    case '*':
                        if (i == 0) {
                            Score[i] = Score[i] * 2;

                        } else {
                            Score[i - 1] = Score[i - 1] * 2;
                            Score[i] = Score[i] * 2;
                        }
                        break;

                    case '#':
                        Score[i] = Score[i] * -1;
                        break;
                }
            }
        }

        for (int a : Score) {
            answer = answer + a;
        }
        return answer;

    }

}

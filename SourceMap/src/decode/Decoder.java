package decode;

class Decoder {
    private byte FlagChangeLine = 0;

    String WordToFinalString(String map) {
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        String PartOffArr;
        StringBuilder answer = new StringBuilder();
        String result;
        char c;
        int index;

        if ((map.charAt(map.length() - 1)) == ';') {
            map = map.substring(0, map.length() - 1);
            FlagChangeLine = 1;
        }

        for (int i = 0; i < map.length(); i++) {

            c = map.charAt(i);
            index = alphabet.indexOf(c);

            String bin_str = Integer.toBinaryString(index);

            answer.append(bin_str);
            answer.append(" ");
        }

        result = answer.toString();
        PartOffArr = CreateString(result);
        return PartOffArr;
    }

    private int[] LineToMassive(String s) {
        char[] part = s.toCharArray();
        int[] res = new int[part.length];
        for(int i = 0; i < part.length; i++) {
            res[i] = Character.getNumericValue(part[i]);
        }
        return res;
    }

    private String CreateString (String s) {
        String res;
        int[] LineField = new int[6];
        int j = 0;
        int flag = 0;
        int previousFlag = 0;
        int sign = 0;

        String[] words = s.split("\\s");

        int a = 0;
        int pow = 1;

        for(String subStr : words) {
            int[] x = LineToMassive(subStr);

            if (x[0] == 1 && x.length == 6) {
                flag = 1;
                sign = x[5];
            } else {
                flag = 0;
            }

            if (previousFlag == 1 && x.length == 6) {
                for (int i = x.length - 1; i > 0; i--) {
                    a = a + x[i] * pow;
                    pow = pow * 2;
                }
            } else if (previousFlag == 1 && x.length < 6) {
                for (int i = x.length - 1; i >= 0; i--) {
                    a = a + x[i] * pow;
                    pow = pow * 2;
                }
            } else if (previousFlag != 1 && x.length == 6) {
                for (int i = x.length - 2; i > 0; i--) {
                    a = a + x[i] * pow;
                    pow = pow * 2;
                }
                if (x[x.length - 1] == 1) {
                    sign = 1;
                }
            } else {
                for (int i = x.length - 2; i >= 0; i--) {
                    a = a + x[i] * pow;
                    pow = pow * 2;
                }
                if (x[x.length - 1] == 1) {
                    sign = 1;
                }
            }

            if (flag == 0 && sign == 1) {
                a = a * (-1);
                sign = 0;
            }

            if (flag == 1) {
                previousFlag = flag;
            } else {
                LineField[j] = a;
                a = 0;
                pow = 1;
                j++;
                previousFlag = flag;
            }
        }

        if (FlagChangeLine == 0) {
            res = "Line in: " + LineField[2] + " Column in: " + LineField[0]
                    + " Index of file: " + LineField[1] + "  "
                    + "Line out: " + LineField[2] + " Column out: " + LineField[3]
                    + " Index of name: " + LineField[4];
        }
        else {
            res = "Line in: " + LineField[0] + " Column in: " + LineField[1]
                    + "  " + LineField[2] + " Index of file: "
                    + "Line out: " + LineField[3] + " Column out: " + LineField[4]
                    + " Index of name: " + LineField[5];
            FlagChangeLine = 0;

        }

        return res;
    }
}

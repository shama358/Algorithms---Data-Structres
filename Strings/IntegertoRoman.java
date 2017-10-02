/* Question
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

class Solution {
    public String intToRoman(int num) {
        int dig = 0, n = num, len = 0;
        String[] roman = new String[]{"","I","II","III","IV","V","VI","VII",
                                      "VIII","IX","X"};
        StringBuilder rnum = new StringBuilder();
        //finding the length of num
        while(n != 0) {
            n /= 10;
            ++len;
        }
        n = num;
        //base on number system appending the roman numerals
        //starting the conversion from left -> right
        while (n != 0) {
            int div = (int)Math.pow(10, len - 1);
            dig = n / div;
            if (dig == 0) {
                -- len;
                continue;
            }
            n = n % (dig * div);
            //if the dig is in tenth place
            if (n <= 10 && len == 2) {
                if (dig < 4) {
                    for (int i = 1; i <= dig; ++i) {
                        rnum.append('X');
                    }
                } else if (dig >= 5 && dig < 9) {
                    rnum.append('L');
                    for (int i = 6; i <= dig; ++i) {
                        rnum.append('X');
                    }
                } else if (dig == 9) {
                    rnum.append("XC");
                } else {
                    rnum.append("XL");
                }
            } 
            //if the dig is in hundreth place
            else if (n <= 100 && len == 3) {
                if (dig < 4) {
                     for (int i = 1; i <= dig; ++i) {
                        rnum.append('C');
                    }
                } else if (dig >= 5 && dig < 9) {
                    rnum.append('D');
                    for (int i = 6; i <= dig; ++i) {
                        rnum.append('C');
                    }
                } else if (dig == 9) {
                    rnum.append("CM");
                } else {
                    rnum.append("CD");
                }
            } 
            //if the dig is in thousand's place
            else if (n <= 1000 && len == 4) {
                for (int i = 1; i <= dig; ++i) {
                        rnum.append('M');
                }
            } 
            //if the dig is in one's place
            else {
                rnum.append(roman[dig]);
            }
            --len;
        }
        return new String(rnum);
    }
}
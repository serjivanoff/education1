package leetcode;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight1(Integer.MIN_VALUE));
        System.out.println(hammingWeight(Integer.MIN_VALUE));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight1(int n) {
        int count = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for(char c: chars) {
            if (c == '1')
                count++;
        }
        return count;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        if (n < 0) {
            n = n ^ Integer.MIN_VALUE;
            count++;
        }
        int quotient = n;
        while (quotient >= 1) {
            int newQuotient = quotient >> 1;// 17/2 = 8
            if (newQuotient << 1 < quotient) count++;
            quotient = newQuotient;
        }
        return count;
    }

}

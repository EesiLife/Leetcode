package com.droider.interest;

/**
 * Create by siy on 20-12-30
 **/
class I001 {
    public static void main(String[] args) {
        int i = 11;
        while (true) {
            if (isD(i) && isBinary(i) && isOctal(i)) {
                break;
            }
            i += 2;
        }
        System.out.println(i);
    }

    /**
     * 如果把某个数的各个数字按相反的顺序排列，得到的数和原来的数相同，则这个数就是“回文数”。譬如 123454321 就是一个回文数。
     * 十进制,二进制,八进制(大于10)
     */
    private static boolean isBinary(int i) {
        String ori = Integer.toBinaryString(i);
        String reverse = new StringBuilder(ori).reverse().toString();
        return ori.equals(reverse);
    }

    private static boolean isOctal(int i) {
        String ori = Integer.toOctalString(i);
        String reverse = new StringBuilder(ori).reverse().toString();
        return ori.equals(reverse);
    }

    private static boolean isD(int i) {
        String ori = Integer.toString(i);
        String reverse = new StringBuilder(ori).reverse().toString();
        return ori.equals(reverse);
    }

}

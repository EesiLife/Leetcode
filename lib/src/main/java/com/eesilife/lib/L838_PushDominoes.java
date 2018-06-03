package com.eesilife.lib;

public class L838_PushDominoes {
    public String pushDominoes(String dominoes) {
        String result = "";
        char preLR = '.';
        int  preIndex = 0;
        for (int i = 0; i < dominoes.length(); i++){
            if (dominoes.charAt(i) == '.') {
                result += '.';
            } else if (dominoes.charAt(i) == 'L') {
                if (preLR == '.' || preLR == 'L') {
                    String s0 = result.substring(0, preIndex);
                    String s = result.substring(preIndex, result.length());
                    s = s.replace('.', 'L');
                    result = s0 + s + 'L';
                    preIndex = i;
                } else if (preLR == 'R'){
                    String s0 = result.substring(0, preIndex + 1);
                    String s = result.substring(preIndex + 1, result.length());
                    char[] ss = s.toCharArray();
                    for(int j = 0; j < ss.length/2 + 1; j++){
                        if (j != ss.length - 1 - j) {
                            ss[i] = 'L';
                            ss[ss.length -1 - j] = 'R';
                        }
                    }
                    s = String.valueOf(ss);
                    result = s0 + s + 'R';
                    preLR = 'R';
                    preIndex = i;

                }
            } else {
                if (preLR == '.' || preLR == 'R') {
                    String s0 = result.substring(0, preIndex + 1);
                    String s = result.substring(preIndex, result.length());
                    s = s.replace('.', 'R');
                    result = s0 + s + 'R';
                    preIndex = i;
                } else if (preLR == 'L'){
                    String s0 = result.substring(0, preIndex);
                    String s = result.substring(preIndex + 1, result.length());
                    char[] ss = s.toCharArray();
                    for(int j = 0; j < ss.length/2 + 1; j++){
                        if (j != ss.length - 1 - j) {
                            ss[i] = 'R';
                            ss[ss.length -1 - j] = 'L';
                        }
                    }
                    s = String.valueOf(ss);
                    result = s0 + s + 'L';
                    preLR = 'L';
                    preIndex = i;

                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        String dia = ".L.R...LR..L..";
        ///           LL.RR.LLRRLL..
        L838_PushDominoes c = new L838_PushDominoes();
        System.out.print(c.pushDominoes(dia));
    }
}

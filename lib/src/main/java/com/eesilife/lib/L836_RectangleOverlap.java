package com.eesilife.lib;

public class L836_RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int lenX1 = Math.abs(rec1[0] - rec1[2]);
        int lenY1 = Math.abs(rec1[1] - rec1[3]);
        int lenX2 = Math.abs(rec2[0] - rec2[2]);
        int lenY2 = Math.abs(rec2[1] - rec2[3]);
        int lenX12 = Math.abs((rec1[0] + rec1[2])/2 - (rec2[0] + rec2[2])/2);
        int lenY12 = Math.abs((rec1[1] + rec1[3])/2 - (rec2[1] + rec2[3])/2);
        return lenX12 < (lenX1 + lenX2)/2 && lenY12 < (lenY1 + lenY2) /2 ;
    }

    public boolean is(int[] rec1, int[] rec2){
        return Math.max(rec1[0],rec2[0])< Math.min(rec1[2],rec2[2])
                && Math.max(rec1[1],rec2[1])< Math. min(rec1[3],rec2[3]);
    }

    public static void main(String[] args){
//        int[] rec1 = new int[]{0,0,2,2};
//        int[] rec2 = new int[]{1,1,3,3};

//        int[] rec1 = new int[]{0,0,1,1};
//        int[] rec2 = new int[]{1,0,2,1};

        int[] rec1 = new int[]{-257926405,-680763313,702840196,454409669};
        int[] rec2 = new int[]{-275916328,-417802221,22808107,675629469};


        L836_RectangleOverlap c = new L836_RectangleOverlap();
        System.out.print(c.isRectangleOverlap(rec1, rec2));
        System.out.print(c.is(rec1, rec2));
    }
}

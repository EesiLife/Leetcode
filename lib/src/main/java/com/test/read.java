package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Create by siy on 20-10-22
 **/
public class read {
    public static void main(String[] args) {
        String srcFile = "/home/siy/opb/workSpace/LcTest/shell/2020-10-05北京移动.txt";
        readFileByLineTo_m3u(srcFile);
    }

    public static void readFileByLine(String strFile) {
        try {
            File file = new File(strFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter out = new BufferedWriter(new FileWriter("/home/siy/opb/workSpace/LcTest/shell/bjYiDong.m3u8"));
            String strLine = null;
            int lineCount = 1;
            out.write("#EXTM3U\n");
            while (null != (strLine = bufferedReader.readLine())) {
                String[] ss = strLine.split(",");
                System.out.println("#EXTINF:" + lineCount + ", " + ss[0]);
                out.write("#EXTINF:" + lineCount + ", " + ss[0] + "\n");
                System.out.println(ss[1]);
                out.write(ss[1] + "\n");
                lineCount++;
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFileByLineTo_m3u(String strFile) {
        try {
            File file = new File(strFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter out = new BufferedWriter(new FileWriter("/home/siy/opb/workSpace/LcTest/shell/bjyd.m3u"));
            String strLine = null;
            int lineCount = 1;
            out.write("#EXTM3U name=\"北京联通IPTV(RTP)”\n");
            while (null != (strLine = bufferedReader.readLine())) {
                String[] ss = strLine.split(",");
                System.out.println("#EXTINF:-1," + ss[0] + "(" + lineCount + ")");
                out.write("#EXTINF:-1," + ss[0] + "(" + lineCount + ")" + "\n");
                System.out.println(ss[1].replace("/1.m3u8",""));
                out.write(ss[1].replace("/1.m3u8","") + "\n");
                lineCount++;
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
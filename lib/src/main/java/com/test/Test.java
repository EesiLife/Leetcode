package com.test;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        handleData();
    }

    private static void handleData() {
        String mPath = "/Users/sy/Documents/zlog/log/log1-checkurl.txt";
        String newPath = "/Users/sy/Documents/zlog/log/log1-checkurl-resule.txt";
        List<String> mList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            File mFile = new File(mPath);
            reader = new BufferedReader(new FileReader(mFile));
            String line;
            String time = null;
            String preLine = null;
            while ((line = reader.readLine()) != null) {
//                if (preLine != null && (
//                        (preLine.contains("checkUrl url") && line.contains("checkUrl url"))
//                        || (preLine.contains("checkUrl list url") && line.contains("checkUrl list url")))) {
//                    mList.remove(mList.size() -1);
//                    preLine = line;
//                    continue;
//                }
//                preLine = line;
                try {
                    String[] arr = line.split(" ");
                    time = arr[1];
                } catch (Throwable e) {e.printStackTrace();}
                mList.add(time);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            closeQuietly(reader);
        }

        //
        if (mList.size() > 0) {
            int total = 0;
            int len  = mList.size();
            List<String> result = new ArrayList<>();
            String start, end ;
            int cost = 0;
            int time = 0;
            int j = 0;
            for (int i = 1; i < len; i= i + 2) {
                start = mList.get(i - 1);
                end = mList.get(i);
                try {
                    int start_time = Integer.parseInt(start.split("\\.")[1]);
                    int end_time = Integer.parseInt(end.split("\\.")[1]);
                    if (end_time < start_time) end_time += 1000;
                    cost = Math.abs(end_time - start_time);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                total += cost;
                time++;
                j++;
                result.add("start:" + mList.get(i - 1)  + ";end:" + mList.get(i) + ";cost:" + String.valueOf(cost));
                System.out.println("第"+ j +"次 列表遍历开始开始时间:" + mList.get(i - 1)  + " 结束时间:" + mList.get(i) + " 耗时:" + String.valueOf(cost));
            }
            result.add("cost:" + String.valueOf(cost));
            BigDecimal aver = new BigDecimal(total / time);
            System.out.println("总耗时:" + total + "ms 次数:" + time + " 平均耗时:" + formatToNumber(aver) + "ms");
        } else {
            System.out.println("数据解析失败");
        }
    }

    private static void readUrl() {
        String mPath = "/Volumes/macDisk/opb/sandbox/clienturllit-ori";
        String newPath = "/Volumes/macDisk/opb/sandbox/clienturllit";
        Set<String> mSet;
        mSet = new HashSet<>();
        BufferedReader reader = null;
        try {
            File mFile = new File(mPath);
            reader = new BufferedReader(new FileReader(mFile));
            String line = null;
            while ((line = reader.readLine()) != null) {
                mSet.add(line);
                for (int i = 0; i < 10; i++) {
                    if (mSet.size() > 990) continue;
                    mSet.add(line + String.valueOf(i));
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            closeQuietly(reader);
        }
        saveUrlList(mSet, newPath);
    }

    private static int saveUrlList(Set<String> list, String path) {
        BufferedWriter writer = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(path, false);
            writer = new BufferedWriter(fw);
            for (String str: list) {
                writer.write(str);
                writer.newLine();
            }
            writer.flush();
            return 0;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            closeQuietly(fw);
            closeQuietly(writer);
        }
        return -1;
    }
    public static void closeQuietly(Closeable c) {
        if (null != c) {
            try { c.close(); } catch (Throwable ignored) {}
        }
    }

    /**
     * @desc 1.0~1之间的BigDecimal小数，格式化后失去前面的0,则前面直接加上0。
     * 2.传入的参数等于0，则直接返回字符串"0.00"
     * 3.大于1的小数，直接格式化返回字符串
     * @param obj 传入的小数
     * @return
     */
    public static String formatToNumber(BigDecimal obj) {
        DecimalFormat df = new DecimalFormat("#.00");
        if(obj.compareTo(BigDecimal.ZERO)==0) {
            return "0.00";
        }else if(obj.compareTo(BigDecimal.ZERO)>0&&obj.compareTo(new BigDecimal(1))<0){
            return "0"+df.format(obj).toString();
        }else {
            return df.format(obj).toString();
        }
    }
}

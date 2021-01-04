package com.example.manifest.util;

import java.util.ArrayList;

public class Utils {
    public static byte[] copyByte(byte[] src, int start, int size) {
        byte[] ret = new byte[size];
        for (int i = size + start - 1; i >= start; i--) {
            ret[size + start - i - 1] = src[i];
        }
        return ret;
    }

    public static byte[] copyByte1(byte[] src, int start, int size) {
        byte[] ret = new byte[size];
        for (int i = 0; i < size; i++) {
            ret[i] = src[start + i];
        }
        return ret;
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String byteToHexString(byte... bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];

        targets[0] = (byte) (res & 0xff);// 最低位
        targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
        targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }

    public static int byte2int(byte[] bytes) {
        int value = 0;
        // 由高位到低位
        if (bytes.length < 4) {
            int index = 4 - bytes.length;
            byte[] newBytes = new byte[4];
            for (int i = 0; i < 4; i++) {
                if (i < index) {
                    newBytes[i] = 0;
                } else {
                    newBytes[i] = bytes[i - index];
                }
            }
            return byte2int(newBytes);
        }
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (bytes[i] & 0x000000FF) << shift;// 往高位游
        }
        return value;
    }

    public static short[] toShortArray(byte[] src) {

        int count = src.length >> 1;
        short[] dest = new short[count];
        for (int i = 0; i < count; i++) {
            dest[i] = (short) (src[i * 2] << 8 | src[2 * i + 1] & 0xff);
        }
        return dest;
    }

    public static int byte2short(byte[] src) {

        int count = src.length >> 1;
        return count;
    }

    public static char byteToChar(byte[] b) {
        char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
        return c;
    }

    public static String filterStringNull(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        byte[] strByte = str.getBytes();
        ArrayList<Byte> newByte = new ArrayList<>();
        for (int i = 0; i < strByte.length; i++) {
            if (strByte[i] != 0) {
                newByte.add(strByte[i]);
            }
        }
        byte[] newByteAry = new byte[newByte.size()];
        for (int i = 0; i < newByteAry.length; i++) {
            newByteAry[i] = newByte.get(i);
        }
        return new String(newByteAry);
    }

}

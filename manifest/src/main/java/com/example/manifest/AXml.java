package com.example.manifest;

import com.example.manifest.util.Utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class AXml {
    private static final String in = "/home/siy/opb/workSpace/LcTest/shell/AndroidManifest.xml";

    private static byte[] byteSrc;
    private static FileInputStream fis = null;
    private static ByteArrayOutputStream bos = null;


    public static void main(String[] args) {
        try {
            fis = new FileInputStream(in);
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            byteSrc = bos.toByteArray();
            //1.parseHeader
            parseXmlHeader(byteSrc);
            parseStringChunk(byteSrc);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fis) fis.close();
                if (null != bos) bos.close();
            } catch (Throwable e) {

            }
        }
    }

    private static void parseXmlHeader(byte[] byteSrc) {
        byte[] xmlMagic = Utils.copyByte(byteSrc, 0, 4);
        System.out.println("magic number      :" + Utils.byteToHexString(xmlMagic));
        byte[] xmlSize = Utils.copyByte(byteSrc, 4, 4);
        System.out.println("xml size          :" + Utils.byteToHexString(xmlSize));
        System.out.println("xml size          :" + Utils.byte2int(xmlSize));
    }

    private static final int stringChunkOffset = 8;
    private static final int stringChunkSizeOffset = 12;
    private static final int stringCountOffset = 16;
    private static final int styleCountOffset = 20;
    private static final int unknownOffset = 24;
    private static final int stringPoolOffset = 28;
    private static final int stylePoolOffset = 32;
    private static final int stingOffsetsOffset = 36;
    private static final int styleOffsetsOffset = 0;
    private static List<String> stringContentList;
    private static List<Integer> stringContentOffsetList;
    private static int resourceChunkOffset;

    //0x00000024位置开始
    private static void parseStringOffset(int size) {
        int start = 0x00000024;
        stringContentOffsetList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            byte[] chunkTagByte = Utils.copyByte(byteSrc, start, 4);
            String hexString = Utils.byteToHexString(chunkTagByte);
            int val = Utils.byte2int(chunkTagByte);
            System.out.println("i:" + i + ";hexStr:" + hexString + ";val:" + val);
            stringContentOffsetList.add(val);
            start += 4;
        }
    }

    private static void parseStringContentList(int start) {
        for (int i = 0; i < stringContentOffsetList.size(); i++) {
            int localStart = start + stringContentOffsetList.get(i);
            //当前字符串的长度
            byte[] stringSize = Utils.copyByte(byteSrc, localStart, 2);
            int size = Utils.byte2int(stringSize);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                localStart += 2;
                sb.append(Utils.byteToChar(Utils.copyByte(byteSrc, localStart, 2)));
            }
            System.out.println("parseStringContentList i:" + i + ";Str:" + sb.toString());
        }
    }

    private static void parseStringChunk(byte[] byteSrc) {
        //String Chunk的标识:stringChunk的类型,固定4个字节:0x001C0001
        byte[] chunkTagByte = Utils.copyByte(byteSrc, stringChunkOffset, 4);
        System.out.println("string chunkTag   :" + Utils.byteToHexString(chunkTagByte));
        //ChunkSize
        byte[] chunkSizeByte = Utils.copyByte(byteSrc, stringChunkSizeOffset, 4);
        System.out.println("string chunkSize  :" + Utils.byteToHexString(chunkSizeByte));
        int chunkSize = Utils.byte2int(chunkSizeByte);
        System.out.println("chunkSize int     :" + chunkSize);
        //stringCount
        byte[] stringCount = Utils.copyByte(byteSrc, stringCountOffset, 4);
        System.out.println("stringCount       :" + Utils.byteToHexString(stringCount));
        int chunkStringCount = Utils.byte2int(stringCount);
        System.out.println("chunkStringCount  :" + chunkStringCount);
        parseStringOffset(chunkStringCount);
//        //styleCount ignore
//        byte[] styleCount = Utils.copyByte(byteSrc, styleCountOffset, 4);
//        System.out.println("styleCount        :" + Utils.byteToHexString(styleCount));
//        //unknown ignore
//        byte[] unknown = Utils.copyByte(byteSrc, unknownOffset, 4);
//        System.out.println("unknown           :" + Utils.byteToHexString(unknown));
        //stringPoolOffset
        stringContentList = new ArrayList<>(chunkStringCount);
        byte[] chunkStringOffsetByte = Utils.copyByte(byteSrc, stringPoolOffset, 4);
        System.out.println("chunkStringOffsetByte  :" + Utils.byteToHexString(chunkStringOffsetByte));
        int stringContentStart = 8 + Utils.byte2int(chunkStringOffsetByte);
        System.out.println("stringContentStart:" + stringContentStart);
        parseStringContentList(stringContentStart);
        //string content
        byte[] chunkStringContentByte = Utils.copyByte1(byteSrc, stringContentStart, chunkSize);
        System.out.println("chunkStringContentByte:" + Utils.byteToHexString(chunkStringContentByte));
        /* 解析字符串时有个问题，就是编码，:UTF-8和UTF-16,如果UTF-8则以00结尾;如果是UTF-16则以00 00结尾。
         * 此处代码是用来解析AndroidManifest.xml文件的.
         * 这里的格式是：偏移值开始的两个字节是字符串的长度，接着是字符串的内容，后面跟着两个字符串的结束符00*/
        byte[] firstStringSizeByte = Utils.copyByte(chunkStringContentByte, 0, 2);
        System.out.println("firstStringSizeByte:" + Utils.byteToHexString(firstStringSizeByte));
        int firstStringSize = Utils.byte2short(firstStringSizeByte) * 2;
        System.out.println("size:" + firstStringSize);
        byte[] firstStringContentByte = Utils.copyByte(chunkStringContentByte, 2, firstStringSize + 2);
        String firstStringContent = new String(firstStringContentByte);
        stringContentList.add(Utils.filterStringNull(firstStringContent));
        System.out.println("first string:" + Utils.filterStringNull(firstStringContent));

        //将字符串都放到ArrayList中
        int endStringIndex = 2 + firstStringSize + 2;
        while (stringContentList.size() < chunkStringCount) {
            //一个字符对应两个字节，所以要乘以2
            int stringSize = Utils.byte2short(
                    Utils.copyByte(chunkStringContentByte, endStringIndex, 2)
            ) * 2;
            String str = new String(Utils.copyByte(
                    chunkStringContentByte, endStringIndex + 2, stringSize + 2
            ));
            System.out.println("str:" + Utils.filterStringNull(str));
            stringContentList.add(Utils.filterStringNull(str));
            endStringIndex += (2 + stringSize + 2);
            resourceChunkOffset = stringChunkOffset + Utils.byte2int(chunkSizeByte);
        }
    }

}

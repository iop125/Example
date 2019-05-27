package com.example.javaex.javaex.dataStructure.tree.huffmanTree.huffmanCode;

import java.io.*;
import java.util.Map;

/**
 * 赫夫曼编码
 */

public class HuffmanCodeForFile {

    public static void main(String[] a) throws Exception {
        String filePath = "/Users/miaoyu1/Downloads/1.rtf";
        String dir = "/Users/miaoyu1/Downloads/1.zip";
        String dir1 = "/Users/miaoyu1/Downloads/2.rtf";
        zipFile(filePath, dir);
        uzipFile(dir, dir1);
    }

    public static void zipFile(String filePath, String dir) throws Exception {
        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream(filePath);
        byte[] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);
        fileInputStream.close();
        byte[] b1 = HuffmanCodeForString.huffmanCode(b);
        System.out.println(b1.length);
        System.out.println(b.length);
        Map<Byte, String> map = HuffmanCodeForString.huffmanCode;
        OutputStream ops = new FileOutputStream(dir);
        ObjectOutputStream oops = new ObjectOutputStream(ops);
        oops.writeObject(b1);
        oops.writeObject(map);
        oops.close();
        ops.close();
    }
    public static void uzipFile(String filePath, String dir) throws Exception {
        FileInputStream fileInputStream =  new FileInputStream(filePath);
        //读取byte 数组
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        byte[] b = (byte[])objectInputStream.readObject();

        //读取赫夫曼编码
        Map<Byte, String> map = (Map<Byte, String>)objectInputStream.readObject();
//        fileInputStream.read(b);
        fileInputStream.close();
        byte[] b1 = HuffmanCodeForString.getOld(map,b);
        OutputStream ops = new FileOutputStream(dir);
        ObjectOutputStream oops = new ObjectOutputStream(ops);
        oops.writeObject(b1);
//        oops.writeObject(map);
        oops.close();
        ops.close();
    }

}

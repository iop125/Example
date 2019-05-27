package com.example.javaex.javaex.dataStructure.tree.huffmanTree.huffmanCode;

import java.util.*;

/**
 * 赫夫曼编码
 */

public class HuffmanCodeForString {

    public static void main(String[] a) {
        String msg = "can you can a can as a can canner can a can";
        byte[] bytes = msg.getBytes();
        //进行霍夫曼编码
        byte[] b = huffmanCode(bytes);
        System.out.println(bytes.length);
        System.out.println(b.length);
        System.out.println( getOld(huffmanCode, b).equalsIgnoreCase(msg));
    }

    public static byte[] huffmanCode(byte[] array) {
        //统计每一个byte出现的次数并放在集合中
        List<HuffmanCodeNode> nodes = getNodes(array);
        //创建一个霍夫曼树
        HuffmanCodeNode m = createHuffmanTree(nodes);
        System.out.println(m);
        //创建霍夫曼树编码表
        Map<Byte, String> mapCode = huffmanCodeTable(m);
        System.out.println(mapCode);
        //编码
        byte[] returnByte = zip(mapCode, array);
        return returnByte;
    }

    public static List<HuffmanCodeNode> getNodes(byte[] array) {
        //统计每一个byte出现的次数并放在集合中
        List<HuffmanCodeNode> list = new ArrayList<HuffmanCodeNode>();
        //统计每一个byte 出现的次数
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        for (byte b : array) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {

            HuffmanCodeNode m = new HuffmanCodeNode(entry.getKey(), entry.getValue());
            list.add(m);
        }
        return list;
    }

    public static HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> nodes) {
        //排序
        Collections.sort(nodes);
        while (nodes.size() > 1) {
            //排序--
            Collections.sort(nodes);
            //取出来权值最小的两个二叉树
            HuffmanCodeNode rootL = nodes.get(nodes.size() - 1);
            HuffmanCodeNode rootR = nodes.get(nodes.size() - 2);
            //创建一个新的二叉树
            HuffmanCodeNode p = new HuffmanCodeNode(null, rootL.weight + rootR.weight);
            p.leftNode = rootL;
            p.rightNode = rootR;
            //把取出来的二叉树移除
            nodes.remove(rootL);
            nodes.remove(rootR);
            //放入原来的二叉树集合中
            nodes.add(p);
        }
        return nodes.get(0);
    }

    //临时存储路径
    static StringBuffer sb = new StringBuffer();

    //存储赫夫曼编码
    static Map<Byte, String> huffmanCode = new HashMap<>();

    public static Map<Byte, String> huffmanCodeTable(HuffmanCodeNode tree) {
        //遍历树
        if (tree == null) {
            return null;
        }
        getCodes(tree.leftNode, "0", sb);
        getCodes(tree.rightNode, "1", sb);
        return huffmanCode;
    }

    public static void getCodes(HuffmanCodeNode node, String code, StringBuffer sb) {
        StringBuffer sb2 = new StringBuffer(sb);
        sb2.append(code);
        if (node.data == null) {
            getCodes(node.leftNode, "0", sb2);
            getCodes(node.rightNode, "1", sb2);
        } else {
            huffmanCode.put(node.data, sb2.toString());
        }
    }

    public static byte[] zip(Map<Byte, String> mapCode, byte[] array) {
        //需要压缩的数组变成一个二进制的
        StringBuffer sb = new StringBuffer();
        for (byte b : array) {
            sb.append(mapCode.get(b));
        }
        System.out.println(sb);
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        byte[] returnByte = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(strByte, 2);
            returnByte[index] = byt;
            index++;
        }
        return returnByte;
    }

    /**
     * 解码字符串
     *
     * @param mapCode
     * @param array
     * @return
     */
    public static String getOld(Map<Byte, String> mapCode, byte[] array) {
        StringBuffer sb = new StringBuffer();
        List<Byte> list = new ArrayList<>();
        //变成原来的二进制字符串
        for (int i = 0; i < array.length; i++) {
            sb.append(byteToString(!(i == array.length - 1), array[i]));
        }
        //按照赫夫曼编码进行处理
        //把赫夫曼编码的键值对调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> en : mapCode.entrySet()) {
            map.put(en.getValue(), en.getKey());
        }
        //截取字符作为key到map中获取value
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                String key = sb.substring(i, count + i);
                Byte b = map.get(key);
                if (b != null) {
                    list.add(map.get(key));
                    flag = false;
                }else{
                    count++;
                }
            }
            i = count + i;
        }
        //没有长度无法定义数据  所以要通过list来转换
        byte[] returnByte = new byte[list.size()];
        for(int i =0;i<list.size();i++){
            returnByte[i] = list.get(i);
        }
        return new String(returnByte);

    }

    public static String byteToString(boolean flag, byte b) {
        String str;
        int tpm = b;
        if (flag) {
            tpm |= 256;
        }
        str = Integer.toBinaryString(tpm);
        return !flag ? str : str.substring(str.length() - 8);
    }
}

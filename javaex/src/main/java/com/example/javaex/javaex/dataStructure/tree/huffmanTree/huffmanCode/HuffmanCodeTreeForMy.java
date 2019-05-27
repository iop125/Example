//package com.example.javaex.javaex.dataStructure.tree.huffmanTree.huffmanCode;
//
//import java.util.*;
//
//public class HuffmanCodeTreeForMy {
//
//
//    public static byte[] huffmanCode(byte[] array) {
//        //统计每一个byte出现的次数并放在集合中
//        List<HuffmanCodeNode> nodes = getNodes(array);
//        //创建一个霍夫曼树
//        HuffmanCodeNode m = createHuffmanTree(nodes);
//        System.out.println(m);
//        //创建霍夫曼树编码表
//        Map<Byte, String> mapCode = huffmanCodeTable(m);
//        System.out.println(mapCode);
//        //编码
//        byte[] returnByte = zip(mapCode, array);
//        return returnByte;
//    }
//
//    public static List<HuffmanCodeNode> getNodes(byte[] array) {
//        //统计每一个byte出现的次数并放在集合中
//        List<HuffmanCodeNode> list = new ArrayList<HuffmanCodeNode>();
//        //统计每一个byte 出现的次数
//        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
//        for (byte b : array) {
//            Integer count = map.get(b);
//            if (count == null) {
//                map.put(b, 1);
//            } else {
//                map.put(b, count + 1);
//            }
//        }
//        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
//
//            HuffmanCodeNode m = new HuffmanCodeNode(entry.getKey(), entry.getValue());
//            list.add(m);
//        }
//        return list;
//    }
//
//    public static HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> nodes) {
//        //排序
//        Collections.sort(nodes);
//        while (nodes.size() > 1) {
//            //排序--
//            Collections.sort(nodes);
//            //取出来权值最小的两个二叉树
//            HuffmanCodeNode rootL = nodes.get(nodes.size() - 1);
//            HuffmanCodeNode rootR = nodes.get(nodes.size() - 2);
//            //创建一个新的二叉树
//            HuffmanCodeNode p = new HuffmanCodeNode(null, rootL.weight + rootR.weight);
//            p.leftNode = rootL;
//            p.rightNode = rootR;
//            //把取出来的二叉树移除
//            nodes.remove(rootL);
//            nodes.remove(rootR);
//            //放入原来的二叉树集合中
//            nodes.add(p);
//        }
//        return nodes.get(0);
//    }
//
//    //临时存储路径
//    static StringBuffer sb = new StringBuffer();
//
//    //存储赫夫曼编码
//    static Map<Byte, String> huffmanCode = new HashMap<>();
//
//    public static Map<Byte, String> huffmanCodeTable(HuffmanCodeNode tree) {
//        //遍历树
//        if (tree == null) {
//            return null;
//        }
//        getCodes(tree.leftNode, "0", sb);
//        getCodes(tree.rightNode, "1", sb);
//        return huffmanCode;
//    }
//
//    public static void getCodes(HuffmanCodeNode node, String code, StringBuffer sb) {
//        StringBuffer sb2 = new StringBuffer(sb);
//        sb2.append(code);
//        if (node.data == null) {
//            getCodes(node.leftNode, "0", sb2);
//            getCodes(node.rightNode, "1", sb2);
//        } else {
//            huffmanCode.put(node.data, sb2.toString());
//        }
//    }
//
//    public static byte[] zip(Map<Byte, String> mapCode, byte[] array) {
//        //需要压缩的数组变成一个二进制的
//        StringBuffer sb = new StringBuffer();
//        for (byte b : array) {
//            sb.append(mapCode.get(b));
//        }
//        System.out.println(sb);
//        int len;
//        if (sb.length() % 8 == 0) {
//            len = sb.length() / 8;
//        } else {
//            len = sb.length() / 8 + 1;
//
//        }
//        byte[] returnByte = new byte[len];
//        int index = 0;
//        for (int i = 0; i < sb.length(); i += 8) {
//
//            String strByte;
//            if (i + 8 > sb.length()) {
//                strByte = sb.substring(i);
//            } else {
//                strByte = sb.substring(i, i + 8);
//            }
//            byte byt = (byte) Integer.parseInt(strByte, 2);
//            returnByte[index] = byt;
//            index++;
//        }
//        return returnByte;
//    }
//
//    public static void main(String[] a) {
//        String msg = "can you can a can as a can canner can a can";
//        byte[] bytes = msg.getBytes();
//        System.out.println(bytes.length);
//        //进行霍夫曼编码
////        byte[] b = huffmanCode(bytes);
////        System.out.println(b.length);
//        byte[] myb = huffmanCodeForMy(bytes);
//        System.out.println(myb.length);
//    }
//
//    public static byte[] huffmanCodeForMy(byte[] array) {
//        //将字符串转换成字节数组 并构建节点放到集合中
//        List<HuffmanCodeNode> list = getNodesForMy(array);
//        //创建一个赫夫曼树
//        HuffmanCodeNode hcn = getHuffmanTreeForMy(list);
//        //获取赫夫曼树编码
//        Map<Byte, String> map = getHuffmanCodeForMy(hcn);
//        //转换成新的byte
//        byte[] returnb = zipForMy(map, array);
//        return returnb;
//    }
//
//    public static List<HuffmanCodeNode> getNodesForMy(byte[] array) {
//        List<HuffmanCodeNode> list = new ArrayList<>();
//        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
//
//        for (byte b : array) {
//            if (map.get(b) == null) {
//                map.put(b, 1);
//            } else {
//                map.put(b, map.get(b) + 1);
//            }
//        }
//        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
//            HuffmanCodeNode hcm
//                    = new HuffmanCodeNode(entry.getKey(), entry.getValue());
//            list.add(hcm);
//        }
//        return list;
//    }
//
//    public static HuffmanCodeNode getHuffmanTreeForMy(List<HuffmanCodeNode> array) {
//        while (array.size() > 1) {
//            //先排序 倒叙。。。
//            Collections.sort(array);
//            HuffmanCodeNode lNode = array.get(array.size() - 1);
//            HuffmanCodeNode rNode = array.get(array.size() - 2);
//            HuffmanCodeNode p = new HuffmanCodeNode(null, lNode.weight + rNode.weight);
//            p.leftNode=lNode;
//            p.rightNode =rNode;
//            array.remove(lNode);
//            array.remove(rNode);
//            array.add(p);
//        }
//        return array.get(0);
//    }
//
//    //lin
//    static StringBuffer sbmy = new StringBuffer();
//    static Map<Byte, String> mapmy = new HashMap<>();
//
//    public static Map<Byte, String> getHuffmanCodeForMy(HuffmanCodeNode node) {
//        if (node == null) {
//            return null;
//        }
//        getCodemy(node.leftNode, "0", sbmy);
//        getCodemy(node.rightNode, "1", sbmy);
//        return mapmy;
//    }
//
//    public static void getCodemy(HuffmanCodeNode node, String code, StringBuffer sb) {
//        StringBuffer sb2 = new StringBuffer(sb);
//        sb2.append(code);
//        if (node.data == null) {
//            getCodemy(node.leftNode, "0", sb2);
//            getCodemy(node.rightNode, "1", sb2);
//        } else {
//            mapmy.put(node.data, sb2.toString());
//        }
//    }
//
//    public static byte[] zipForMy(Map<Byte, String> mapCode, byte[] array) {
//        //需要压缩的数组变成一个二进制的
//        StringBuffer sb = new StringBuffer();
//        for (byte b : array) {
//            sb.append(mapCode.get(b));
//        }
//        byte[] returnByte = new byte[sb.length() % 8 == 0 ? sb.length() / 8 : sb.length() / 8 + 1];
//        int index = 0;
//        for (int i = 0; i < sb.length(); i += 8) {
//            String sss;
//            if (i + 8 > sb.length()) {
//                sss = sb.substring(i);
//            } else {
//                sss = sb.substring(i,i+8);
//            }
//            returnByte[index] = (byte) Integer.parseInt(sss, 2);
//            index++;
//        }
//        return returnByte;
//    }
//}

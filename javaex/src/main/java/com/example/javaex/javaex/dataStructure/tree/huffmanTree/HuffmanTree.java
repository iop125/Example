package com.example.javaex.javaex.dataStructure.tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树  “最优二叉树”
 * 路径：在一棵树中，一个结点到另一个结点之间的通路，称为路径。图 1 中，从根结点到结点 a 之间的通路就是一条路径。
 * <p>
 * 路径长度：在一条路径中，每经过一个结点，路径长度都要加 1 。
 * 例如在一棵树中，规定根结点所在层数为1层，那么从根结点到第 i 层结点的路径长度为 i - 1 。图 1 中从根结点到结点 c 的路径长度为 3。
 * <p>
 * 结点的权：给每一个结点赋予一个新的数值，被称为这个结点的权。例如，图 1 中结点 a 的权为 7，结点 b 的权为 5。
 * <p>
 * 结点的带权路径长度（wpl）：指的是从根结点到该结点之间的路径长度与该结点的权的乘积。例如，图 1 中结点 b 的带权路径长度为 2 * 5 = 10 。
 * 结点是指叶子结点
 * <p>
 * <p>
 * 当用 n 个结点（都做叶子结点且都有各自的权值）试图构建一棵树时，如果构建的这棵树的带权路径长度最小，称这棵树为“最优二叉树”，有时也叫“赫夫曼树”或者“哈夫曼树”。
 * <p>
 * 在构建哈弗曼树时，要使树的带权路径长度最小，只需要遵循一个原则，那就是：权重越大的结点离树根越近。在图 1 中，因为结点 a 的权值最大，所以理应直接作为根结点的孩子结点。
 */
public class HuffmanTree {

    public HufffmanNode hufffmanNode;

    /**
     * 1.在 n 个权值中选出两个最小的权值，对应的两个结点组成一个新的二叉树，且新二叉树的根结点的权值为左右孩子权值的和；
     * 2.在原有的 n 个权值中删除那两个最小的权值，同时将新的权值加入到 n–2 个权值的行列中，以此类推；
     * 3.重复 1 和 2 ，直到所以的结点构建成了一棵二叉树为止，这棵树就是哈夫曼树。
     *
     * @param array
     */
    public static HufffmanNode init(int[] array) {

        //先使用数组中所有的元素创建若干个二叉树，(z只有一个节点)
        List<HufffmanNode> nodes = new ArrayList<HufffmanNode>();
        for (int att : array) {
            nodes.add(new HufffmanNode(att));
        }
        while (nodes.size() > 1) {
            //排序--
            Collections.sort(nodes);
            //取出来权值最小的两个二叉树
            HufffmanNode rootL = nodes.get(nodes.size() - 1);
            HufffmanNode rootR = nodes.get(nodes.size() - 2);
            //创建一个新的二叉树
            HufffmanNode p = new HufffmanNode(rootL.value + rootR.value);
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

    public int[] huffmanCode(int[] array) {
        return null;
    }

}

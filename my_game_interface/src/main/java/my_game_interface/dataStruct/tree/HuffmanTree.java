package my_game_interface.dataStruct.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int [] arr ={13,7,8,3,29,6,1};
        Node huffmanTree = createHuffmanTree(arr);
        preOrder(huffmanTree);
    }
    public static Node createHuffmanTree(int [] arr){
        List<Node> nodes =new ArrayList<>();
        for (int val : arr){
            nodes.add(new Node(val));
        }
        while (nodes.size() > 1) {
            //  对节点的权值进行排序
            Collections.sort(nodes);
            //  取出最小的元素
            Node letNode = nodes.get(0);
            //  取出次小的元素
            Node rightNode = nodes.get(1);
            //  构建一个新的二叉树
            Node prent = new Node(letNode.getValue() + rightNode.getValue());
            prent.setLeft(letNode);
            prent.setRight(rightNode);
            //  从集合中删除处理过的二叉树
            nodes.remove(letNode);
            nodes.remove(rightNode);
            //  将prent加入集合
            nodes.add(prent);
        }
        return nodes.get(0);
    }
    public static  void preOrder(Node node){
        if (node != null){
            node.preOrder();
        }else {
            System.out.println("空");
        }
    }
}

class Node implements Comparable<Node>{
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.getRight() != null){
            this.right.preOrder();
        }
    }
    @Override
    public int compareTo(Node o) {
        //  从小到大排序
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

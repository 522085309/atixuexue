package my_game_interface.dataStruct.serach;

/**
 * 二叉查找树
 */
public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        int [] arr = {7,3,10,12,5,1,9,2};
        BinartSearchTree binartSearchTree = new BinartSearchTree();
        for (int i = 0 ;i < arr.length;i++) {
            binartSearchTree.add(new Node(arr[i]));
        }
        System.out.println("完整的二叉查找树");
        binartSearchTree.infixOrder();
        System.out.println("删除节点后的二叉查找树");
        binartSearchTree.delNode(7);
        binartSearchTree.infixOrder();
    }
}

/**
 * 创建二叉查找树
 */
class BinartSearchTree{
    private Node root;

    /**
     * 添加元素
     */
    public  void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("空");
        }
    }
    /**
     * 查找要删除的元素
     */
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }
    /**
     * 查找要删除元素的父节点
     */
    public Node searchPrent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchPrent(value);
        }
    }
    /**
     *  以传入节点为根节点，得到的最小值
     */
    public int delLeftMin(Node node){
        Node temp = node;
        while (temp.left != null){
            temp = temp.left;
        }
        delNode(temp.value);
        return temp.value;
    }
    /**
     * 删除节点
     */
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            //  找到要删除的元素
            Node target = search(value);
            if (target == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //  找到待删除节点的父节点
            Node prent = searchPrent(value);
            //  如果删除的节点是叶子节点
            if (target.left == null && target.right == null) {
                //  如果删除的节点是父节点的左子节点
                if (prent.left != null){
                    if (prent.left.value == value){
                        prent.left = null;
                    }
                } else {
                    if (prent.right != null){
                        if (prent.right.value == value){
                            prent.right = null;
                        }
                    }
                }
                //  如果删除的节点有两个子节点
            } else if (target.left != null && target.right != null) {
                //  将待删除节点的右子节点传进入，得到最小的节点的值(此最小值的范围在待删除节点和待删除节点的的右子树之间)
                int min = delLeftMin(target.right);
                target.value = min;
                //  如果删除的节点只有一个子节点
            } else {
                //  如果删除的节点的左子节点不为空，就将待删除节点的父节点指向待删除节点的左子节点
                if (target.left != null) {
                    if (prent != null) {
                        if (prent.left.value == value) {
                            prent.left = target.left;
                        } else {
                            prent.right = target.left;
                        }
                    }else {
                        root = target.left;
                    }
                } else if (target.right != null) {
                    if (prent != null) {
                        if (prent.left.value == value) {
                            prent.left = target.right;
                        } else {
                            prent.right = target.right;
                        }
                    }else {
                        root = target.right;
                    }
                }
            }
        }
    }
}

/**
 * 创建Node节点
 */
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    /**
     * 查找要删除接的父节点
     */
    public Node searchPrent(int value){
        //  如果当前节点的左子节点 或者右子节点等于要删除的值，则此节点就是要删除的节点的父节点
        if ((this.left != null  && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            //  如果要删除的节点小于当前节点，向左递归
            if (this.left != null && this.value > value){
                return this.left.searchPrent(value);
                //  如果要删除的节点大于当前节点，向右递归
            }else if (this.right != null && this.value <= value){
                return this.right.searchPrent(value);
            }else {
                return null;
            }
        }
    }
    /**
     *查找要删除的节点
     */
    public Node search(int value){
        if (this.value == value){
            return this;
            //  如果要删除的节点的值小于此节点，向左递归查找
        }else if (this.value > value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }
    /**
     * 添加元素
     */
    public void add(Node node){
        if (node == null){
            return;
        }
        //  说明根节点大于待添加节点的值
        if (this.value > node.value){
            //  如果左子节点为空，就将带插入的值添加于此，否则左子节点递归添加
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }
    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

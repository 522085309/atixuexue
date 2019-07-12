package my_game_interface.dataStruct.tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int [] arr = {4,3,6,5,7,8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0;i < arr.length ; i++){
            avlTree.add(new Node1(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println(arr);
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());

    }
}
class AVLTree {
    private Node1 root;

    public Node1 getRoot() {
        return root;
    }

    /**
     * 添加元素
     */
    public  void add(Node1 node){
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
    public Node1 search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }
    /**
     * 查找要删除元素的父节点
     */
    public Node1 searchPrent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchPrent(value);
        }
    }
    /**
     *  以传入节点为根节点，得到的最小值
     */
    public int delLeftMin(Node1 node){
        Node1 temp = node;
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
            Node1 target = search(value);
            if (target == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //  找到待删除节点的父节点
            Node1 prent = searchPrent(value);
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
class Node1{
    int value;
    Node1 left;
    Node1 right;

    public Node1(int value) {
        this.value = value;
    }

    /**
     * 左旋转
     */
    public void leftRotate(){
        //
        Node1 node =new Node1(value);
        //  把新的节点的左子树设置为当前节点的左子树
        node.left = left;
        //  把当前节点的右子树，设置成当前节点右子树的左子树
        node.right = right.left;
        //  把当前节点的值替换成右子节点的值
        value = right.value;
        //  把当前节点的右子树设置成当前节点右子树的右子树
        right = right.right;
        //  把当前节点的左子节点设置为新创建的字节
        left = node;
    }
    public Node1 searchPrent(int value){
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
     * 返回左子树的高度
     * @return
     */
    public int leftHeight(){
        if (left == null)
            return 0;
        return left.height();
    }

    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight(){
        if (right == null)
            return 0;
        return right.height();
    }

    /**
     * 返回以当前节点为根节点的树的高度
     * @return
     */
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) +1 ;
    }

    /**
     *查找要删除的节点
     */
    public Node1 search(int value){
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
    public void add(Node1 node){
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
        if (rightHeight() - leftHeight() > 1 ){
            leftRotate();
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
        return "Node1{" +
                "value=" + value +
                '}';
    }
}

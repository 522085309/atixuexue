package my_game_interface.dataStruct.tree.threaded;

public class ThreadedBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(3,"吴用");
        HeroNode node3 = new HeroNode(6,"林冲");
        HeroNode node4 = new HeroNode(8,"关胜");
        HeroNode node5 = new HeroNode(10,"武松");
        HeroNode node6 = new HeroNode(14,"杨志");
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        binaryTree.threadedNodes(root);
        binaryTree.ThreadNodesList();
    }
}
/**
 * 创建二叉树
 */
class BinaryTree{
    private HeroNode root;
    //  在递归进行线索化的时候，pre总是保留前一个节点
    private HeroNode pre = null;
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 遍历线索化树
     */
    public void ThreadNodesList(){
        HeroNode node = root;
        while (node != null) {
            //  如果节点的左子树类型是0，就往下找，直到找到类型为1的节点，因为当类型为1，说明是线索化处理的节点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            //  输出线索化处理的节点
            System.out.println(node);
            //  如果此节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            //  如果右指针不是后继节点，就替换当前节点
            node = node.getRight();
        }
    }
    /**
     * 线索化树
     * @param node
     */
    public void threadedNodes(HeroNode node){
        if (node == null) {
            return;
        }
        //  先线索化左子树
        threadedNodes(node.getLeft());
        //  线索当前节点
        //  如果当前节点的左子树为空，则说明是叶子节点
        //  给当前叶子节点设置前驱节点，类型设置为1
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //  每处理一个节点，让当前节点是下一个节点的前驱节点
        pre = node;
        //  线索右子树
        threadedNodes(node.getRight());
    }
    /**
     * 先序遍历
     */
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    /**
     * 先序查找
     */
    public HeroNode preOrderSearch(int no){
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 中序查找
     * @param no
     * @return
     */
    public HeroNode infixOrderSerach(int no){
        if (this.root != null) {
            return this.root.infixOrderSerach(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后序查找
     * @param no
     * @return
     */
    public HeroNode postOrderSerach(int no){
        if (this.root != null) {
            return this.root.postOrderSerach(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }
}

/**
 * 节点
 */
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //  左子树的类型，如果等于0，则说明指向左子树啊，如果等于1 ，则说明指向前驱节点
    private int leftType;
    //  右子树的类型，如果等于0，则说明指向右子树啊，如果等于1 ，则说明指向后继节点
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 先序遍历
     */
    public void preOrder() {
        //  先输出父节点
        System.out.println(this);
        //  递归遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //  递归遍历右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 先序查找
     */
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 中序查找
     */
    public HeroNode infixOrderSerach(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSerach(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSerach(no);
        }
        return resNode;
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 后续遍历查找
     */
    public HeroNode postOrderSerach(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSerach(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSerach(no);
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}
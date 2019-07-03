package my_game_interface.dataStruct.tree;

/**
 * 二叉树的先序，中序，后续遍历
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"林冲");
        HeroNode node4 = new HeroNode(4,"关胜");
        HeroNode node5 = new HeroNode(5,"武松");
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        System.out.println("先序");
        binaryTree.preOrder();
        System.out.println("中序");
        binaryTree.infixOrder();
        System.out.println("后序");
        binaryTree.postOrder();
        System.out.println("先序查找");
        HeroNode heroNode = binaryTree.preOrderSearch(3);
        System.out.println(heroNode.getName());
        System.out.println("中序查找");
        HeroNode heroNode1 = binaryTree.preOrderSearch(3);
        System.out.println(heroNode1.getName());
        System.out.println("后序查找");
        HeroNode heroNode2 = binaryTree.preOrderSearch(3);
        System.out.println(heroNode2.getName());

    }
}

/**
 * 创建二叉树
 */
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

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
    public void preOrder(){
        //  先输出父节点
        System.out.println(this);
        //  递归遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //  递归遍历右子树
        if (this.right != null){
            this.right.preOrder();
        }
    }
    /**
     * 先序查找
     */
    public HeroNode preOrderSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode resNode=null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
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
    /**
     * 中序查找
     */
    public HeroNode infixOrderSerach(int no){
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSerach(no);
        }
        if (resNode != null) {
            return  resNode;
        }
        if (this.no == no){
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
    public void postOrder(){
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
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

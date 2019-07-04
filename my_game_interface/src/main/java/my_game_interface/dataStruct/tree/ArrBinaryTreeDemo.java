package my_game_interface.dataStruct.tree;

/**
 * 将数组以二叉树前序遍历的方式进行遍历
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7};
        ArrBinartTree arrBinartTree = new ArrBinartTree(arr);
        arrBinartTree.preOrder(0);
    }

}

class ArrBinartTree{
    private int[] arr;

    public ArrBinartTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 顺序二叉树通常只考虑完全二叉树
     * 第n个节点的左子树：2*n+1
     * 第n个节点的右子树：2*n+2
     * 第n个节点的父节点：(n-1)/2
     * n表示二叉树中的第几个元素.(按编号0开始)
     * @param index
     */
    public void preOrder(int index){
        if (arr.length == 0 || arr == null) {
            return;
        }
        System.out.println(arr[index]);
        //  向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length){
            preOrder(index * 2 + 2);
        }
    }
}

package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * _3_15_树_二叉树简介
 * 笔记：
 * 算子节点：2i+1,2i+2
 * 算父节点：(i-1)/2
 * 附加：
 * n层二叉树的第n层最多为2^(n-1)个
 * 二叉树节点计算公式 N = n0+n1+n2，度为0的叶子节点比度为2的节点数多一个。N=1*n1+2*n2+1
 * 对任何一棵二叉树T，如果其终端节点数为n0，度为2的节点数为n2，则n0=n2+1
 * 具有n个节点的完全二叉树的深度为log2(n) + 1
 * n个节点的二叉树一共有((2n)!)/(n! * (n+1)!)种
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/08 下午 10:45
 */
public class _3_15_树_二叉树简介 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        _3_15_树_二叉树简介 c = new _3_15_树_二叉树简介();
        Utils.AboutArray.printIntArray(arr);
        System.out.println();
        c.preOrder(arr,0);
        System.out.println("--------");
        c.inOrder(arr,0);
        System.out.println("--------");
        c.postOrder(arr,0);
    }

    /**
     * 树的先序遍历
     *
     * @param arr   存放树的数组
     * @param index 根节点
     */
    public void preOrder(int[] arr, int index) {
        if(index>= arr.length){
            return;
        }
        //先输出根节点
        System.out.println(arr[index]);
        //输出左子树
        preOrder(arr,index*2+1);
        //输出右子树
        preOrder(arr,index*2+2);
    }

    /**
     * 树的中序遍历
     *
     * @param arr   存放树的数组
     * @param index 根节点
     */
    public void inOrder(int[] arr, int index) {
        if(index>= arr.length){
            return;
        }
        inOrder(arr,index*2+1);
        System.out.println(arr[index]);
        inOrder(arr,index*2+2);
    }

    /**
     * 树的后序遍历
     *
     * @param arr   存放树的数组
     * @param index 根节点
     */
    public void postOrder(int[] arr, int index) {
        if(index>= arr.length){
            return;
        }
        postOrder(arr,index*2+1);
        postOrder(arr,index*2+2);
        System.out.println(arr[index]);
    }
}

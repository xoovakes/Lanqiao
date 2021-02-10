package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * _3_15_树_二叉树简介
 * 笔记：
 * 算子节点：2i+1,2i+2
 * 算父节点：(i-1)/2
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

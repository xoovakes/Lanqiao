package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * _3_19_计数排序
 * 时间复杂度：扫描一次source，扫描一次helper，复杂度为N+k
 * 空间复杂度：辅助空间k，k=maxOf(source)
 * 非原址排序
 * 稳定性：相同元素不会出现交叉，非原址都是拷来拷去
 * 改进：如果要优化一下空间，可以求minOf(source),helper的长度为max-min+1,这样能短一点
 * 计数排序有缺陷，数据较为密集或范围教训，才适用
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/10 下午 3:56
 */
public class _3_19_计数排序 {
    public static void main(String[] args) {
        int[] arr = Utils.AboutArray.intRandomArray(10, 0, 20);
        Utils.AboutArray.printIntArray(arr);
        new _3_19_计数排序().sort(arr);
        Utils.AboutArray.printIntArray(arr);
    }

    public void sort(int[] source) {
        int[] helper = new int[Utils.AboutArray.maxOf(source) + 1];
        for (int e :
                source) {
            helper[e]++;
        }
        int k = 0;
        for (int i = 0; i < helper.length; i++) {
            while (helper[i] > 0) {
                source[k++] = i;
                helper[i]--;
            }
        }
    }
}

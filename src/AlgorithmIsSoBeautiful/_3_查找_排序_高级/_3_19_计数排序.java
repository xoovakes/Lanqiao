package AlgorithmIsSoBeautiful._3_查找_排序_高级;

/**
 * _3_19_计数排序
 * 思路：
 * 开辟新的空间，空间大小为max(source)
 * 时间复杂度：
 * 空间复杂度：
 * 稳定性：
 * 改进1：如果要优化一下空间，可以求minOf(source),helper的长度为max-min+1,这样能短一点
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

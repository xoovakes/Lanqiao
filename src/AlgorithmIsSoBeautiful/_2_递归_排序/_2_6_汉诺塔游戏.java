package AlgorithmIsSoBeautiful._2_递归_排序;

/**
 * 汉诺塔游戏
 *
 * @author zixi
 * @version 1.0
 * @date 21/01/27 下午 11:08
 */
public class _2_6_汉诺塔游戏 {
    public static void main(String[] args) {
        _2_6_汉诺塔游戏 c = new _2_6_汉诺塔游戏();
        c.printHanoiTower(3,"A","B","C");
    }

    /**
     *  把N个盘子从from 移动到to 的路径的打印
     * @param N
     * @param from
     * @param to
     * @param help
     */
    public void printHanoiTower(int N,String from,String to,String help){
        if(N==1){
            System.out.printf("move %d from %s to %s\n",N,from,to);
            return;
        }
        printHanoiTower(N-1,from,help,to);
        System.out.printf("move %d from %s to %s\n",N,from,to);
        printHanoiTower(N-1,help,to,from);
    }
}

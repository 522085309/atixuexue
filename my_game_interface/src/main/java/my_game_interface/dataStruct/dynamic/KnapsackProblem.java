package my_game_interface.dataStruct.dynamic;

/**
 * 0-1背包问题
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        //  物品重量
        int w[] = {1,4,3};
        //  物品价值
        int val[] = {1500,3000,2000};
        //  背包容量
        int m = 4;
        //  物品个数
        int n = val.length;
        //  创建二位数组。v[i][j]表示在前i个物品中能够装入容量为j的背包的最大价值。(即第i个物品，背包容量为j时的最大价值)
        int [][] v = new int[n+1][m+1];
        //  用于记录是放哪些物品时，达到价值最大
        int [][] path = new int[n+1][m+1];

        for (int i =1 ;i < v.length ;i++){
            for (int j = 1 ;j < v[0].length;j++){
                //  如果第I个物品的重量大于背包容量，则：
                if (w[i - 1] > j){
                    v[i][j] = v[i - 1][j];
                }else {
//                    v[i][j] = Math.max(v[i - 1][j],val[i -1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i -1] + v[i - 1][j - w[i - 1]]){
                        v[i][j] = val[i -1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        for (int i = 1;i < v.length;i++){
            for (int j = 1;j< v[i].length;j++){
                System.out.printf(v[i][j]+" ");
            }
            System.out.println();
        }
        int i = path.length -1 ;
        int j = path[0].length -1 ;
        while (i > 0 && j > 0){
            if (path[i][j] == 1){
                System.out.printf("第%d个商品放入背包",i);
                j -= w[i -1];
            }
            i --;
        }
    }
}

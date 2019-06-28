package my_game_interface.dataStruct.recuision;

/**
 * 用二维数组标识迷宫
 *  0代表未走过
 *  1代表迷宫墙
 *  2代表可走，但是不一定是通路
 *  3代表路不通
 */
public class MiGong {
    public static void main(String[] args) {
        int [][]arr=new int[7][8];

        //定义迷宫的墙
        for (int i = 0; i<8; i++){
            arr[0][i]=1;
            arr[6][i]=1;
        }
        for (int i = 0; i < 7; i++){
            arr[i][0] = 1;
            arr[i][7] = 1;
        }

        //打印迷宫
        System.out.println("迷宫地图");
        for (int row[] : arr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        setWay(arr,1,1);
        System.out.println("通路");
        for (int row[] : arr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
    public static boolean setWay(int [][]arr,int i,int j){
        //如果目的坐标为2，说明找到了一条通路。
        if(arr[5][6] == 2){
            return true;
        }else {
            if (arr[i][j] == 0){
                //假设此坐标为可通的路
                arr[i][j] = 2;
                //向下递归寻找，如果返回true,则说明走到了目标坐标
                if (setWay(arr,i+1,j)){
                    return true;
                }else if (setWay(arr,i,j+1)){
                    return true;
                }else if (setWay(arr,i-1,j)){
                    return true;
                }else if (setWay(arr,i,j-1)){
                    return true;
                }
                //如果四个方向都没有找到通路，说明此坐标为不通的路，修改假设的值为3
                arr[i][j] = 3;
                return false;
            }else {
                return false;
            }
        }
    }
}

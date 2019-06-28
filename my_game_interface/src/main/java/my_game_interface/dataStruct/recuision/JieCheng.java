package my_game_interface.dataStruct.recuision;

public class JieCheng {
    public static void main(String[] args) {
        System.out.println(jieCheng(3));
    }

    public static int jieCheng(int n){
        if (n < 2){
            return 1;
        }else {
            return jieCheng(n - 1) * n;
        }
    }
}

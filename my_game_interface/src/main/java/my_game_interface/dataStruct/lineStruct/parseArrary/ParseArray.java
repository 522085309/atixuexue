package my_game_interface.dataStruct.lineStruct.parseArrary;

import java.io.*;

/**
 * 模拟五子棋的写与读
 *     将五子棋的棋盘模拟为二维数组，将二维数组转化为稀疏数组
 */
public class ParseArray {
    public static void main(String[] args) {
        //定义二维数组
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        int[][] parseArray = getParseArray(chessArray);
        String fileName = parseArrayToFile(parseArray);
        int[][] parseArrayf = fileToParseArray(fileName);
        System.out.println("文件中的稀疏数组");
        for (int []rows:parseArrayf){
            for (int data:rows){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int[][] chessArrayf = getChessArray(parseArrayf);
        System.out.println("文件中的原始数组");
        for (int []rows:chessArrayf){
            for (int data:rows){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }


    /**
     * 根据原始二维数组，得到稀疏数组
     * @param chessArray
     * @return
     */
    public static int[][] getParseArray(int [][] chessArray){
        // 打印二维数组
        System.out.println("原始二维数组：");
        for (int[] rows : chessArray) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //计算原始数组的有效数字个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        //定义稀疏数组
        int[][] parseArray = new int[sum + 1][3];
        parseArray[0][0]=11;
        parseArray[0][1]=11;
        parseArray[0][2]=sum;
        //将二维数组的有效数字存入稀疏数组中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    parseArray[count][0] = i;
                    parseArray[count][1] = j;
                    parseArray[count][2] = chessArray[i][j];
                }
            }
        }
        //打印稀疏数组
        System.out.println("稀疏数组为：");
        for (int []rows:parseArray){
            for (int data:rows){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        return parseArray;
    }
    /**
     * 将稀疏数组，写入文件
     * @param parseArray
     */
    public static String parseArrayToFile(int [][] parseArray){
        File file=new File("D:\\idea\\dataStruct\\parseArray\\parseArray.txt");
//        BufferedWriter outputStream=null;
        FileWriter outputStream=null;
        StringBuilder stringBuilder=new StringBuilder();
        try{
            outputStream=new FileWriter((file));
//            outputStream=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            for (int[] rows:parseArray){
                for(int data:rows){
                    stringBuilder.append(data);
                    stringBuilder.append("\t");
                }
                stringBuilder.append("\r\n");
            }
            outputStream.write(stringBuilder.toString());
            outputStream.flush();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return String.valueOf(file.getAbsoluteFile());
    }
    /**
     *     从文件中读取稀疏数组
     */
    public static int[][] fileToParseArray(String fileName){
        File file=new File(fileName);
        BufferedReader inputStream=null;
        int [][] parseArray=null;
        StringBuilder stringBuilder=new StringBuilder();
        try{
            inputStream=new BufferedReader(new FileReader(fileName));
            //每行读取到的数据
            String line=null;
            //记录行数
            int lines=0;
            while ((line=inputStream.readLine())!=null){
                lines++;
                stringBuilder.append(line);
            }
            parseArray=new int[lines][3];
            int count=0;
            for(int i=0;i<lines;i++){
                for(int j=0;j<3;j++){
                    parseArray[i][j]= Integer.parseInt(stringBuilder.toString().split("\t")[count]);
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return parseArray;
    }

    /**
     * 根据文件中的稀疏数组，获取原始数组
     * @param parseArray
     * @return
     */
    public static int [][] getChessArray(int [][] parseArray){
        int [][] chessArray=new int[parseArray[0][0]][parseArray[0][1]];
        for (int [] rows:parseArray){
            chessArray[rows[0]-1][rows[1]-1]=rows[2];
        }
        return chessArray;
    }
}

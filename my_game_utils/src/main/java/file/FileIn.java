package file;

import java.io.*;

public class FileIn {
    //  按字节一个一个读
    public static void fileInput(){
        //  源
        File file=new File("D:\\abc.txt");
        //  流
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(file);
            // 操作
            int n=0;
            while ((n=inputStream.read())!=-1){
                //按字节一个一个的读出来
                System.out.println((Integer.toBinaryString(n)));
//                  System.out.println(char(n)));
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
    }
    //  按字节数组的大小读
    public static void fileInput1(){
        //  源
        File file=new File("D:\\abc.txt");
        //  流
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(file);
            // 操作
            int n=0;
            //  创建10字节的字节数组，将读取的数据存入字节数据中
            byte[] b=new byte[1];
            while ((n=inputStream.read(b))!=-1){
                // 将字节数组转换为字符串
                String s=new String(b,0,b.length);
                System.out.println(s);
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
    }
    public static void fileInput2(){
        //  源
        File file=new File("D:\\abc.txt");
        //  流
        InputStream inputStream=null;
        try {
            inputStream=new BufferedInputStream(new FileInputStream(file));
            // 操作
            int n=0;
            //  创建10字节的字节数组，将读取的数据存入字节数据中
            byte[] b=new byte[1];
            while ((n=inputStream.read(b))!=-1){
                // 将字节数组转换为字符串
                String s=new String(b,0,b.length);
                System.out.println(s);
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
    }

    public static void main(String[] args) {
        fileInput();
//        fileInput1();
    }
}

package file;

import java.io.*;

public class FileOut {
    public static void fileOut(){
        File file=new File("D:\\abc.txt");
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(file);
            String msg="abcd efg";
            byte [] b=msg.getBytes();
            outputStream.write(b,0,b.length);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileCopy(){
        // 源
        File src=new File("D:\\abc.txt");
        File dest=new File("D:\\cba.txt");
        // 流
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream=new BufferedInputStream(new FileInputStream(src));
            outputStream=new BufferedOutputStream(new FileOutputStream(dest));
            int n=0;
            byte []b =new byte[2];
            while ((n=inputStream.read(b))!=-1){
                outputStream.write(b);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
//        fileOut();
        fileCopy();
    }
}

package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinarFile {
    public static void main(String[] args) throws IOException {
        String fileName="D:\\20190416013057.csn";
        List<String> list=getData(fileName);
        System.out.println(list.size());
        for(String s :list){
            System.out.println(s);
        }
//        getData(fileName);
    }
    public static List<String> getData(String fileName){
        List<String> list=new ArrayList<>();
        File file=new File(fileName);
        InputStream inputStream=null;
        try {
            inputStream=new BufferedInputStream(new FileInputStream(file));
            int n=0;
            byte[] b=new byte[9];
            while ((n=inputStream.read(b))!=-1){
                String s=parseByte2HexStr(b);
                list.add(s);
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
        return list;
    }
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
//            System.out.println(buf[i] & 0xFF);
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

}


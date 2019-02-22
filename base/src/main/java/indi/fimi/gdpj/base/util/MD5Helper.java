package indi.fimi.gdpj.base.util;


import org.springframework.util.DigestUtils;

import java.io.File;

public class MD5Helper {

    public static String getMD5Str(String text) {
        //加密后的字符串
        String encodeStr = DigestUtils.md5DigestAsHex(text.getBytes());
        System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
        return encodeStr;
    }

    public static boolean checkMD5Str(String source, String target) {
        return getMD5Str(source).equalsIgnoreCase(target);
    }

    public static void main(String[] args){
        File f = new File("E:/graduation_project/gdpj-admin/static/images/34/4d23ddf76503a0bcbaa33a75f90ae339.png");
        System.out.println(new File(f.getPath()).isAbsolute());
    }
}

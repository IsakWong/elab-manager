package elab.utility;

import org.apache.ibatis.logging.log4j2.Log4j2LoggerImpl;
import org.apache.log4j.spi.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.logging.LogManager;

public class Utilities {

    public static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                BASE64Encoder base64en = new BASE64Encoder();
                String newstr = base64en.encode(md5.digest(originString.getBytes("utf-8")));
                return newstr;
            } catch (Exception e) {

            }
        }
        return null;
    }

    public static String loadStringFromStream(InputStream input) {
        try {
            byte[] bytes = new byte[input.available()];
            input.read(bytes);
            String str = new String(bytes);
            return str;
        } catch (IOException exception) {

        }
        return null;
    }
}

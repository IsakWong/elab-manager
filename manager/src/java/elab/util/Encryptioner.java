package elab.util;

import java.security.MessageDigest;

public class Encryptioner {

    private static String MD5(String s) {
        String rs = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            rs = toHex(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    private static String toHex(byte[] bytes) {
        final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    public static String encrypt(String s) {
        return MD5(s);
    }
}

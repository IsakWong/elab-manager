package elab.util;

import com.jfoenix.controls.JFXSnackbar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class Utilities {

    /**
     * 消息弹出窗口
     * @param message
     * @param container
     */

    public static void popMessage(String message, Pane container) {
        JFXSnackbar bar = new JFXSnackbar(container);
        JFXSnackbar.SnackbarEvent event = new JFXSnackbar.SnackbarEvent(message);
        bar.enqueue(event);
    }

    public static void popMessage(String message, HBox container) {
        JFXSnackbar bar = new JFXSnackbar(container);
        JFXSnackbar.SnackbarEvent event = new JFXSnackbar.SnackbarEvent(message);
        bar.enqueue(event);
    }

    /**
     * 分模块加载
     * @param input
     * @return
     */

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

    /**
     * MD5加密
     * @param s
     * @return
     */

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

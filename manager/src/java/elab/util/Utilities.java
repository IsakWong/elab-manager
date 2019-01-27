package elab.util;

import com.jfoenix.controls.JFXSnackbar;
import elab.database.DatabaseOperations;
import elab.serialization.school_opening_information.SchoolOpeningInformation;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    /**
     * 信息过滤器
     * 用于过滤数据库表格中的信息(根据需要过滤的列位于数据表的列数(filteringInformationIndex),过滤出拥有filteringString的ListElements)
     * @param list
     * @param filteringString
     * @param filteringInformationIndex
     * @return
     */

    public static List filter(List list, String filteringString, int filteringInformationIndex) {
        for(int i = 0; i < list.size(); ++i) {
            String[] properties = list.get(i).toString().split(" ");
            if(!properties[filteringInformationIndex].equals(filteringString)) {
                list.remove(i);
                --i;
            }
        }
        return list;
    }

    /**
     * 获取开学信息
     */

    private static SchoolOpeningInformation instance = null;

    private static SchoolOpeningInformation buildSchoolOpeningInformation() {
        instance = DatabaseOperations.getInstance().selectSchoolOpeningDateInformation();
        return instance;
    }

    public static SchoolOpeningInformation getSchoolOpeningInformation() {
        return instance == null ? buildSchoolOpeningInformation() : instance;
    }

    /**
     * 获取从开学日期到当前日期天数差
     * @return
     */

    private static int SchoolDays = 0;

    private static int calculateDays() {
        int daysDistance = 0;
        try {
            SchoolOpeningInformation schoolOpeningInformation = getSchoolOpeningInformation();
            String startDateStr = schoolOpeningInformation.getSchoolOpeningDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = simpleDateFormat.parse(startDateStr);
            long l = System.currentTimeMillis();
            Date endDate = new Date(l);

            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);
            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate);
            int startDay = startCal.get(Calendar.DAY_OF_YEAR);
            int endDay = endCal.get(Calendar.DAY_OF_YEAR);
            int startYear = startCal.get(Calendar.YEAR);
            int endYear = endCal.get(Calendar.YEAR);
            if(startYear != endYear)
                for(int i = startYear; i < endYear; ++i) {
                    if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0) daysDistance += 366;
                    else daysDistance += 365;
                }
            daysDistance += (endDay - startDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daysDistance;
    }

    public static int getSchoolDays() {
        return SchoolDays == 0 ? calculateDays() : SchoolDays;
    }

    /**
     * 获取校历周数
     * @return
     */

    public static int getSchoolCalendarWeek() {
        return getSchoolDays() / 7 + 1;
    }

    /**
     * 获取系统星期
     */

    private static String systemWeek = null;

    private static String convertSystemWeek() {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));
        int w = cal.get(Calendar.DAY_OF_WEEK);
        systemWeek = weekDays[w - 1];
        return systemWeek;
    }

    public static String getSystemWeek() {
        return systemWeek == null ? convertSystemWeek() : systemWeek;
    }

    /**
     * 获取本周课程种类
     */

    private static String courseSort = null;

    private static String checkCourseSort() {
        int c = 2;
        String[] courseSort = {"硬件课", "软件课", ""};
        String[] hardWeeks = getSchoolOpeningInformation().getHardWeeks().split("~");
        String[] softWeeks = getSchoolOpeningInformation().getSoftWeeks().split("~");
        if(Integer.parseInt(hardWeeks[0]) <= getSchoolCalendarWeek() && getSchoolCalendarWeek() <= Integer.parseInt(hardWeeks[1]))
            c = 0;
        else if(Integer.parseInt(softWeeks[0]) <= getSchoolCalendarWeek() && getSchoolCalendarWeek() <= Integer.parseInt(softWeeks[1]))
            c = 1;
        return courseSort[c];
    }

    public static String getCourseSort() {
        return courseSort == null ? checkCourseSort() : courseSort;
    }

}

package elab.serialization.member;

import org.apache.ibatis.type.Alias;

@Alias("loginMessage")
public class LoginMessage {

    private static int number;
    private static String password;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        LoginMessage.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        LoginMessage.password = password;
    }

    public String toString() {
        return number + " " + password;
    }
}

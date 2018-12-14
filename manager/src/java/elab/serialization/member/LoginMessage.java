package elab.serialization.member;

public class LoginMessage {

    private int number;
    private String password;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return number + " " + password;
    }
}

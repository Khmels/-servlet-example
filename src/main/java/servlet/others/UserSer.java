package servlet.others;

import java.io.Serializable;

public class UserSer implements Serializable {
    private static final long serialVersionUID = -5965889571286371973L;

    private String name;
    private int age;

    public UserSer() {
        this.name = "";
        this.age = 0;
    }
    public UserSer(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

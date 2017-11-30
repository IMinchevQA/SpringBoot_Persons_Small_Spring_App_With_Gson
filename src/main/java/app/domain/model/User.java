package app.domain.model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;

    private Integer age;

    public User(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
                "User{name='%1s', age='%2s'}",
                this.getName(),
                this.getAge()));

        return sb.toString();
    }
}

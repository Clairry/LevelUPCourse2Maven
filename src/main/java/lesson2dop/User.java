package lesson2dop;

import lesson2dop.SerializedBy;

@SerializedBy("lesson2dop.UserSerializator")
public class User {
    public User() {};

    private String name="Ivan";

    public String getName() {
        return name;
    }
}

package lesson2dop;

public class UserSerializator implements Serializer<User> {

    public UserSerializator() {};

    @Override
    public String serialize(User object) {
        return "Имя: "+object.getName();
    }
}

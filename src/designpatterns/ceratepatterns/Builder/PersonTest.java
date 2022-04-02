package designpatterns.ceratepatterns.Builder;

public class PersonTest {
    public static void main(String[] args) {
        Person.PersonBuilder personBuilder = new Person.PersonBuilder();
        Person person = personBuilder.setId(1)
                .setInfo(2000, 21, "xiaoxiang")
                .setAddress("china", "hunan", "xiangtan")
                .build();
    }
}

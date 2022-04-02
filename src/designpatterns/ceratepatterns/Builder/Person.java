package designpatterns.ceratepatterns.Builder;

/**
 * 建造者模式：
 * 一步一步创建一个复杂对象，允许用户只通过指定复杂对象的类型和内容构建，
 * 用户不需要之傲内部构件细节。
 */
public class Person {
    private int id;
    private Info info;
    private Address address;

    public static class PersonBuilder{
        private Person person = new Person();

        public PersonBuilder setId(int id){
            person.id = id;
            return this;
        }

        public PersonBuilder setInfo(int birthYear, int age, String name){
            person.info = new Info(birthYear, age, name);
            return this;
        }

        public PersonBuilder setAddress(String nation, String province, String city){
            person.address = new Address(nation, province, city);
            return this;
        }

        public Person build(){
            return person;
        }
    }

    public int getId() {
        return id;
    }

    public Info getInfo() {
        return info;
    }

    public Address getAddress() {
        return address;
    }
}

class Info{
    private int birthYear;
    private int age;
    private String name;

    public Info(int birthYear, int age, String name) {
        this.birthYear = birthYear;
        this.age = age;
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Address{
    private String nation;
    private String province;
    private String city;

    public Address(String nation, String province, String city) {
        this.nation = nation;
        this.province = province;
        this.city = city;
    }

    public String getNation() {
        return nation;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }
}
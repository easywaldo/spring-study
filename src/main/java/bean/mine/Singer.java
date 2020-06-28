package bean.mine;

public class Singer {
    private String name;
    private Long age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String toString() {
        return String.format("name : %s, age : %s", this.name, this.age);
    }
}

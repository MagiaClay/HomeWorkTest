//定义简单数据库，里面有之后所有类所需要的信息
public class Info {
    private String name;
    private int age;
    private int luck=1;
    private int redpaper=100;       //总红包钱数，同步元素
    private int personRed=0;        //个人所拥有的红包
    public Info(){}                 //无参构造


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

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getRedpaper() {
        return redpaper;
    }

    public void setRedpaper(int redpaper) {
        this.redpaper = redpaper;
    }

    public int getPersonRed() {
        return personRed;
    }

    public void setPersonRed(int personRed) {
        this.personRed = personRed;
    }
}

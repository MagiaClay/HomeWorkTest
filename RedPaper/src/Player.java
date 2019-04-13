import java.util.Random;

//定义参与者的类
public class Player{
    private Info info=new Info();
    public Player() {
    }
    public Player(String name,int age){
        this.info.setAge(age);
        this.info.setName(name);
        this.info.setLuck(luckSet());
    }
    public int luckSet(){       //设置线程优先级及“幸运值”，及幸运值越高，线程相对于的优先级越高
        int a =new Random().nextInt(100)+1;
        if (a<=33) {
            return Thread.MIN_PRIORITY;
        }
        else if (a>33&&a<66) {
            return Thread.NORM_PRIORITY;
        }
        else{
            return Thread.MAX_PRIORITY;}
    }

    public Info getInfo() {
        return info;
    }


}

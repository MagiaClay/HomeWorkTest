import java.util.Random;
//红包主程序。出现无法解决的Hot Swap Failed问题，似乎不影响主程序？
//默认第一号player为优先抢红包的人，首先抢到红包（同时也是发红包的人），有很大几率抢到更多的钱。
//每份红包分配的钱的算法为=[1~（当前红包剩下的钱-还没强抢红包的人数）]之间的一个随机整数，以保证16个人中每人至少有一元
//有4个幸运player没有红包
public class RedPaperSystem implements Runnable{
    private Info info=new Info();           //数据库共享
    private Player player[];                //参与抽奖的人员
    private int count=16;                   //抽奖仅有的红包数
    private int temp=0;                     //接受每份红包的钱数


    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    @Override
    public void run() {
            synchronized (this){
                if (count>=1){
                    try {
                        Thread.sleep(500);                                                 //加入延迟
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    this.temp=new Random().nextInt(this.info.getRedpaper()-count)+1;      //随机分配红包的钱。保证16个人中每个人至少有1元红包
                    this.info.setRedpaper(this.info.getRedpaper()-this.temp);                   //同步红包里还剩下的钱
                    this.player[Integer.valueOf(Thread.currentThread().getName())].getInfo().setPersonRed(this.temp);
                    //以传入的线程名称作为对应的学生编号，保留得到红包的学生的信息
                    System.out.println("恭喜"+this.player[Integer.valueOf(Thread.currentThread().getName())].getInfo().getName()+"抢到"+this.temp+"元红包！！");
                    --count;
                }
            }
    }
}

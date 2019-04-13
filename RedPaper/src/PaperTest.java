
import java.util.Random;

public class PaperTest {
    public static void main(String ars[]) {
        RedPaperSystem red = new RedPaperSystem();      //实例化主程序对象
        setMyPlayer(red);                               //初始化参与player
        try {
            Thread.sleep(10000);                  //主程序休眠等待”幸运王“结算
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("那么本次抽奖王得主为"+luckDoll(red).getInfo().getName()+"，他抽到了"+luckDoll(red).getInfo().getPersonRed()+"元红包!");
        System.out.println("他的年龄为："+luckDoll(red).getInfo().getAge());

    }

    public static void setMyPlayer(RedPaperSystem red) {//初始化参与player
        red.setPlayer(new Player[20]);                  //分配空间
        for (int i = 0; i < 20; i++)                    //实例化参与player
            red.getPlayer()[i] = new Player("葫芦娃" + i + "号", (new Random().nextInt(45) + 18));
        //手动创建20个红包用户，年龄为18到45岁，名称为葫芦娃，序号分别对应0至19，并创建线程（其实可以简化）。
        Thread ply0 = new Thread(red, "0");
        ply0.setPriority(red.getPlayer()[0].getInfo().getLuck());
        Thread ply1 = new Thread(red, "1");
        ply1.setPriority(red.getPlayer()[1].getInfo().getLuck());
        Thread ply2 = new Thread(red, "2");
        ply2.setPriority(red.getPlayer()[2].getInfo().getLuck());
        Thread ply3 = new Thread(red, "3");
        ply3.setPriority(red.getPlayer()[3].getInfo().getLuck());
        Thread ply4 = new Thread(red, "4");
        ply4.setPriority(red.getPlayer()[4].getInfo().getLuck());
        Thread ply5 = new Thread(red, "5");
        ply5.setPriority(red.getPlayer()[5].getInfo().getLuck());
        Thread ply6 = new Thread(red, "6");
        ply6.setPriority(red.getPlayer()[6].getInfo().getLuck());
        Thread ply7 = new Thread(red, "7");
        ply7.setPriority(red.getPlayer()[7].getInfo().getLuck());
        Thread ply8 = new Thread(red, "8");
        ply8.setPriority(red.getPlayer()[8].getInfo().getLuck());
        Thread ply9 = new Thread(red, "9");
        ply9.setPriority(red.getPlayer()[9].getInfo().getLuck());
        Thread ply10 = new Thread(red, "10");
        ply10.setPriority(red.getPlayer()[10].getInfo().getLuck());
        Thread ply11 = new Thread(red, "11");
        ply11.setPriority(red.getPlayer()[11].getInfo().getLuck());
        Thread ply12 = new Thread(red, "12");
        ply12.setPriority(red.getPlayer()[12].getInfo().getLuck());
        Thread ply13 = new Thread(red, "13");
        ply13.setPriority(red.getPlayer()[13].getInfo().getLuck());
        Thread ply14 = new Thread(red, "14");
        ply14.setPriority(red.getPlayer()[14].getInfo().getLuck());
        Thread ply15 = new Thread(red, "15");
        ply15.setPriority(red.getPlayer()[15].getInfo().getLuck());
        Thread ply16 = new Thread(red, "16");
        ply16.setPriority(red.getPlayer()[16].getInfo().getLuck());
        Thread ply17 = new Thread(red, "17");
        ply17.setPriority(red.getPlayer()[17].getInfo().getLuck());
        Thread ply18 = new Thread(red, "18");
        ply18.setPriority(red.getPlayer()[18].getInfo().getLuck());
        Thread ply19 = new Thread(red, "19");
        ply19.setPriority(red.getPlayer()[19].getInfo().getLuck());
        ply1.start();
        ply0.start();
        ply12.start();
        ply13.start();
        ply4.start();
        ply5.start();
        ply16.start();
        ply7.start();
        ply18.start();
        ply19.start();
        ply10.start();
        ply11.start();
        ply2.start();
        ply3.start();
        ply14.start();
        ply15.start();
        ply6.start();
        ply17.start();
        ply8.start();
        ply9.start();

    }
    public static Player luckDoll(RedPaperSystem red){          //遍历得到最多钱的player
        int maxMoney=red.getPlayer()[0].getInfo().getPersonRed();
        int person=0;
        for (int i=0;i<20;i++){
            if (red.getPlayer()[i].getInfo().getPersonRed()>maxMoney){
                maxMoney=red.getPlayer()[i].getInfo().getPersonRed();
                person=i;
            }
        }
        return red.getPlayer()[person];
    }
}


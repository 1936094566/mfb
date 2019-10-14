package java8.interfacedemo;

import java.util.Random;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/10/12
 * @Time:1:36
 **/
public class McBast {
    public static void main(String[] args) {
        Random random = new Random();
        int x  = random.nextInt(8888);
        for (int i = 0; i<=x ; i++){
            System.out.println(" 麻超是最棒的!!!!! 不容反驳!!!");
            System.out.println(x);
        }

    }
}

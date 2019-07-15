package java8.interfacedemo;

/**
 * @author machao
 * @date 2019/7/12
 * @time 11:52
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        Interface1 interface1 = new Interface1() {
            @Override
            public Integer getSum(Integer a,Integer b) {
                return defaultSum(a,b);
            }
        };
        System.out.println(interface1.getSum(1,2));

    }
}

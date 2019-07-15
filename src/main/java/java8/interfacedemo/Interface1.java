package java8.interfacedemo;


/**
 * @author machao
 * @date 2019/7/12
 * @time 11:50
 * @description
 **/
interface Interface1 {

    /**
     * 得到值
     * @return
     */
    Integer getSum(Integer a ,Integer b);

    default Integer defaultSum(Integer a,Integer b){
        return a+b;
    }

}

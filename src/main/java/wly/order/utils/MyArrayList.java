package wly.order.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyArrayList
 * @Description 自定义线性表的顺序存储结构
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/7/17 10:14
 * @Version 1.0
 **/
public class MyArrayList<Y>{


    private Object[] elementData = {};

    private Object[] tempData;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
    }
    public boolean add(Y y) {
        List list = new ArrayList();
        tempData = elementData;
        elementData = new Object[elementData.length+1];
        for (int i = 0; i < tempData.length; i++) {
            elementData[i] = tempData[i];
        }
        elementData[elementData.length-1] = y;
        return true;
    }

    public Y remove(int index){
        Y indexData = (Y)elementData[index];
        for (int i = 0; i < elementData.length; i++) {
            if(i<index){
                tempData[i] = elementData[i];
            }else if(i>index){
                tempData[i-1] = elementData[i];
            }
        }
        elementData = tempData;
        return indexData;
    }

        public Y get(int index){
        return (Y)elementData[index];
    }


    public int getSize(){
        return elementData.length;
    }


    //TODO 1.添加元素到指定位置
    public boolean add(int index,Y y){
        tempData = elementData;
        elementData = new Object[elementData.length+1];
        for(int i = 0;i < elementData.length;i++){
            if(i < index){
                elementData[i] = tempData[i];
            }else if(i > index){
                elementData[i] = tempData[i - 1];
            }else{
                elementData[i] = y;
            }
        }
        return true;
    }

    public boolean add2(int index,Y y){
        tempData = elementData;
        elementData = new Object[elementData.length+1];
        for(int i = 0;i < tempData.length;i++){
            elementData[i] = tempData[i];
        }
        for(int i = tempData.length;i > index; i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = y;
        return true;
    }





    /**
     *  TODO 替换指定位置的元素
     */
    public boolean set(int index,Y y){
        elementData[index] = y;
        return true;
    }


    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add("hhh");
        list.add("zzz");

        list.set(1,"tianjia");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }



    }

}

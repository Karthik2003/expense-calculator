package com.striim.ec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleSapient {
    public static void main(String[] args) {
        int [] nos = {0,0,1};
        for (int number : nos) {
            System.out.println("--toogle1---" + toogle1(number));
        }
        System.out.println("");
        for (int number : nos) {
            System.out.println("--toogle2---" + toogle2(number));
        }
        System.out.println("");
        for (int number : nos) {
            System.out.println("--toogle3---" + toogle3(number));
        }
        System.out.println("");
        for (int number : nos) {
            System.out.println("--toogle4---" + toogle4(number));
        }
        System.out.println("");
        removeIndice();
    }
    private static int toogle1(int i){
        while(i==0) {
            return 1;
        }
        return 0;
    }
    private static int toogle2(int i){
        switch (i) {
            case 0 : return 1;
            case 1 : return 0;
        }
        return i;
    }
    private static int toogle3(int i){
        try {
            return 1 % i;
        } catch (ArithmeticException ex) {
            return 1;
        }
    }
    private static int toogle4(int i){
        return i ^= 1;
    }
    private static void removeIndice(){
        List<Integer> indiceList = new ArrayList<>();
        indiceList.add(0);
        indiceList.add(5);
        indiceList.add(1);
        indiceList.add(2);
        List<String> nameList = new ArrayList<>();
        nameList.add("apple");
        nameList.add("butter");
        nameList.add("cheese");
        nameList.add("dal");
        nameList.add("egg");
        nameList.add("fish");
        nameList.add("grapes");
        nameList.add("hazelnut");
        System.out.println("----indiceList before-----" + indiceList);
        System.out.println("----nameList before-------" + nameList);
        Collections.sort(indiceList, Collections.reverseOrder());
        System.out.println("----indiceList after------" + indiceList);
        for(int index: indiceList){
            nameList.remove(index);
        }
        System.out.println("----nameList after--------" + nameList);
    }
}
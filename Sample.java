package com.striim.ec;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        String [] names = {"karthik","rajesh"};
        List<String> nameList = Arrays.asList(names);

        Map<String, String> namesMap = new HashMap<>();
        namesMap.put("kar", "karthik");
        namesMap.put("raj", "rajesh");

        List<Map<String, String>> nList = new ArrayList<>();
        nList.add(namesMap);

        for(Map<String, String> myMap : nList) {
            for(Map.Entry ent: myMap.entrySet()) {
                System.out.println("-----2111------"+ent.getKey());
                System.out.println("-----2111------"+ent.getValue());
            }
        }
        List<String> nBreakList = new ArrayList<>();
        nList.stream().forEach(myMap -> myMap.entrySet().forEach(ent -> {
            nBreakList.add(ent.getKey());
            nBreakList.add(ent.getValue());
        }));
        System.out.println("-----------"+nBreakList);

       //List<String> nBkList = nList.stream().map(Entry::).collect(Collectors.toList());
        //System.out.println("-----------"+nBkList);




    }
}

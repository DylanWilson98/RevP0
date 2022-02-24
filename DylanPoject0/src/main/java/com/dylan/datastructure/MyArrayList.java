package com.dylan.datastructure;

import java.util.Arrays;

public class MyArrayList {
    String[] arrayList;
    String[] newArray;

    public MyArrayList() {

        arrayList = new String[5];
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "myArray=" + Arrays.toString(arrayList) +
                ", newArray=" + Arrays.toString(newArray) +
                '}';
    }

    public void addItem(String item) {

        if(arrayList[arrayList.length-1] != null){
            newArray = new String[arrayList.length*2];


            for (int a = 0; a< arrayList.length; a++) {

                newArray[a] = arrayList[a];

                //myArray[a] = item;
            }
            arrayList = newArray;
                //newArray = null;
        }
        for (int i = 0; i < arrayList.length; i++) {


            if (arrayList[i] == null) {
                arrayList[i] = item;
                break;
            }

        }

    }


    public String getItem(int index) {

        //System.out.println(arrayList[index]);
        return arrayList[index];

    }

    public boolean arrayContains(String item) {
        int num= 0;
        boolean bool = false;
        for (int i = 0; i < arrayList.length; i++) {

            if(arrayList[i].equals(item)){

                bool = true;

            }else{num++;}
        }
        if(num == arrayList.length) {bool = false;}

        return bool;
    }

    public void updateItem(int index, String newItem) {
        arrayList[index] = newItem;

    }

    // TODO: 2/16/2022 Does not work entirely, as arrays become different sizes
    // TODO: 2/19/2022 Test if size method in generic helps this problem 
    public boolean arrayEquals(String[] array1) {
        boolean bool = false;
        int array1Values = 0;
        int arrayListValues = 0;
        int counter = 0;
        for (int i = 0; i < array1.length-1; i++) {

            if ( arrayList[i] != null) {arrayListValues++;}

            if (array1[i] != null) {array1Values++;}

            assert arrayList[i] != null;
            if(arrayList[i].equals(array1[i])) {counter++;}
        }

        if(arrayListValues == array1Values && arrayListValues == counter ) {bool = true;}


        return bool;
    }

}



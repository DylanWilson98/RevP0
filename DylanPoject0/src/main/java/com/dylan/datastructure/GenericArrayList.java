package com.dylan.datastructure;


import java.util.Arrays;

public class GenericArrayList<T> {


     Object[] arrayList;
     Object[] newArray= null;
    public  int length;
    public int size;
//    T[] arrayList;
//    T[] newArray;

    public GenericArrayList(T t) {
       length = 0;
        arrayList = new Object[10];
        newArray = arrayList;

    }

    public GenericArrayList(int length) {

        arrayList = new Object[length];
        this.length = length;
    }

//    public GenericArrayList(T game_id, T title, T rating) {
//    }

    public GenericArrayList() {

    }

    T get(int j) {
        length = 0;

        return (T)arrayList[j];
    }

    void  set(int j, T t) {

        arrayList[j] = t;
    }


// TODO: 2/21/2022 Commented out import and toString test if that changes anything take out import if it does not

        @Override
    public String toString() {
        return "GenericArrayList{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }



    public Integer size(){
//        Integer counter = 0;
//
//        for (int i = 0; arrayList[i] != null; i++) {
//            ++counter;
//
//        }


        return size;
    }

    
    public void addItem(T t) {
        if(arrayList[arrayList.length-1] != null){
            newArray = new String[arrayList.length*2];
                size = arrayList.length*2;

            for (int a = 0; a< arrayList.length; a++) {

                newArray[a] = arrayList[a];

                //myArray[a] = item;
            }
            arrayList = newArray;
            //newArray = null;
        }
        for (int i = 0; i < arrayList.length; i++) {


            if (arrayList[i] == null) {
                arrayList[i] = t;
                break;
            }

        }
        
    }
    
    public Object getItem(int index) {

        return arrayList[index];
    }

    public void updateItem(int index, T t) {
        arrayList[index] = t;
    }

    public boolean arrayContains(T t) {
        int num= 0;
        boolean bool = false;
        for (int i = 0; i < arrayList.length; i++) {

            if(arrayList[i].equals(t)){

                bool = true;

            }else{num++;}
        }
        if(num == arrayList.length) {bool = false;}

        return bool;
    }

    // TODO: 2/18/2022 does not have array equals method
}

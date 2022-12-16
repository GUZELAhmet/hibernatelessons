package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType<T> {
    /*
    E--> Elemet ,collection gibi yapılarda
    K--> Key
    V-->Value
    N-->Number
    T-->Type
    S,U,V,  --> 2. 3. 4. tipler için
     */

    private T type;

    //Getter Setter
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
    // main method
    public static void main(String[] args) {
        // Generic yapı kullarak aynı class dan iki farklı data türünde obje oluşturalım
        GenericType<String> obj1=new GenericType<>();
        //tric : diamond içine non_primitive type kullanabiliriz
        obj1.setType("generic type");
        //GenericType<String>  obj2 =new GenericType<>();
       // obj2.setType(65);     //String girmem gerekirken int data türü girince CTE verdi

       //Not: CAST probleminden nasıl kurutulurum
        GenericType<Integer> obj3=new GenericType<>();
        obj3.setType(65);
        int a = obj3.getType();///!!! Cast probleminden kurtulduk

        //Not: ClassCastException probleminden naswıl kurutulurum
        List<String> list= new ArrayList<>();

        list.add("Alper");
        list.add("Halide");
        //list.add(22);  //ClassCastException dan kurtuluk

        Map<Integer,String> map=new HashMap<>();

        map.put(1,"Generic");
        //map.put("Generic",2);


    }
}

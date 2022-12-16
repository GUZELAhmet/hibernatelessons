package Generics.Method;

import java.util.function.DoubleUnaryOperator;

// generic methodlar hangi durumda bize koaylık sağlar
public class GenericMethodDemo {

    public static void main(String[] args) {
        GenericMethodDemo obj1=new GenericMethodDemo();

        Integer [] intArray={1,23,54,56,45};
        obj1.print(intArray);
        Double[] doubleArray={1.2,2.1,5.6,9.3};
        obj1.print(doubleArray);


           }

//           // kötü örnek
//    public void print(Integer[] arr){
//
//    }
//
//    public void print(Double[] arr){
//
//    }

    //data türnden bağımsız bir method yazmamızlazım
    public <T> void print(T[] arr){
        for(T t: arr){
            System.out.println(t);
        }
    }
}

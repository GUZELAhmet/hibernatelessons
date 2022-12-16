package AdvJavaPractice.Generics.Method;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        String[] stdList={"Rafael","Donatello","Leonardo","Michelangelo"};
        Double[] pointList={95.5,70.0,65.6,58.0};
        Character[] gradeList={'A','B','C','B'};

        //1-tüm listeleri yazdır
printArray(stdList);
        System.out.println();
printArray(pointList);
        System.out.println();
printArray(gradeList);

        //2-öğrencileri isimlerine göre sıralayınız

        System.out.println(Arrays.toString(orderArr(stdList)));


        //3-öğrenci notlarını sıralayınız

        System.out.println(Arrays.toString(orderArr(pointList)));
        System.out.println();
        //4-öğrenci harf notlarını sıralayınız
        System.out.println(Arrays.toString(orderArr(gradeList)));
        System.out.println();
    }
    //-diziyi yazdıran bir method yazınız.
public static <T> void printArray(T[] Array){
        for(T t : Array){
            System.out.println(t+" ");
        }

}


    //-diziyi artan sıralayan bir method yazınız.
    public static <T extends Comparable<T>>  T[] orderArr(T[] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if(array[i].compareTo(array[j])>0){
                    T temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }

        }

return array;

    }


}

package Generics.Bounding;

public class GenericUpperBound<T extends  Number> {// parentı number olan tüm childlerini kullanabilirim
private T[] numberArray;

public GenericUpperBound(T[] numberArray) {
    this.numberArray = numberArray;

}
//array içindeki değerlerin ortalamasını bulan method
    public double getAverage(){
    double sum = 0;
    for (T t : numberArray) {
        sum += t.doubleValue();
    }
    double avg = sum / numberArray.length;
    return avg;
    }

    public static void main(String[] args) {
       Integer[] intArray ={2,4,7,9,33};
        GenericUpperBound<Integer> obj1=new GenericUpperBound<>(intArray);
        System.out.println(obj1.getAverage());

        Double[] doubleArray = {2.5,5.6,9.5};
        GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubleArray);
        System.out.println(obj2.getAverage());
        //ClassCastException dan bizi korur 
        //String[] strArray ={"Java", "Çok" ,"kolay", "hele", "java" ,"tadından", "yenmez"};
       // GenericUpperBound<String> obj3=new GenericUpperBound<>(strArray);

    }

}

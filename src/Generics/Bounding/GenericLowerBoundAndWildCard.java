package Generics.Bounding;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCard {
    public static void main(String[] args) {
//addElements methodu*************************************
        List<Object> ol = new ArrayList<>();
        addElements(ol);
        List<Number> nl = new ArrayList<>();
        addElements(nl);
//List<Double> dl=new ArrayList<>();
//addElements(dl);//CTE  generic öncesi yapılarda  runtime error olurdu generic ile beraber compile

        //***********printElements methodu**************************
//        List<String> st=new ArrayList<>();
//        printElements(st);              alt satır ile aynı işlem
        printElements(new ArrayList<String>());

        //***********pritObj *******************************************
        List<String> strList=new ArrayList<>();
       // printObj(strList);  //CTE
    }

    //super Integer---> bana Integerin parentlerini getir (lowerbound bu)
    public static void addElements(List<? super Integer> list) {
        //? WildCard(tipi bilinmeyen )

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

    }

    //WildCard Sınırlamaları...
    public static void printElements(List<?> listOfUnknown) {
        // listOfUnknown.add("Java");  ? den dolayı data türü netleşmeden add methodu gibi işlemleri yaptırmaz
        // listOfUnknown.add(5);
        listOfUnknown.add(null);// illa eklenecekse null eklenebilir
        for (Object o : listOfUnknown) {
            System.out.println(o);
        }
    }
    //? ---> Object
    public static void printObj(List<Object> listOfObject){
        listOfObject.add("java");   // yukarıda object yazdığımız için  add methodu çalışır
        for (Object o : listOfObject) {
            System.out.println(o);
        }
    }

}

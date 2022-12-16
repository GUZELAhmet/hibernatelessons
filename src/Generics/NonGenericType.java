package Generics;

public class NonGenericType {
    private Object o;

// getters and setters
    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
    // main methods
    public static void main(String[] args) {
        NonGenericType obj1=new NonGenericType();
        NonGenericType obj2=new NonGenericType();

        obj1.setO("mirac");// string ile set edildi
        obj2.setO(65);//int değer atandı

        String str1= (String) obj1.getO();// !!! CAST problemi
        System.out.println(str1);

        String str2= (String) obj2.getO(); //ClassCastException
                                            // runTimeExcepiton atar


        //String.valueOf(obj2.get);
        //Integer.parseInt(String)




    }
}

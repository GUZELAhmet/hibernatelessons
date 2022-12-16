package AdvJavaPractice.Generics.serialization;

import java.io.*;

//Book tipinde nesler üretip bu nesleri  books.txt dosyasına kaydedin ve
// daho sonra bu dosyadan nesneleri okuyun
public class SerializationPractice {
    public static void main(String[] args) {
//writeObject();
        readObject();
    }


    public static void writeObject(){
        Book book1=new Book("Sefiller","Victor Hugo",1945);
        Book book2=new Book("Suç ve ceza ","Dostayevski",1985);
        Book book3=new Book("Savaş ve Barış","Tolstoy",1988);



        try {
            FileOutputStream    fos = new FileOutputStream("books.txt");//nesnelerş yazdıraccağımız doyayı yazdırmak için
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            oos.writeObject(book1);
            oos.writeObject(book2);
            oos.writeObject(book3);

            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void readObject(){


        try {
            //nesneleriin bulunduğu dosyayı okur
            FileInputStream fis =new FileInputStream("books.txt");
           //nesneleri doyadan okur
            ObjectInputStream ois =new ObjectInputStream(fis);
            Book book1=(Book)ois.readObject();
            Book book2=(Book)ois.readObject();
            Book book3=(Book)ois.readObject();
            System.out.println("book1 = " + book1);
            System.out.println("book2 = " + book2);
            System.out.println("book3 = " + book3);
            ois.close();
            fis.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

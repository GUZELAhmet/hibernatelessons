package Serialization;

import java.io.*;

public class Serialzation_Deserialization {
    public static void main(String[] args) {

//writeOject();//serialization
        readObjects();//desarialization
    }
//writeOject
    private static void writeOject(){
        System.out.println("User objeleri oluşturuluyor");
        User user1=new User(1L,"Yunus","12345678911");
        User user2=new User(2L,"Yusuf","12365748911");
        User user3=new User(3L,"Betül","56874654654");

       try (FileOutputStream fos=new FileOutputStream("user.dat");){//bu dosya yazmak için
         try(  ObjectOutputStream oos=new ObjectOutputStream(fos);){// bu obje yazmak için
             oos.writeObject(user1);
             oos.writeObject(user2);
             oos.writeObject(user3);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }       }

    //readObject
    private static void readObjects(){
        // javada File işlemlerinde okuma işlemi yaparken FileInputStream klası kullanılır
      try(  FileInputStream fis = new FileInputStream("user.dat");){
          try(ObjectInputStream ois = new ObjectInputStream(fis);){
              User user1=(User) ois.readObject();
              User user2=(User) ois.readObject();
              User user3=(User) ois.readObject();
              System.out.println(user1);
              System.out.println(user2);
              System.out.println(user3);


          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }catch (FileNotFoundException e){
              throw new RuntimeException(e);
          }
      }catch (IOException e){
        e.printStackTrace();}

    }     }

//User clasının transfer edebilmek için implement eettik
class User implements Serializable{

    // private field
    private Long id;
    private String name;
    private String tcKimlikNo;

    // constructor
    public User(Long id, String name, String tcKimlikNo) {
        this.id = id;
        this.name = name;
        this.tcKimlikNo = tcKimlikNo;
    }
    //Gettr Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

        public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcKimlikNo='" + tcKimlikNo + '\'' +
                '}';
    }
}

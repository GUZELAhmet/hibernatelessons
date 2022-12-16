package AdvJavaPractice.Generics.Interfaces;

public class StudentRepo implements Repostry<Student>{

    @Override
    public void add(Student student) {
        System.out.println(student.getName()+" başarıyla kaydedildi");
    }

    @Override
    public void get(Student student) {
        System.out.println(student.getName()+" başarıyla bulundu");
    }

    @Override
    public void update(Student student) {
        System.out.println(student.getName()+" başarıyla güncellendi"+ student.getName()+" update");
    }

    @Override
    public void delete(Student student) {
        System.out.println(student.getName()+" başarıyla silindi");

    }
}

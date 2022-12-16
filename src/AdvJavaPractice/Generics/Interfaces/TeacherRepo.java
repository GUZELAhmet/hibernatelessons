package AdvJavaPractice.Generics.Interfaces;

public class TeacherRepo implements Repostry<Teacher>{
    @Override
    public void add(Teacher teacher) {
        System.out.println(teacher.getName()+"başarıyla kaydedildi");
    }

    @Override
    public void get(Teacher teacher) {
        System.out.println(teacher.getName()+"başarıyla bulundu");

    }

    @Override
    public void update(Teacher teacher) {
        System.out.println(teacher.getName()+"başarıyla güncellendi"+teacher.getName()+" update");

    }

    @Override
    public void delete(Teacher teacher) {
        System.out.println(teacher.getName()+"başarıyla silindi");

    }
}

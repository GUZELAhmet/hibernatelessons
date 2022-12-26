package AdvJavaPractice.Generics.Interfaces;

import java.util.ArrayList;
import java.util.List;
/*Task: Okul yönetimi için öğrenci ve öğretmen kayıtlarını
   -oluşturan
   -görüntüleyen
   -güncelleyen
   -silen
   bir program yazınız.
   her iki sınıf içinde aynı methodlara ihtiyacımız var (add delete....)
   Implement edip bu methodları oluşturabilmek için  ve her iki
    clasın nesnelerini  parametre olarak alabilmek için generic tipte interfcace tanımladık
 */
public class SchoolManagent {
    public static void main(String[] args) {
        Student student = new Student("Tolstoy");
        StudentRepo studentRepo = new StudentRepo();
        Teacher teacher=new Teacher("Dostoyevski");
        TeacherRepo teacherRepo = new TeacherRepo();
        //List<Teacher> teacherList=new ArrayList<>();
        studentRepo.add(student);
        studentRepo.update(student);
        studentRepo.get(student);
        studentRepo.delete(student);
        System.out.println();
        teacherRepo.add(teacher);
        teacherRepo.update(teacher);
        teacherRepo.get(teacher);
        teacherRepo.delete(teacher);







    }

}

package elab.serialization.student;


import elab.serialization.student.Student;

public interface StudentMapper
{
    void addStudent(Student student);

    Student selectStudent(int id);
}
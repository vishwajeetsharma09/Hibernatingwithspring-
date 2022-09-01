package com.klef.jfsd.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.klef.jfsd.configuration.AppConfig;
import com.klef.jfsd.model.Student;
import com.klef.jfsd.service.StudentDAO;

public class ClientController 
{
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
  StudentDAO dao = context.getBean(StudentDAO.class);
  
  public static void main(String[] args) 
  {
    ClientController controller = new ClientController();
    controller.AddStudentRecord();
    //controller.UpdateStudentRecord();
  // controller.DeleteStudentRecord();
   // controller.ViewStudentRecordByID();
    controller.ViewAllStudents();
  }
  public void AddStudentRecord() 
  {
    Student student = new Student();
    student.setName("Rahul");
    student.setGender("MALE");
    student.setDob("25/07/2001");
    student.setDepartment("CSE");
    student.setProgram("B.tech");
    student.setCgpa(9.00);
    student.setBacklogs(0);
    student.setEmailid("rahul@gmail.com");
    student.setContactno("98609304258");
    student.setLocation("Patna");
    
    dao.addStudent(student);
    System.out.println("Student Record added Successfully!!!");
  }
  public void UpdateStudentRecord() 
  {
    //update operation
    Student student = new Student(); 
    student.setId(0);//this must be present in the table
    student.setContactno("8885554417");
    student.setCgpa(9.16);
    student.setBacklogs(0);
    student.setLocation("Hyderabad");
    
    dao.updateStudent(student);
    System.out.println("Student Object Updated Successfully!!!!!");
  }
  public void DeleteStudentRecord() 
  {
    dao.deleteStudent(0);
    System.out.println("Student record deleted successfully!!");
  }
  public void ViewStudentRecordByID() 
  {
    Student student = dao.viewStudentsByID(2);
    if(student!=null) 
    {
      System.out.println(student.toString());
    }
    else {
      System.out.println("Student Object Not Found!!");
    }
  }
  public void ViewAllStudents() 
  {
    List<Student> studentlist = dao.viewAllStudents();
    int count = studentlist.size();
    System.out.println("Total Student Records: "+count);
    if(count>0) {
      for(Student s: studentlist) {
        System.out.println(s.toString());
      }
    }
    else 
    {
      System.out.println("Student Data Found");
    }
  }
}
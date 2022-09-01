package com.klef.jfsd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.klef.jfsd.model.Student;

@Transactional
public class StudentDAOImpl implements StudentDAO
{
  private HibernateTemplate hibernateTemplate;
  public HibernateTemplate getHibernateTemplate() {
    return hibernateTemplate;
  }

  public void setHibernateTemplate(HibernateTemplate hibernateTemplate) 
  {
    this.hibernateTemplate = hibernateTemplate;
  }

  @Override
  public void addStudent(Student student) 
  {
    hibernateTemplate.save(student);
  }

  @Override
  public void updateStudent(Student student) 
  {
    //update operation
    Student s = hibernateTemplate.get(Student.class, student.getId());
    
    s.setContactno(student.getContactno());
    s.setCgpa(student.getCgpa());
    s.setBacklogs(student.getBacklogs());
    s.setLocation(student.getLocation());
    
  }  
  
  @Override
  public void deleteStudent(int id) 
  {
    //you can use either load() or get() method
    
    Student student = hibernateTemplate.get(Student.class, id);
    hibernateTemplate.delete(student);
  }

  @Override
  public List<Student> viewAllStudents() 
  {
    List<Student> studentlist = hibernateTemplate.loadAll(Student.class);
    return studentlist;
  }
  
  public Student viewStudentsByID(int id) 
  {
    Student student = hibernateTemplate.get(Student.class, id);
    return student;
  }
  
}
package com.klef.jfsd.model;

import javax.persistence.*;

@Entity
@Table(name = "student_table")
public class Student 
{
  @Id//primary key = unique + not null
  @GeneratedValue //autoGenerated Value
  @Column(name = "student_id")
  private int id;
  @Column(name = "student_name", nullable = false, length = 200)
  private String name;
  @Column(name = "student_gender", nullable = false)
  private String gender;
  @Column(name = "student_dob", nullable = false)
  private String dob;//date of birth
  @Column(name = "student_department", nullable = false)
  private String department;//CSE or ECE or BT
  @Column(name = "student_program", nullable = false)
  private String program;//B.Tech. or M.tech. or Ph.D.
  @Column(name = "student_cgpa", nullable = false)
  private double cgpa;
  @Column(name = "student_backlogs", nullable = false)
  private int backlogs;
  @Column(name = "student_emailid", nullable = false, length = 200)
  private String emailid;
  @Column(name = "student_contactno", nullable = false, length = 200)
  private String contactno;
  @Column(name = "student_location", nullable = false, length = 200)
  private String location;
  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", department="
        + department + ", program=" + program + ", cgpa=" + cgpa + ", backlogs=" + backlogs + ", emailid="
        + emailid + ", contactno=" + contactno + ", location=" + location + "]";
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getDob() {
    return dob;
  }
  public void setDob(String dob) {
    this.dob = dob;
  }
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }
  public String getProgram() {
    return program;
  }
  public void setProgram(String program) {
    this.program = program;
  }
  public double getCgpa() {
    return cgpa;
  }
  public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
  }
  public int getBacklogs() {
    return backlogs;
  }
  public void setBacklogs(int backlogs) {
    this.backlogs = backlogs;
  }
  public String getEmailid() {
    return emailid;
  }
  public void setEmailid(String emailid) {
    this.emailid = emailid;
  }
  public String getContactno() {
    return contactno;
  }
  public void setContactno(String contactno) {
    this.contactno = contactno;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  
  }
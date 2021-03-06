package com.ralph.service;

import com.ralph.domain.Student;

import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
public interface SchoolBaseInfoManager
{
    public void addStudentInfo(Student s);

    public List<Student> findAllStudents();
}

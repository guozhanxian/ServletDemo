package com.ralph.service;

import com.ralph.domain.Student;
import com.ralph.persist.StudentDao;
import com.ralph.persist.StudentDaoImpl;

import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
public class SchoolBaseInfoManagerImpl implements SchoolBaseInfoManager
{
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void addStudentInfo(Student s)
    {
        studentDao.insert(s);
    }

    @Override
    public List<Student> findAllStudents()
    {
        return studentDao.findAllStudents();
    }
}

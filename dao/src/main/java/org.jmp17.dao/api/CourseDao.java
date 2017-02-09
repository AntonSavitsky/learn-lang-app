package org.jmp17.dao.api;


import org.jmp17.model.Course;

import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
public interface CourseDao {
    public Integer add(Course course);
    public List<Course> retrieveAll();
    public void remove(Integer id);
    public Course retrieve(Integer id);
}

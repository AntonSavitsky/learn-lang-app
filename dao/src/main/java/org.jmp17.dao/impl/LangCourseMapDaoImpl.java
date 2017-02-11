package org.jmp17.dao.impl;

import org.jmp17.dao.api.CourseDao;
import org.jmp17.model.LangCourse;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Component
public class LangCourseMapDaoImpl implements CourseDao<LangCourse> {
    private Map<Integer, LangCourse> langCourseData;
    private static int lastIndex;

    public void setLastIndex(int lastIndex) {
        LangCourseMapDaoImpl.lastIndex = lastIndex;
    }

    public Map<Integer, LangCourse> getLangCourseData() {
        return langCourseData;
    }

    public void setLangCourseData(Map<Integer, LangCourse> langCourseData) {
        this.langCourseData = langCourseData;
    }

    public Integer add(LangCourse langCourse) {
        langCourse.setId(++lastIndex);
        langCourseData.put(lastIndex, langCourse);
        return lastIndex;
    }

    public Map<Integer, LangCourse> retrieveAll() {
        return langCourseData;
    }

    public void remove(Integer id) {
        langCourseData.remove(id);
    }

    public LangCourse retrieve(Integer id) {
        return langCourseData.get(id);
    }
}

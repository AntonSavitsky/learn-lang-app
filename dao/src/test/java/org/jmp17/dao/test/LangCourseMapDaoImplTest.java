package org.jmp17.dao.test;

import org.jmp17.dao.impl.LangCourseMapDaoImpl;
import org.jmp17.dao.test.config.LangCourseListDaoImplTestConfig;
import org.jmp17.model.LangCourse;
import org.jmp17.model.Topic;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by antonsavitsky on 2/11/17.
 */
@ContextConfiguration(classes = LangCourseListDaoImplTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LangCourseMapDaoImplTest {

    @Autowired
    private ApplicationContext applicationContext;
    private LangCourseMapDaoImpl langCourseMapDaoImpl;

    public static final int initialListSize = 1;

    @Before
    public void initContext(){
        langCourseMapDaoImpl = applicationContext.getBean(LangCourseMapDaoImpl.class);
    }

    @Test
    public void testAdd(){
        LangCourse langCourse = new LangCourse("Conversational language",
                Arrays.asList(new Topic("Basic glossary", "This is to make you familiar with basic terms", new ArrayList<org.jmp17.model.Test>())),
                "English");

        int addIndex = langCourseMapDaoImpl.add(langCourse);
        assertEquals(initialListSize + 1, addIndex);
        assertEquals(initialListSize + 1, langCourseMapDaoImpl.getLangCourseData().size());
    }

    @Test
    public void testRetrieveAll(){
        Map<Integer, LangCourse> allCourses = langCourseMapDaoImpl.retrieveAll();
        assertEquals(initialListSize, allCourses.size());
    }

    @Test
    public void testRemove(){
        langCourseMapDaoImpl.remove(1);
        assertEquals(initialListSize -1, langCourseMapDaoImpl.getLangCourseData().size());
    }

    @Test
    public void testRetrieve(){
        LangCourse langCourse = langCourseMapDaoImpl.retrieve(1);
        assertNotNull(langCourse);
        assertEquals(1, langCourse.getId().intValue());
    }
}

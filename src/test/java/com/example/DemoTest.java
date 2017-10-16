package com.example;

import com.example.dao.PublisherMapper;
import com.example.dao.UserDao;
import com.example.model.Publisher;
import com.example.model.User;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Rollback
public class DemoTest {

    @Autowired
    PublisherMapper publisherMapper;  // Mybatis generated bean

    @Autowired
    UserDao userDao;

    @Test
    public void findPublishers() {
        System.out.println(publisherMapper.getClass().getName());
        List<Publisher> publishers = publisherMapper.findAll();
        for (Publisher publisher : publishers) {
            System.out.println(publisher);
            assertThat(publisher.getName(), is(not(nullValue())));
        }
        assertThat(publishers.size(), is(greaterThan(0)));
    }

    @Test
    public void findsSomeUsers() {
        List<User> allUsers = userDao.findOrderedUsers();
        for (User user : allUsers) {
            System.out.println(user);
            assertThat(user.getUserName(), is(not(nullValue())));
        }
        assertThat(allUsers.size(), is(greaterThan(0)));
        assertEquals(4, allUsers.size());
    }

    @Test
    public void findsOneUser() {
        User user = userDao.findOne(1);
        assertEquals(user.getUserName(), "credmond");
    }

    @Test
    @Transactional
    public void saveUsers() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = formatter.parse("10/13/2017");

        User chuckNorris = User.builder()
                .userName("chuck")
                .firstName("Chuck")
                .lastName("Norris")
                .activeOn(date)
                .build();

        userDao.save(chuckNorris);

        List<User> users = userDao.findOrderedUsers();
        User chuck = users.stream()
                .filter(user -> user.getUserName().equals("chuck"))
                .findFirst()
                .orElse(null);

        assertNotNull(chuck);
        assertEquals(chuck.getLastName(), "Norris");

    }

    @Test
    @Transactional
    public void deleteUser() throws ParseException {
        userDao.delete(2);

        List<User> allUsers = userDao.findOrderedUsers();

        assertEquals(allUsers.size(), 3);

    }

}

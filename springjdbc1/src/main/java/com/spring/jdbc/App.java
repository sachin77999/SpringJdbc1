package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program started..........." );
        // spring jdbc -> JdbcTemplate 
        
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
		/*
		 * JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * 
		 * 
		 * // insert query
		 * 
		 * String query ="insert into student(id,name,city) values(?,?,?)";
		 */
        // fire query 
		/*
		 * int result = template.update(query,1,"Uttam Kumar","Kanpur");
		 * System.out.println("number of records inserted.." + result);
		 */
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
         Student student = new Student();
         student.setId(41);
         student.setName("Sachin");
         student.setCity("Lucknow");
         
         int result = studentDao.insert(student);
         System.out.println("student added "+result);
         
    }
}

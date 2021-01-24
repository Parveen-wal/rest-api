/**
 * 
 */
package com.javatechnie.spring.mysql.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechnie.spring.mysql.api.model.Student;

/**
 * @author Dell PC
 *
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

	

}

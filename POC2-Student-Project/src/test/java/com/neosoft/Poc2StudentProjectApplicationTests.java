package com.neosoft;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.neosoft.Model.Project;
import com.neosoft.Model.Student;
import com.neosoft.Repository.ProjectRepository;
import com.neosoft.Repository.StudentRepository;

@SpringBootTest
class Poc2StudentProjectApplicationTests {
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void findProjectById() {
		Assert.notNull(projectRepository.findById(1));
	}
	
	@Test
	void addProject() {
		Student st=new Student(1,"Saurabh","Dharamkar","8987898789","sd@gmail.com");
	Project project=new Project(10,"Bank","6 month",st);
	Assert.notNull(projectRepository.save(project));
	}
	
	@Test
	void  updateProject() {
     Student st=new Student(1,"Saurabh","Dharamkar","8987898789","sd@gmail.com");
	Project project=new Project(10,"Bank","6 month",st);
	Assert.notNull(projectRepository.save(project));
	}
	
	@Test
	void deleteProjectById() {
	     projectRepository.deleteById(3);
		assertThat(projectRepository.existsById(3)).isFalse();
	}
	
	@Test
	void addStudent() {
		
	Student student=new Student(40,"Rohit","Kumar","9878987898","rohit@gmail.com");
	Assert.notNull(studentRepository.save(student));
	}
	
	@Test
	void updateStudent() {
		
	Student student=new Student(20,"Rohit","Kumar","9878987898","rohit@gmail.com");
	Assert.notNull(studentRepository.save(student));
	}
	
	@Test
	void findStudentById() {
		Assert.notNull(studentRepository.findById(16));
	}
	
	@Test
	void findProjectByStudentId() {
		Assert.notNull(projectRepository.findProjectByStudentId(4));
	}
	
	
	@Test
	void deleteStudentById() {
		studentRepository.deleteById(3);
		assertThat(studentRepository.existsById(3)).isFalse();
	}
	

}

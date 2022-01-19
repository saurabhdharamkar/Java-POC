package com.neosoft.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoft.Model.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

	@Query("from Project p where p.student.studentId=?1")
	List<Project> findProjectByStudentId(int studentId);

}

package com.neosoft.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Model.Project;
import com.neosoft.Model.Student;
import com.neosoft.Service.ProjectService;
import com.neosoft.Service.StudentService;

@RestController
//@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/addProject")
	public Project addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}
	
	@PutMapping("/updateProject")
	public Project updateProject(@RequestBody Project project,@PathVariable("projectId")int projectId) {
		Optional<Project> check=projectService.findProjectById(projectId);
		 if(check.isPresent()) {
			 
		 
			project.setProjectId(projectId);
		
		 projectService.addProject(project);
		 }
		return project;
	}

	
	@GetMapping("/getAllProjects")
	public List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	
	@GetMapping("/getProjectById/{projectId}")
	public Optional<Project> getProjectById(@PathVariable("projectId")int projectId){
		
		return projectService.findProjectById(projectId);
	}
	
	
	@DeleteMapping("/deleteProjectById/{projectId}")
	public void deleteProject(@PathVariable("projectId")int projectId) {
		
		projectService.deleteProjectById(projectId);
		
	}
	
	@GetMapping("/getProjectByStudentId/{studentId}")
	public List<Project> getProjectByStudentId(@PathVariable("studentId")int studentId){
		
		return projectService.findProjectByStudentId(studentId);
	}
	
	@PostMapping("/assignProjectToStudent/{studentId}")
	public Project assignProject(@PathVariable int studentId,@RequestBody Project project) {
		Student st=studentService.getStudentById1(studentId);
		project.setStudent(st);
		return projectService.addProject(project);
		
	}
}

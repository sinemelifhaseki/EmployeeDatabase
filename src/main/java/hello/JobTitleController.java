package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class JobTitleController {
	
		Logger log = LoggerFactory.getLogger(JobTitleController.class);
		
		@Autowired 
		private JobTitleRepo jobTitleRepo;
		@Autowired
		private EmployeeRepo employeeRepo;
		
	    @GetMapping("/jobtitle")
	    public String jobTitleForm(Model model) {
	        model.addAttribute("jobtitle", new JobTitle());
	        return "jobtitle";
	    }
	    
	    @PostMapping("/jobtitle")
	    public String jobTitleSubmit(@ModelAttribute JobTitle jobtitle) {
			
			JobTitleEntity entity = new JobTitleEntity();
			entity.setTitle(jobtitle.getTitle());
			entity.setDescription(jobtitle.getDescription());
			entity.setExecutive(jobtitle.getExecutive());
			System.out.println(jobtitle.toString());
			jobTitleRepo.save(entity);
			//return ResponseEntity.ok(entity);
			log.info(jobtitle.toString());
			return "redirect:/jobtitlelist";
		}
	    
	    @GetMapping("/jobtitlelist")
	    public String jobTitleList(Model model) {
	    	Iterable<JobTitleEntity> jobtitles =  jobTitleRepo.findAll();
	    	model.addAttribute("jobtitles",jobtitles);
	        return "jobtitlelist";
	    }
	    
	    @PostMapping("/employee")
	    public String addEmployee(@ModelAttribute Employee employee) {
	    	EmployeeEntity entity = new EmployeeEntity();
	    	entity.setName(employee.getName());
	    	entity.setSurname(employee.getSurname());
	    	entity.setAge(employee.getAge());
	    	entity.setIncome(employee.getIncome());
	    	
	    	entity.setJobtitle(jobTitleRepo.findById(employee.getJobtitleid()).get());
	    	employeeRepo.save(entity);
	    	log.info(employee.toString());
	    	
	    	return "redirect:/employee";
	    }
	    
	    @GetMapping("/employee")
	    public String employeeList(Model model) {
	    	Iterable<EmployeeEntity> employees =  employeeRepo.findAll();
	    	model.addAttribute("employees",employees);
	    	model.addAttribute("employee",new Employee());
	    	model.addAttribute("jobtitles", jobTitleRepo.findAll());
	        return "employee";
	    }
	    
	    //delete ekle
	   
	}

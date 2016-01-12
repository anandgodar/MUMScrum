package com.scrum.portal.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum.portal.dto.Employee;
<<<<<<< HEAD
import com.scrum.portal.dto.Product;
import com.scrum.portal.dto.Sprint;
=======
import com.scrum.portal.dto.ProductBackLogUserStory;
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35
import com.scrum.portal.dto.User;
import com.scrum.portal.dto.UserStoryEffortLog;
import com.scrum.portal.repositories.EmployeeRepository;
<<<<<<< HEAD
import com.scrum.portal.repositories.ProductRepository;
=======
import com.scrum.portal.repositories.ProductBackLogRepository;
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35
import com.scrum.portal.repositories.SprintRepository;
import com.scrum.portal.repositories.UserRepository;
import com.scrum.portal.repositories.UserStoryEffortLogRepository;



@Service
public class InitDB {

	@Autowired
	UserRepository userRepository;
	@Autowired
	SprintRepository sprintRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProductBackLogRepository productBackLogRepository;
	
	@Autowired
	private UserStoryEffortLogRepository userStoryEffortLogRepository;
	
	@PostConstruct
	public void init(){

		ProductBackLogUserStory p1 = new ProductBackLogUserStory(1001, 103, "userstory3", 100, 100, 0, 0, 984664, 984664, true, "not completed",2001,4001);
		ProductBackLogUserStory p2 = new ProductBackLogUserStory(1001, 102, "userstory2", 200, 200, 0, 0, 984664, 984664, true, "not completed",2001,4001);
		ProductBackLogUserStory p3 = new ProductBackLogUserStory(1001, 101, "userstory1", 300, 300, 0, 0, 984664, 984664, true, "not completed",2001,4001);
		ProductBackLogUserStory p4 = new ProductBackLogUserStory(1001, 104, "userstory4", 100, 100, 0, 0, 984664, 984664, true, "not completed",2001,4001);
		ProductBackLogUserStory p5 = new ProductBackLogUserStory(1001, 105, "userstory5", 100, 100, 0, 0, 984664, 984664, true, "not completed",2001,4001);
		
		productBackLogRepository.save(p1);
		productBackLogRepository.save(p2);
		productBackLogRepository.save(p3);
		productBackLogRepository.save(p4);
		productBackLogRepository.save(p5);
		
		UserStoryEffortLog u1 = new UserStoryEffortLog(984664, 103, 20, 0, 1);
		UserStoryEffortLog u2 = new UserStoryEffortLog(984664, 103, 40, 0, 2);
		UserStoryEffortLog u3 = new UserStoryEffortLog(984664, 102, 40, 0, 1);
		UserStoryEffortLog u4 = new UserStoryEffortLog(984664, 102, 40, 0, 2);
		
		userStoryEffortLogRepository.save(u1);
		userStoryEffortLogRepository.save(u2);
		userStoryEffortLogRepository.save(u3);
		userStoryEffortLogRepository.save(u4);
		
		/*Sprint s1= new Sprint("Sprint 1","This is Sprint 1");
		Sprint s2= new Sprint("Sprint 2","This is sprint 2");
		Sprint s3= new Sprint("Sprint 3","This is sprint 3");
		Sprint s4= new Sprint("Sprint 4"," This is sprint 4");
		
		sprintRepository.save(s1 );
		sprintRepository.save(s2 );
		sprintRepository.save(s3 );
		sprintRepository.save(s4 );*/
		
		
		
		Product p1= new Product("Mum Scrum","Product one");
		Product p2= new Product("Dad Scrum","This is sprint 2");
		Product p3= new Product("Daughter Scrum","This is sprint 3");
	
		productRepository.save(p1 );
		productRepository.save(p2 );
		productRepository.save(p3 );
		
		
		
		Employee empDto = new Employee();
		User userDto = new User();

		File file = new File("C:\\Users\\vasanthbabu\\SpringWorkspace\\ScrumTool\\property\\HRDeatils.properties");
		
		System.out.println(file.getAbsolutePath());
		
		FileInputStream fin;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line;
			while ((line = reader.readLine()) != null) {
				String[] strArr = line.split(",");

				userDto.setUserName(strArr[0]);
				userDto.setPassword(strArr[1]);
				userDto.setRoleID(Integer.parseInt(strArr[2])); // setting role

				empDto.setFirstName(strArr[3]);
				empDto.setLastName(strArr[4]);
				empDto.setEmail(strArr[5]);
				empDto.setEmployeeID(Integer.parseInt(strArr[6]));
				empDto.setStreet(strArr[7]);
				empDto.setState(strArr[8]);
				empDto.setCity(strArr[9]);
				empDto.setCountry(strArr[10]);
				empDto.setZip(strArr[11]);

				empDto.setUser(userDto);

				userDto.setEmployee(empDto);

				System.out.println("HR "+strArr[0] +" created");
				employeeRepository.save(empDto);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}

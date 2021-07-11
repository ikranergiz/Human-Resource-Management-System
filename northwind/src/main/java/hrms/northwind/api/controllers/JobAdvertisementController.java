package hrms.northwind.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.northwind.business.abstracts.JobAdvertisementService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/findByIsActive")
	public DataResult<List<JobAdvertisement>> findByIsActive(@RequestParam boolean isActive){
		return this.jobAdvertisementService.findByIsActive(isActive);
	}
	
	@PostMapping("/add")
	public Result addJobAdvertisement(@RequestBody JobAdvertisement jobadvertisement) {
		return this.jobAdvertisementService.addJobAdvertisement(jobadvertisement);
	}
	
	@GetMapping("/findByCreationDateAndIsActive")
	public DataResult<List<JobAdvertisement>> findByCreationDateAndIsActive
	(@RequestParam int year ,@RequestParam int month ,@RequestParam int day, @RequestParam boolean isActive) {
		return this.jobAdvertisementService.findByCreationDateAndIsActive(LocalDate.of(year, month, day), isActive);
	}
	
	@GetMapping("/getByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName
	(@RequestParam boolean isActive,@RequestParam String companyName) {
		return this.jobAdvertisementService.getByIsActiveAndEmployer_CompanyName(isActive, companyName);
	}
	
	@PutMapping("/updateIsActive")
	public Result updateIsActive(int jobAdvertisementId, boolean isActive) {
		return this.jobAdvertisementService.updateIsActive(jobAdvertisementId,isActive);
	}
	
	
	
	
	
}


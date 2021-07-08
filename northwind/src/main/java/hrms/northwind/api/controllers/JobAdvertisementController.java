package hrms.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive){
		return this.jobAdvertisementService.getByIsActive(isActive);
	}
	
	@PostMapping("/add")
	public Result addJobAdvertisement(@RequestBody JobAdvertisement jobadvertisement) {
		return this.jobAdvertisementService.addJobAdvertisement(jobadvertisement);
	}
	
	
}

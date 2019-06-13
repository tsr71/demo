package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.Stock;
import com.example.demo.db.StockRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class StockController {
	@Autowired
	private StockRepository repo;
	  @Autowired
	    @Lazy
	    private EurekaClient eurekaClient;		
	
	 @PostConstruct 
	 public void init() { 
		 Stock s1=new Stock(); 
		 Stock s2=new Stock(); 
		 s1.setSymbol("F"); s1.setCompany("Ford"); s1.setPrice(60.00);
		 s2.setSymbol("BA"); s2.setCompany("Boeing"); s2.setPrice(110.00);
	  
		 repo.save(s1); repo.save(s2);
	 
	 }
	

	@RequestMapping("/stocks/{id}")
	public Stock findStock(@PathVariable(value = "id") String id) {
		return repo.findById(id).get();

	}

	@RequestMapping("/stocks/")
	public Stock findStockBySymbol(@RequestParam("symbol") String s) {

		return repo.findBySymbol(s);

	}

	@RequestMapping("/stocks")
	public List<Stock> stocks() {
		return repo.findAll();
	}
	
	@RequestMapping("/service-lookup/{sname}")
	public List<InstanceInfo> serviceLookup(@PathVariable(value = "sname") String name){
		return this.eurekaClient.getApplication(name).getInstances();
	}
	
	@RequestMapping("/registry")
	public List<InstanceInfo> registry(){
		List<InstanceInfo> result=new ArrayList<InstanceInfo>(10);
		List<Application> apps=this.eurekaClient.getApplications().getRegisteredApplications();
		for(Application app:apps) {
			result.addAll(app.getInstances());
		}
		return result;
	}	

}

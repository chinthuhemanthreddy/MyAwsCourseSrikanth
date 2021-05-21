package com.organization.Btech.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.Btech.daomodel.ASPGrounding;
import com.organization.Btech.model.UpdateGroundDetails;
import com.organization.Btech.services.ASPGroundingService;

@RestController
public class ASPGroundingController {

	@Autowired
	private ASPGroundingService aspGroundingService;
	@PostMapping("/getGroundingDetails")
    public List<ASPGrounding> getGroundingdetails() {
		System.out.println("ASPGroundingController contorller");
		List<ASPGrounding> aspGrounding=	aspGroundingService.getGroundingdetails();
        return aspGrounding;
    }
	
	
	@PostMapping("/updateGroundingDetails")
    public String updateGroundingDate(@RequestBody UpdateGroundDetails updateGroundDetails) {
		System.out.println("ASPGroundingController contorller "+updateGroundDetails);
		System.out.println("updateGroundingDate method");
		int recordsUpdated =	aspGroundingService.updateGroundingDate(updateGroundDetails);
		System.out.println("records updated ::: "+recordsUpdated);
		String returnString = "Not updated sucessfuly";
		if( recordsUpdated > 0 ) {
			returnString =  "Updated sucessfuly";
		}
        return returnString;
    }
}

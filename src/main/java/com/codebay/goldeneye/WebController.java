package com.codebay.goldeneye;

import java.util.Hashtable;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codebay.goldeneye.WebApplication;

@Controller
public class WebController {  
	Hashtable<Integer, String> htOffice = new Hashtable<Integer, String>();
	Hashtable<Integer, String> htDept = new Hashtable<Integer, String>(); 
	
    @GetMapping("/")
    public String index() {
    	loadData();
        return "index";
    }
    
    @PostMapping("/saveDetails")                     
    public String saveDetails(@RequestParam("user1") String userName,
                              @RequestParam("user2") String userName2,
                              @RequestParam("office") String office,
                              @RequestParam("dept") String department,
                              ModelMap modelMap) {
    	
    	
    	
    	String formEmail = formatEmail(userName,userName2,department,office);
        
        modelMap.put("Name", userName);
        modelMap.put("Surname", userName2);
        modelMap.put("Office", office);
        modelMap.put("Department", department);
        modelMap.put("Email", formEmail);
        return "emailFormat";           
    }
    
    private String formatEmail(String userName,String userName2, String dept, String office) {
    	String result = "";

    	String fName = userName.trim().toLowerCase();
    	fName = fName.substring(0,1);
    	String sName = userName2.trim().toLowerCase();
    	
    	String officeName = getOffice(Integer.parseInt(office));
    	String depName = getDepartment(Integer.parseInt(dept));
    	officeName = cleanString(officeName);
    	depName = cleanString(depName);
    	
    	result = fName+sName+"."+depName.trim().toLowerCase()+"@"+officeName.trim().toLowerCase()+".goldeneye.com";


    	return result;
    }
    
    private String getOffice(int officeId) {
    	String res = htOffice.get(officeId);
    	return res;
    }
    
    private String getDepartment(int deptId) {
    	String res = htDept.get(deptId);
    	
    	return res;
    }
    
    private String cleanString(String name) {
    	
    	name = name.replace("&", "");
    	name = name.replace(" ", "");
    	name = name.trim().toLowerCase();
    	
    	return name;
    }
    
    private void loadData() {

    	htOffice.put(1, "Milan"); 
    	htOffice.put(2, "Spain"); 
    	htOffice.put(3, "New York"); 
	
    	htDept.put(1, "Design"); 
    	htDept.put(2, "Business"); 
    	htDept.put(3, "Advertising"); 
    	htDept.put(4, "Research & development"); 

    }
}

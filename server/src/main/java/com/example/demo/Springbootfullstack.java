package com.example.demo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.User;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@CrossOrigin(maxAge = 3600)
@RestController
public class Springbootfullstack {
	
	@RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }
	
	

    @CrossOrigin("http://localhost:3000")
	@PostMapping("/post")
	public String userpost(@RequestBody User user ) {
		SpannerOptions options = SpannerOptions.newBuilder().build();
        Spanner spanner = options.getService();
    	DatabaseId db = DatabaseId.of(options.getProjectId(), "test23", "user-db");
    	 DatabaseClient dbClient = spanner.getDatabaseClient(db);
    	 String clientProject = spanner.getOptions().getProjectId();
    	  if (!db.getInstanceId().getProject().equals(clientProject)) {
    	        System.err.println("Invalid project specified. Project in the database id should match"
    	            + "the project name set in the environment variable GCLOUD_PROJECT. Expected: "
    	            + clientProject);
    	        
    	      }
    	  ResultSet resultSet =
   	            dbClient
   	                .singleUse()
   	                .read("Users",
   	                    // KeySet.all() can be used to read all rows in a table. KeySet exposes other
   	                    // methods to read only a subset of the table.
   	                    KeySet.all(),
   	                    Arrays.asList("username", "password"));
   	        while (resultSet.next()) {
   	        	
   	        	if(user.getUsername().equals(resultSet.getString(0))) {
   	        		System.out.println("username already exist");
   	        		return "false";
   	        		
   	        		
   	        	}
   	        	
   	         System.out.println(
   	               resultSet.getString(0) +" "+ resultSet.getString(1));
   	         
   	        }
   	      
   	      
   	     List <Mutation>  mutations = new ArrayList<>();
         
         mutations.add(
             Mutation.newInsertBuilder("Users")
                 .set("username")
                 .to(user.getUsername())
                 .set("password")
                 .to(user.getPassword())
                 .build());
      
    
       dbClient.write(mutations);
       System.out.println(user.getUsername()+" has been added to database");
       return "true";
   
   	    } 
    	  
   
    @CrossOrigin("http://localhost:3000")
    @PostMapping("/request")
    public String usercheck(@RequestBody User user ) {
    	System.out.println(user.getUsername()+" "+user.getPassword());
    	
    	
    	SpannerOptions options = SpannerOptions.newBuilder().build();
        Spanner spanner = options.getService();
    	DatabaseId db = DatabaseId.of(options.getProjectId(), "test23", "user-db");
    	 DatabaseClient dbClient = spanner.getDatabaseClient(db);
    	 String clientProject = spanner.getOptions().getProjectId();
    	  if (!db.getInstanceId().getProject().equals(clientProject)) {
    	        System.err.println("Invalid project specified. Project in the database id should match"
    	            + "the project name set in the environment variable GCLOUD_PROJECT. Expected: "
    	            + clientProject);
    	        
    	      }
 	     ResultSet resultSet =
 	            dbClient
 	                .singleUse()
 	                .read("Users",
 	                    // KeySet.all() can be used to read all rows in a table. KeySet exposes other
 	                    // methods to read only a subset of the table.
 	                    KeySet.all(),
 	                    Arrays.asList("username", "password"));
 	        while (resultSet.next()) {
 	        	
 	        	if(user.getUsername().equals(resultSet.getString(0)) && user.getPassword().equals(resultSet.getString(1)) ) {
 	        		return "true";
 	        		
 	        		
 	        	}
 	        	
 	          System.out.println(
 	               resultSet.getString(0) +" "+ resultSet.getString(1));
 	         
 	        }
 	      

 	          spanner.close();
     return "false";
 
 	    } 
 	   
 	
	   
	}


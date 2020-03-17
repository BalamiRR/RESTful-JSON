package com.fuatkara.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fuatkara.model.User;

@Path("/user")    //Bu class disariya acilan bir class demek cunku path kullandik diger siniflarda yok.
public class UserService {
	
	//http://localhost:8080/RESTful-JSON/user/information/1/Balamir/Kizil.xml
	
	@GET     //Bu classa @GET annotation i yaparak ulasabiliriz.
	@Path("/information/{id}/{name}/{surname}.xml")		
	@Produces(MediaType.APPLICATION_XML)  //Bu bize Postman da kullanirken localhosta girdigimizde JSON dosyasi olarak karsimiza cikaricak.
	public Response getUserInformationXml(
			@PathParam("Id") Integer Id,
			@PathParam("name") String name,
			@PathParam("surname") String surname){ //idParameter yukaridaki Path'den geldigi icin @PathParameter diyoruz. 
													//Birde int yaptik cunku biz bu idParameter'i java degiskenine atayacagiz, o da int id'dir. 
		User userObject = new User();
		
		userObject.setUserId(Id);
		userObject.setUserName(name);
		userObject.setUserLastName(surname);
		
		return Response.status(200).entity(userObject).build();
	}
	
	@GET
	@Path("/information/{id}/{name}/{surname}")	 
	public Response getUserInformation(
			@PathParam("Id") Integer Id,
			@PathParam("name") String name,
			@PathParam("surname") String surname){ 
		
		User userObject = new User();
		userObject.setUserId(Id);
		userObject.setUserName(name);
		userObject.setUserLastName(surname);
		
		return Response.status(200).entity(userObject).build();
	}
	
	
	//http://localhost:8080/RESTful-JSON/user/information/1/Balamir/Kizil.json
	@GET     //Bu classa @GET annotation i yaparak ulasabiliriz.
	@Path("/information/{id}/{name}/{surname}.json")		
	@Produces(MediaType.APPLICATION_JSON)  //Bu bize Postman da kullanirken localhosta girdigimizde JSON dosyasi olarak karsimiza cikaricak.
	public Response getUserInformationJson(
			@PathParam("Id") Integer Id,
			@PathParam("name") String name,
			@PathParam("surname") String surname){ //idParameter yukaridaki Path'den geldigi icin @PathParameter diyoruz. 
													//Birde int yaptik cunku biz bu idParameter'i java degiskenine atayacagiz, o da int id'dir. 
		User userObject = new User();
		
		userObject.setUserId(Id);
		userObject.setUserName(name);
		userObject.setUserLastName(surname);
		
		return Response.status(200).entity(userObject).build();
	}
	
	
		//http://localhost:8080/RESTful-JSON/rest/user/information/1/Balamir/Kizil
		@GET     
		@Path("/information/{id}/{name}/{surname}")		
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})  //Burda bize ilk olarak Application_JSON gelir. 
		public Response getUserInformationJsonXml(						   // Cunku ilk parametre
				@PathParam("Id") Integer Id,
				@PathParam("name") String name,
				@PathParam("surname") String surname){ 
			
			User userObject = new User();
			
			userObject.setUserId(Id);
			userObject.setUserName(name);
			userObject.setUserLastName(surname);
			
			return Response.status(200).entity(userObject).build();
		}
		
		//http://localhost:8080/RESTful-JSON/user/information/1
		@GET     //Bu classa @GET annotation i yaparak ulasabiliriz.
		@Path("/information/{idParameter}")							
		public Response getUserInformation( @PathParam("idParameter") Integer id){  
			
			User userObject = new User();
			userObject.setUserId(23);
			userObject.setUserName("Sabahattin");
			userObject.setUserLastName("Kavak");
			
			return Response.status(200).entity(userObject).build();
		
		
	}
}
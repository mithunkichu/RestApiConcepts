package com.seqato.MessengerProject.profile;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResources {
	
	ProfileServices pf = new ProfileServices();
	
	@GET
	public static ArrayList<Profile> getAllProfile()
	{
		return ProfileServices.getAllProfiles();
	}
	
	@POST
	public static Profile addProfile(Profile profile)
	{
		
		return ProfileServices.addProfile(profile);
	}
	
	@GET
	@Path("/{profileId}")
	public static Profile getProfile(@PathParam("profileId") String id)
	{
		return ProfileServices.getProfile(id);
	}
	
	@PUT
	@Path("/{profileId}")
	public static Profile updateProfile(@PathParam("profileId") String id,Profile profile)
	{
		profile.setId(profile.getId());
		return ProfileServices.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileId}")
	public static Profile removeProfile(@PathParam("profileId") String id)
	{
		return ProfileServices.deleteProfile(id);
	}

	
}
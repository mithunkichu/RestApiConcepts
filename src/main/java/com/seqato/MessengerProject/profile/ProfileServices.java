package com.seqato.MessengerProject.profile;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.seqato.MessengerProject.data.DatabaseClass;
import com.seqato.MessengerProject.exception.ErrorMessage;

public class ProfileServices 

{
	public static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileServices()
	{
		profiles.put("mithun", new Profile("mithun",1, "Mithun", "Krish"));
		profiles.put("sabari", new Profile("sabari",2, "sabari", "Krish"));
	}
	
	public static ArrayList<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values());
	}
	
	public static Profile getProfile(String id)
	{
		Profile profile = profiles.get(id);
		ErrorMessage errorMessage = new ErrorMessage("Not Found",404, "www.youtube.com");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
		if(profile== null)
		{
			throw new WebApplicationException(response);
		}
		return profile;
		
	}
	public static Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public static Profile updateProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty())
		{
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public static Profile deleteProfile(String id)
	{
		return profiles.remove(id);
	}
}

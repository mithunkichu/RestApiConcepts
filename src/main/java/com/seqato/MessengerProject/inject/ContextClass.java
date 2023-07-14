package com.seqato.MessengerProject.inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("context")
@Produces(MediaType.TEXT_PLAIN)
public class ContextClass 
{
	@GET
	public String getPath(@Context UriInfo uri)
	{
		String path = uri.getAbsolutePath().toString();
		return path;
		
	}
}

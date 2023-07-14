package com.seqato.MessengerProject.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


public class GenericExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "https://www.youtube.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}

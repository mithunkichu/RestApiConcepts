package com.seqato.MessengerProject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;

import com.seqato.MessengerProject.profile.ProfileResources;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public class MessageResources 

{
	MessageService ms= new MessageService();
	
	    @GET
	   
		public static List<Message> getAllTheMesssages(@BeanParam MessageBeanFilter filter)
		{
	    	if(filter.getYear()>0)
	    	{
	    		return MessageService.getAllMessagebyYear(filter.getYear());
	    	}
	    	if(filter.getStart()>0 && filter.getStart() >0)
	    	{
	    		return MessageService.getAllMessagesPaginated(filter.getStart(), filter.getSize());
	    	}
			return MessageService.getAllMessages();	
		}    
	    @POST
	   
	    public static Response addMessage(Message message,@Context UriInfo uriInfo) 
	    {
	    	Message newMessage = MessageService.addMessage(message);
	    	String newId = String.valueOf(newMessage.getId()); 
	    	URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
	    	return Response.created(uri).entity(newMessage).build();
	    }
	    @GET
	    @Path("/{messageId}")
	    
	    public Message getMessage(@PathParam("messageId") int id,@Context UriInfo uriInfo)
	    {
	    	Message message = ms.getMessage(id);
	    	message.addLink(getUriForSelf(uriInfo, message), "self");
	    	message.addLink(getUriForProfile(uriInfo, message), "self");
	    	message.addLink(getUriForComment(uriInfo, message), "self");
	    	
	    	return message;
	    }
		
	    
		
		@PUT
	    @Path("/{messageId}")
	    
	    public Message upddateMessage(Message message,@PathParam("messageId") int id)
	    {
	    	message.setId(id);
	    	return MessageService.updateMessage(message);
	    }
	    @DELETE
	    @Path("/{messageId}")
	
	    public Message deleteMessage(@PathParam("messageId")int id,Message message)
	    {
	    	message.setId(id);
	    	return MessageService.removeMessage(id);
	    }
	    
	    
	    @Path("/{messageId}/comments")
	    public CommentResource getCommentResource()
	    {
	    	return new CommentResource();
	    }
	    
	    private String getUriForSelf(UriInfo uriInfo, Message message) {
			String uri = uriInfo.getBaseUriBuilder()
	    			.path(MessageResources.class)
	    			.path(Integer.toString(message.getId()))
	    			.build().toString();
	    	
	    	return uri;
		}
	    
	    private String getUriForProfile(UriInfo uriInfo, Message message) {
			
	    String uri = uriInfo.getBaseUriBuilder()
	    	.path(ProfileResources.class)
	    	.path(Integer.toString(message.getId())).build().toString();
	    return uri;
		}
	    private String getUriForComment(UriInfo uriInfo, Message message) 
	    {
	    	
		    String uri = 	uriInfo.getBaseUriBuilder()
		    	.path(MessageResources.class)
		    	.path(MessageResources.class,"getCommentResource")
		    	.path(CommentResource.class)
		    	.resolveTemplate("messageId", message.getId())
		    	.build().toString();
		   return uri;
		}
	    	
    
}

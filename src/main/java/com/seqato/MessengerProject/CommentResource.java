package com.seqato.MessengerProject;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)

public class CommentResource 
{
	
	private CommentService cmtSrvc = new CommentService();
	
	@GET
	public static List<Comment> getAllComments(@PathParam("messageId") int messageId)
	{
	    return  CommentService.getAllComments(messageId);
	}
	@GET
	@Path("/{commentId}")
	public static Comment getComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId)
	{
	    return CommentService.getComment(messageId, commentId);
	}
	@POST
	public static Comment addComment(@PathParam("messageId") int messageId, Comment comment)
	{
		return CommentService.addComment(comment, messageId);
	}
	@PUT
	@Path("/{commentid}")
	public static Comment updateComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId , Comment comment)
	{
		comment.setId(commentId);
		return CommentService.updateComment(comment, messageId);
	}
	@DELETE
	@Path("/{commentId}")
	public static Comment removeComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId)
	{
		return CommentService.removeComment(messageId, commentId);
	}
}

package com.seqato.MessengerProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.seqato.MessengerProject.data.DatabaseClass;
import com.seqato.MessengerProject.exception.ErrorMessage;

import javassist.NotFoundException;

public class CommentService 
{
		
	private static  Map<Integer, Message> messages = DatabaseClass.getMessages();
	private static  Map<Integer, Comment> comments = DatabaseClass.getComments();
	
	Message message = new Message();
	public CommentService()
	{
		comments.put(1,new Comment(1, "java is powerfull", "mithun"));
		comments.put(2,new Comment(2, "Java is Simple", "kichu"));
		message.setComments(comments);
	}
	
	public static List<Comment> getAllComments(int messageid)
	{
		comments  = messages.get(messageid).getComments();
		return new ArrayList<Comment>(comments.values());
		
	}
	public static Comment getComment(int messageId,int commentId)
	{
		ErrorMessage errorMessage = new ErrorMessage("Not Found", 404, "www.youtube.com");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
		Message message = messages.get(messageId);
		if(message==null)
		{
			throw new WebApplicationException(response);
		}
		Map<Integer, Comment> commentss = messages.get(messageId).getComments();
		Comment comment = commentss.get(commentId);
		if(comment == null)
		{
			throw new WebApplicationException(response);
		}
		return comment;
		
	}
	public static Comment addComment(Comment comment ,int messageId)
	{
	    comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	public static Comment updateComment(Comment comment, int messageId)
	{
		 comments = messages.get(messageId).getComments();
		if(comment.getId()<=0)
		{
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	public static Comment removeComment(int messageId, int commentId)
	{
		 comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
	


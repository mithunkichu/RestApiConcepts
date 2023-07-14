package com.seqato.MessengerProject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.seqato.MessengerProject.data.DatabaseClass;
import com.seqato.MessengerProject.exception.DataNotFoundException;

public class MessageService 
{

	public static Map<Integer, Message> messages = DatabaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1, new Message(1, "Hello Java", "mithun"));
		messages.put(2, new Message(2, "Hello API", "MITHUN"));
	}
	
	public static ArrayList<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	
	public static ArrayList<Message> getAllMessagebyYear(int year)
	{
		 ArrayList<Message> msgeForYear = new ArrayList<>();
		 Calendar cal = Calendar.getInstance();
		 for(Message message : messages.values())
		 {
			 cal.setTime(message.getCreated());
			 if(cal.get(Calendar.YEAR)==year)
			 {
				 msgeForYear.add(message);
			 }		 
		 }
		 return msgeForYear;
	}
	public static List<Message> getAllMessagesPaginated(int start , int size)
	{
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if(start+size>list.size())
		{
			return new ArrayList<Message>();
		}
		return list.subList(start, size);
	}
	public Message getMessage(int id)
	{  
		Message message = messages.get(id);
		if(message==null)
		{
			throw new DataNotFoundException("Message with id "+id+" is not found");
		}
		return message;
	}
	
	public static Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public static Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public static Message removeMessage(int id)
	{
		return messages.remove(id);
	}
}

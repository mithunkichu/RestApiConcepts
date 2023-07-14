package com.seqato.MessengerProject.data;

import java.util.HashMap;
import java.util.Map;

import com.seqato.MessengerProject.Comment;
import com.seqato.MessengerProject.Message;
import com.seqato.MessengerProject.profile.Profile;

public class DatabaseClass 
{
	public static Map<Integer,Message> messages = new HashMap<>();
	public static Map<String,Profile> profiles = new HashMap<>();
	public static Map<Integer,Comment> comments = new HashMap<>();
	public static Map<Integer,Message> getMessages()
	{
		return messages;
	}
	public static Map<String, Profile> getProfiles()
	{
		return profiles;
	}
	public static Map<Integer,Comment> getComments()
	{
		return comments;
	}
	

	
}

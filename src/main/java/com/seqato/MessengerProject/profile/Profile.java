package com.seqato.MessengerProject.profile;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile 
{
		private String profileName;
		private int id;
		private String fnamae;
		private String lname;
		
		
		public Profile(String profileName, int id, String fnamae, String lname) {
			super();
			this.profileName = profileName;
			this.id = id;
			this.fnamae = fnamae;
			this.lname = lname;
		}
		public Profile()
		{
			
		}
		public String getProfileName() {
			return profileName;
		}
		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFnamae() {
			return fnamae;
		}
		public void setFnamae(String fnamae) {
			this.fnamae = fnamae;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		
		
		
}

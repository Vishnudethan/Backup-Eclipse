package controller.jsp.mvc;

import jakarta.servlet.http.Part;

public class UserModel {
	private Integer id,userAge;
	private String userName,userEmail,fileLocation;
	private Part file;
	private String Date;
	public UserModel(Integer id, Integer userAge, String userName, String userEmail, String fileLocation, Part file,
			String date) {
		super();
		this.id = id;
		this.userAge = userAge;
		this.userName = userName;
		this.userEmail = userEmail;
		this.fileLocation = fileLocation;
		this.file = file;
		this.Date = date;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public Part getFile() {
		//System.out.println(file.getName());
		return file;
	}
	
	public void setFile(Part file) {
		this.file = file;
	}
	
	public UserModel() {
		
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userAge=" + userAge + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", fileLocation=" + fileLocation + ", file=" + file + ", Date=" + Date + "]";
	}

}

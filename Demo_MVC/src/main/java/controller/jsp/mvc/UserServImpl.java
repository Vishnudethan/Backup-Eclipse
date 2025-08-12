package controller.jsp.mvc;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



import jakarta.servlet.http.Part;

public class UserServImpl implements UserService {
	Connection con=DatabaseConnector.dbConnect();

	@Override
	public String insertUser(UserModel um) {
	    try {
	    	
	        
	        String query = "insert into tb2(user_name,user_email,user_age,user_file,uploaded_date) values(?,?,?,?,?)";
	       
	        PreparedStatement ps = con.prepareStatement(query);

	        ps.setString(1, um.getUserName());
	        ps.setString(2, um.getUserEmail());
	        ps.setInt(3, um.getUserAge());
	        ps.setString(5,um.getDate() );
	       
	        

	        Part p = um.getFile();
	        String fileName = null;
	        
	        

	        if (p != null && p.getSize() > 0) {
	            String fName = p.getSubmittedFileName();
	           // fileName = um.getUserEmail() + fName.substring(fName.lastIndexOf('.'));
	            fileName = fName;
	            String filePath = um.getFileLocation() + "\\" + fileName;
	            p.write(filePath);
	        }

	        ps.setString(4, fileName); // will be null if no file uploaded

	        int i = ps.executeUpdate();
	        if (i != 0) {
	            return "success";
	        }
	    } catch (Exception e) {
	        System.out.println("Insert error: " + e.getMessage());
	    }

	    return "failed";
	}


	@Override
	public List<UserModel> ViewUser() {
		List<UserModel> list=new ArrayList<>();
		try {
			String query = "select * from db1.tb2;";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				UserModel um = new UserModel();
				um.setId(rs.getInt(1));
				um.setUserName(rs.getString(2));
				um.setUserEmail(rs.getString(3));
				um.setUserAge(rs.getInt(4));
				um.setFileLocation(rs.getString(5));
				um.setDate(rs.getString(6));
				list.add(um);
				
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
		
	}

	@Override
	public UserModel viewOneUser(Integer id) {
		try {
			String query = "select * from db1.tb2 where id=" +id+";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				UserModel um = new UserModel();
				um.setId(rs.getInt(1));
				um.setUserName(rs.getString(2));
				um.setUserEmail(rs.getString(3));
				um.setUserAge(rs.getInt(4));
				um.setFileLocation(rs.getString(5));
				return(um);
				
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return new UserModel();
		
		
	}

	@Override
	public String updateUser(UserModel um) {
		try {
			String file="";
			String oldFileName="";
			String query = "select * from db1.tb2 where id=" +um.getId()+";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			//System.out.println("updateuser line 103"+query);
			while(rs.next()) {
				File oldFile=new File(um.getFileLocation()+ "\\" + rs.getString(5));
				oldFileName=um.getFileLocation() + "\\" +rs.getString(5);
				//oldFile.delete();
			}
				Part p=um.getFile();
				String fName=p.getSubmittedFileName();
				if (fName.isEmpty()){
					query= "update db1.tb2 set user_name='" +um.getUserName() + "',user_email='" + um.getUserEmail() +"', user_age=" +um.getUserAge() +" where id=" +um.getId() + ";";
				}else {
					String fileName= fName;
					 file=um.getFileLocation() + "\\" + fileName;
					System.out.println("filename"+ file);
					
					p.write(file);
				   query= "update db1.tb2 set user_name='" +um.getUserName() + "',user_email='" + um.getUserEmail() +"', user_age=" +um.getUserAge() +",user_file='"
							+fileName+ "'where id=" +um.getId() + ";";
				}
				
			   System.out.println(query);
				PreparedStatement ps=con.prepareStatement(query);
				File newF=new File(file);
				
				File oldF=new File(oldFileName);
				//System.out.println("124 - "+ oldF.exists());
				int i=ps.executeUpdate();
				//if(newF.exists() && i !=0 && !oldF.exists()) {
				//	return "success";
				//}
				if( i !=0 ) {
					return "success";
				}
			
			} catch(Exception e) {
				System.out.println(e);
			}
			return "failed";
		}


	@Override
	public String deleteUser(UserModel um) {
		try {
//			String oldFileName="";
//			String query="select * from db1.tb2 where id=" +um.getId() + ";";
//			Statement st=con.createStatement();
//			ResultSet rs=st.executeQuery(query);
//			while(rs.next()) {
//				File oldFile=new File(um.getFileLocation() + "\\" + rs.getString(5));
//				oldFileName=um.getFileLocation() + "\\" + rs.getString(5);
//				oldFile.delete();
//			}
			String query ="delete from db1.tb2 where id= " + um.getId() + ";";
			String oldFileName="";
			PreparedStatement ps =con.prepareStatement(query);
			File oldF=new File(oldFileName);
			int i=ps.executeUpdate();
			if(i!=0 || oldF.exists()) {
				return "success";
			}
					
		}
		catch( Exception e) {
			System.out.println(e);
		}
		return "failed";
	}
	
	
	}



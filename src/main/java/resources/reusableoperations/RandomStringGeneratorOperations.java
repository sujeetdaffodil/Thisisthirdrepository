package resources.reusableoperations;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGeneratorOperations {
	
	static final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz"; 
	static SecureRandom secureRnd = new SecureRandom();
	
	public static String randomString(int length) 
	{ StringBuilder sb = new StringBuilder(); 
	  for (int i = 0; i < length; i++) sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length()))); 
	  return sb.toString(); 
	}
	
	public String generateRandomString(int length){
		  return RandomStringUtils.randomAlphabetic(length);
		 }
		 
	public String generateRandomNumber(int length){
		  
			 return RandomStringUtils.randomNumeric(length);
		 }
		 
	public String generateReferenceNumber(){
			 int length = 11;
		  return RandomStringUtils.randomAlphanumeric(length);
		 }
		 
	public String generateStringWithAllowedSplChars(int length){
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   "ABCTESTDEMOFGHIJKLMNOPQRST" +
		    "1234567890" +   //numbers
		    "@_-";
		  return RandomStringUtils.random(length, allowedChars);
		 }
		 
	public String generateEmail(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String email="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  email=temp.substring(0,temp.length())+"@tempmail.bondoya.com";
		  return email;
		 }
		 
		 public String generateUrl(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String url="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
		  return url;
		 }
		 
		 public String generateUserNumber()
		 {	Random r = new Random();
		 	long number = 78000000000L + (long)(r.nextDouble() * 9999999999L);
		 	String userNumber = Long.toString(number);
			return userNumber;
		 }
		 
		 public String generatePassword(int length)
		 {	String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				    "1234567890" +   //numbers
				    "_-.@";   //special characters
				  String password="";
				  String temp=RandomStringUtils.random(length,allowedChars);
				  password=temp.substring(0,temp.length());
				  return password;
		 }
		 
		public String CurrentDate()
			{
				//String pattern = "dd-MM-yyyy";
				DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				Date systemdate = new Date();
				String todaysdate = dateformat.format(systemdate);
				return todaysdate;
			}


}

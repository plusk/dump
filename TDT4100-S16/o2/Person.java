package o2;

import java.util.Date;
import java.util.Locale;

public class Person {
    private String fullName;
    private String email;
    private Date birthday;
    private char gender;
    
    public Person() {
		this.fullName = "";
		this.email = "";
		this.gender = 'M';
	}
    
    private void checkName(String fullName) throws IllegalArgumentException {
        if (fullName.contains(" ")){
            String[] name = fullName.split(" ");
            name[0] = name[0].replaceAll("[^A-Za-z-]", "");
            name[1] = name[1].replaceAll("[^A-Za-z-]", "");
            if(name[0].length() >= 2 && name[1].length() >= 2) {
                return;
            }
            else {
                throw new IllegalArgumentException("Given name and/or family name is too short.");
            }
        }
        else {
            throw new IllegalArgumentException("Full name lacks space.");
        }
    }
    public void setName (String fullName) {
        checkName(fullName);
        this.fullName = fullName;
    }
    public String getName() {
        return this.fullName;
    }
    
    private String generateEmail() {
        return getName().replace(" ", ".").toLowerCase();
    }
    private void checkEmail(String email) throws IllegalArgumentException {
        if(email != null && !email.isEmpty()) {
            if(email.contains("@")){
                String[] emailPart = email.split("@");
                if(emailPart[0].equals(generateEmail())) {
                    if(emailPart[1].contains(".")){
                        String[] emailPart2 = emailPart[1].split("\\.");
                        if(emailPart2[1].length() == 2){
                            Locale l = new Locale("", emailPart2[1]);
                            l.getCountry();
                            if(l.getCountry() == ""){
                                throw new IllegalArgumentException("Country code is not recognized.");
                            }
                        }
                        else {
                            throw new IllegalArgumentException("Country code is too long or short.");
                        }
                    }
                    else {
                        throw new IllegalArgumentException("New email has wrong format (no period).");
                    }
                }
                else {
                    throw new IllegalArgumentException("New email does not match with name.");
                }
            }
            else {
                throw new IllegalArgumentException("New email has wrong format (no at-sign).");
            }
        }
        else {
            return;
        }
    }
    public void setEmail(String email) {
        checkEmail(email);
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    
	private void checkBirthday(Date birthday) {
        Date now = new Date();
        if(birthday.after(now)) {
        	throw new IllegalArgumentException("The birthday is in the future.");
        }
    }
    public void setBirthday(Date birthday) {
        checkBirthday(birthday);
        this.birthday = birthday;
    }
    public Date getBirthday() {
        return this.birthday;
    }
    
    private void checkGender(char gender) throws IllegalArgumentException {
        if(gender != 'F' && gender != 'M' && gender != '\0'){
            throw new IllegalArgumentException("Gender is not M, F or \0.");
        }
    }
    public void setGender(char gender) {
        checkGender(gender);
        this.gender = gender;
    }
    public char getGender() {
        return this.gender;
    }
    
    public String getSSN() {
        return "";
    }
    public void setSSN(String ssn) {
        
    }
}
package mainApp.admin;

import javafx.scene.control.CheckBox;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class clientInfo {
    private String name;
    private String phoneNumber, email,registring_date;
    private String gender;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private CheckBox select;
   public  clientInfo(){
       this.name="";
       this.phoneNumber="0";
       this.email="";
       this.registring_date="";
       this.gender="";
       select.setSelected(false);
   }
    public clientInfo(String n, String em, String phone, String date,String gender) {
        this.name = n;
        this.email = em;
        this.phoneNumber = phone;
        this.registring_date = date;
        this.select=new CheckBox();
        this.gender=gender;
    }

    public String getRegistring_date() {
        return registring_date;
    }

    public void setRegistring_date(String registring_date) {
        this.registring_date = registring_date;
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

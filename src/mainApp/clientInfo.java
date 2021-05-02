package mainApp;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class clientInfo {
    private String name;
    private String password, email, registring_date;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistring_date() {
        return registring_date;
    }

    public void setRegistring_date(String registring_date) {
        this.registring_date = registring_date;
    }

    public clientInfo(String n, String em, String pass, String date) {
        this.name = n;
        this.email = em;
        this.password = pass;
        this.registring_date = date;
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

package fr.univ_lille1.iut_info.moreaut.astiko;

/**
 * Created by moreaut on 27/03/17.
 */

        import java.security.Principal;
        import java.util.Date;

public class User implements Principal {

    private String login;
    private String nom;
    private String prenom;
    private Date dob;
    private int id = 0;
    private String email;
    private String password;
    private String tel;
    private int isAdmin;


    public String getLogin() {
        return login;
    }



    public void setLogin(String login) {
        this.login = login;
    }



    public String getNom() {
        return nom;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getPrenom() {
        return prenom;
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public Date getDob() {
        return dob;
    }



    public void setDob(Date dob) {
        this.dob = dob;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getTel() {
        return tel;
    }



    public void setTel(String tel) {
        this.tel = tel;
    }



    public int getIsAdmin() {
        return isAdmin;
    }



    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String toString(){
        return "Login : " + login + " password : " + password + "\n";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return login;
    }

}

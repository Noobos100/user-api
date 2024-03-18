package fr.univamu.iut.user;

public class User {
    protected int id;
    protected String name;
    protected String pwd;
    protected String mail;

    public User() {
    }

    public User(int id, String name, String pwd, String mail) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}

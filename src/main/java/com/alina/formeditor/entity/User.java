package com.alina.formeditor.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name="User.findByLogin", query="SELECT u FROM User u where u.login = :login")
public class User extends IndexedEntity
{
    private static final long serialVersionUID = -7197404256920280771L;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "role")
    private String role;
    
    @Lob
    private byte[] image;
    
    public User()
    {
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getLogin()
    {
        return login;
    }
    
    public void setLogin(String login)
    {
        this.login = login;
    }
    
    public byte[] getImage()
    {
        return image;
    }
    
    public void setImage(byte[] image)
    {
        this.image = image;
    }
    
    @Override
    public String toString()
    {
        return "User{" + "id=" + getId() + ", firstname='" + getFirstName()
                + '\'' + ", secondname=" + getLastName() + ", passwors="
                + getPassword() + ", role=" + getRole() + '}';
    }
}

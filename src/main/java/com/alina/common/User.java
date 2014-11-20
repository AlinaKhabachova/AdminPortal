package com.alina.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends IndexedEntity
{
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "role")
    private String role;
    
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
    
    @Override
    public String toString()
    {
        return "User{" + "id=" + getId() + ", firstname='" + getFirstName()
                + '\'' + ", secondname=" + getLastName() + ", passwors="
                + getPassword() + ", role=" + getRole() + '}';
    }
}

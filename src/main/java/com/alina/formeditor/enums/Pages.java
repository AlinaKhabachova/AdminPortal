package com.alina.formeditor.enums;

public enum Pages
{
    REGISTRATION("registration"), LOGIN("login"), HI("hi");

    Pages(String path)
    {
        this.path = path;
    }

    private String path;

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    @Override
    public String toString()
    {
        return getPath();
    }
}
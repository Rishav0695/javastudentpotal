package com.luv2code.springdemo.mvc;

public class StudentDto {
    private String name;
    private String gender;
    private int id;
    private String phonenumber;
    private AddressDto address;

    public String getAddress() {
        return address.toString();
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "name: "+name+"  phonenumber:"+phonenumber+"gender: "+gender+"address:"+address;
    }

	public StudentDto(String name, String gender, int id, String phonenumber) {
		super();
		this.name = name;
		this.gender = gender;
		this.id = id;
		this.phonenumber = phonenumber;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

package org.fetchData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person") 
public class Person {
	 
    //id will be used for storing MongoDB _id
    
    private String id;
    private String name;
    private String address;
     
    public Person(){}
    public Person(String i, String n, String a){
        this.id=i;
        this.name=n;
        this.address=a;
    }
    
    public Person(String n,String a)
    {
    	this.name=n;
        this.address=a;
    }
    @XmlElement
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
     
    @Override
    public String toString(){
        return id+"::"+name+"::"+address;
    }
}

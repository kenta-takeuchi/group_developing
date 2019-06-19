package la.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable{
    private String code;
    private String name;
    private String tel;
    private String zipcode;
    private String address;

    public CustomerBean() {
    }

    public CustomerBean(String code, String name) {
    	this.code = code;
    	this.name = name;
    }

    public CustomerBean(String code, String name, String tel, String zipcode, String address) {
        this.code = code;
        this.name = name;
        this.tel = tel;
        this.zipcode = zipcode;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
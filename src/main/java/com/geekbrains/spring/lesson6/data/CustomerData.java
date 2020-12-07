package com.geekbrains.spring.lesson6.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.entities.Order;
import com.geekbrains.spring.lesson6.entities.views.CommonView;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class CustomerData {

    @JsonView(CommonView.Id.class)
    private Long id;

    @JsonView(CommonView.CommonFull.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JsonView(CommonView.CommonFull.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;

    @JsonView(CustomerView.IdName.class)
    private String name;

    @JsonView(CustomerView.IdNameBirthdayPhoneEmailAddressOrder.class)
    private String email;

    @JsonView(CustomerView.IdNameBirthdayPhoneEmailAddressOrder.class)
    private String phone;

    @JsonView(CustomerView.IdNameBirthday.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    @JsonView(CustomerView.IdNameBirthdayPhoneEmailAddressOrder.class)
    private String address;

    @JsonView(CustomerView.IdNameBirthdayPhoneEmailAddressOrder.class)
    private String description;

//    @JsonView(CustomerView.IdNameBirthdayPhoneEmailAddressOrder.class)
//    private List<Order> orders;

    public CustomerData() {
    }

    public CustomerData(Long id, Date createDate, Date modifyDate, String name, String email,
                        String phone, Date birthday, String address, String description
//            , List<Order> orders
    ) {
        this.id = id;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.description = description;
//        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


//    @Override
//    public String toString() {
//        return "CustomerData{" +
//                "id=" + id +
//                ", createDate=" + createDate +
//                ", modifyDate=" + modifyDate +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", birthday=" + birthday +
//                ", address='" + address + '\'' +
//                ", description='" + description + '\'' +
//                ", orders=" + orders +
//                '}';
//    }
}

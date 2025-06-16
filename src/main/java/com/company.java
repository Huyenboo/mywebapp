package com;

public class company {
    private String companyName;       // 会社名
    private String address;           // 住所
    private String phone;             // 代表電話番号
    private String contactPerson;     // 担当者
    private String contactMobile;     // 担当者の携帯電話番号

    // Getters và Setters
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getContactMobile() { return contactMobile; }
    public void setContactMobile(String contactMobile) { this.contactMobile = contactMobile; }

    @Override
    public String toString() {
        return "Company [companyName=" + companyName +
               ", address=" + address +
               ", phone=" + phone +
               ", contactPerson=" + contactPerson +
               ", contactMobile=" + contactMobile + "]";
    }
}

package com.example1.CloudVendorInformationService.Model;

public class CloudVendor {
    private String vendorId ;
    private String vendorName ;
    private String vendorAddress ;
    private String vendorContactNumber ;

    // Constructors
    public CloudVendor() {
    }

    public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorContactNumber) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorContactNumber = vendorContactNumber;
    }

    // Getters and Setters
    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorContactNumber() {
        return vendorContactNumber;
    }

    public void setVendorContactNumber(String vendorContactNumber) {
        this.vendorContactNumber = vendorContactNumber;
    }
}

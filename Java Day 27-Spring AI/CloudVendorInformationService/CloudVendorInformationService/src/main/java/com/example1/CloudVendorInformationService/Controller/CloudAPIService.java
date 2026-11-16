package com.example1.CloudVendorInformationService.Controller;

import com.example1.CloudVendorInformationService.Model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIService {
    CloudVendor cloudVendor;
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorInformation(String vendorId) {
        // For demonstration purposes, returning a hardcoded CloudVendor object
        return cloudVendor;
    }
    @PostMapping
    public String createCloudVendorInformation(@RequestBody CloudVendor cloudVendor) {
        // For demonstration purposes, simply returning a success message
        this.cloudVendor= cloudVendor;
        return "Cloud vendor information created successfully";
    }
    @PutMapping
    public String updateCloudVendorInformation(@RequestBody CloudVendor cloudVendor) {
        // For demonstration purposes, simply returning a success message
        this.cloudVendor= cloudVendor;
        return "Cloud vendor information updated successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorInformation(String vendorId) {
        // For demonstration purposes, simply returning a success message
        this.cloudVendor = null;
        return "Cloud vendor information deleted successfully";
    }
}

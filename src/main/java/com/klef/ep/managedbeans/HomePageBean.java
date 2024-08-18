package com.klef.ep.managedbeans;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
public class HomePageBean 
{
	private String welcomeMessage = "Welcome to the Corporate Grievance Management System!";
    private String intro = "Our system allows employees to submit grievances, track their status, and access various resources.";
    
    private List<String> features = new ArrayList<>();
    private List<String> benefits = new ArrayList<>();
    private String contactInfo = "For any queries or support, please contact us at:\nEmail: support@corporategrievance.com\nPhone: +1-800-123-4567";

    public HomePageBean() {
        features.add("Submit grievances easily.");
        features.add("Track the status of your grievances.");
        features.add("Access various resources and FAQs.");
        features.add("Contact the HR department for support.");

        benefits.add("Streamlined grievance handling.");
        benefits.add("Transparent tracking of grievances.");
        benefits.add("Quick access to resources and information.");
        benefits.add("Direct communication with HR.");
    }

    // Getters and setters
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

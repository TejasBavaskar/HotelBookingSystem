package BeanPackage;
public class UserBean {
    
    private String custName;
    private String custAddress;
    private String custEmail;
    private String custAge;
    private String custGender;
    private String custPassword;
    private String[] cusMobile;
    public boolean valid;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustAge() {
        return custAge;
    }

    public void setCustAge(String custAge) {
        this.custAge = custAge;
    }

    public String getCustGender() {
        return custGender;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String[] getCusMobile() {
        return cusMobile;
    }

    public void setCusMobile(String[] cusMobile) {
        this.cusMobile = cusMobile;
    }
    
    public boolean isValid() {
         return valid;
    }

      public void setValid(boolean newValid) {
         valid = newValid;
    }
    
        
}

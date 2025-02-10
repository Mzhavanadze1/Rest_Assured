package Models.SMSModule;

public class GetSMSRequestModel {
    public String PersonId;
    public String TelNumber;
    public String Consent;

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public void setTelNumber(String telNumber) {
        TelNumber = telNumber;
    }

    public void setConsent(String consent) {
        Consent = consent;
    }

    public String getTelNumber() {
        return TelNumber;
    }

    public String getPersonId() {
        return PersonId;
    }

    public int getConsent() {
        return Integer.parseInt(Consent);
    }



}

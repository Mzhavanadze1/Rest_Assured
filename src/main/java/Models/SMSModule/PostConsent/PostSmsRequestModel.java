package Models.SMSModule.PostConsent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostSmsRequestModel {
    public String PersonId;
    public String TelNumber;
    public int status;
    public String channelId;


}

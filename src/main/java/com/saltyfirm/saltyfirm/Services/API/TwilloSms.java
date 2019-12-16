package com.saltyfirm.saltyfirm.Services.API;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class TwilloSms {

    public static final String ACCOUNT_SID =
            "ACf7526560fdf40425f94d3a6be6646fe3";
    public static final String AUTH_TOKEN =
            "45fe8aee7dd05143380249ae6048fb87";


    public void SMS(String phoneNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message
                .creator(new PhoneNumber("+45" + phoneNumber), // to
                        new PhoneNumber("(205) 557-4328"), // from
                        "Congratulations! You have created a user on wwww.saltyfirm.com")
                .create();
    }
}
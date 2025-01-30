package com.julianw03.poroLCU.model.lolAccountVerification.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface AccountVerificationV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<Void>> sendActivationPin(ActivationPinObject activationPinObject);
    Function<LCUHttpConnector, LCUApiResponse<Void>> sendDeactivationPin();
    Function<LCUHttpConnector, LCUApiResponse<VerificationStatus>> getVerificationStatus();
    Function<LCUHttpConnector, LCUApiResponse<PhoneNumber>> getCurrentPhoneNumber();
    /**
     * Tries to match the provided one-time pin with the one sent to the user's phone number.
     * Sadly this method does NOT return an update. You will have to listen to changes on "/lol-account-verification/v1/confirmActivationPinResponse"
     * */
    Function<LCUHttpConnector, LCUApiResponse<Void>> confirmActivationPin(OneTimePin oneTimePin);
    /**
     * Tries to match the provided one-time pin with the one sent to the user's phone number.
     * Sadly this method does NOT return an update. You will have to listen to changes on "/lol-account-verification/v1/confirmDeactivationPinResponse"
     * */
    Function<LCUHttpConnector, LCUApiResponse<Void>> confirmDeactivationPin(OneTimePin oneTimePin);
}

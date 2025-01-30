package com.julianw03.poroLCU.model.lolAccountVerification.v1.impl;

import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.lolAccountVerification.v1.*;

import java.util.function.Function;

public class AccountVerificationV1Impl implements AccountVerificationV1 {

    private final String BASE_PATH = "/lol-account-verification/v1";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> sendActivationPin(ActivationPinObject activationPinObject) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/sendActivationPin",
                        activationPinObject
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> sendDeactivationPin() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/sendDeactivationPin",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<VerificationStatus>> getVerificationStatus() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/is-verified",
                        null
                ), VerificationStatus.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<PhoneNumber>> getCurrentPhoneNumber() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        BASE_PATH + "/phone-number",
                        null
                ), PhoneNumber.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> confirmActivationPin(OneTimePin oneTimePin) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/confirmActivationPin",
                        oneTimePin
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> confirmDeactivationPin(OneTimePin oneTimePin) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        BASE_PATH + "/confirmDeactivationPin",
                        oneTimePin
                ), Void.class)
        );
    }
}

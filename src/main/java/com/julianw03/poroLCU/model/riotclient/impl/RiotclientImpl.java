package com.julianw03.poroLCU.model.riotclient.impl;

import com.julianw03.poroLCU.Util.Utils;
import com.julianw03.poroLCU.connection.http.HttpMethod;
import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.riotclient.*;

import java.util.function.Function;

public class RiotclientImpl implements Riotclient {

    private static final String RELATIVE_PATH = "/riotclient";

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> deleteAffinity() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        RELATIVE_PATH + "/affinity",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Affinity>> getAffinity() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/affinity",
                        null
                ), Affinity.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> postAffinity(Affinity affinity) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/affinity",
                        Utils.readObjectAsJsonNode(affinity)
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getAppName() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/app-name",
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Integer>> getAppPort() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/app-port",
                        null
                ), Integer.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getAuthToken() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/auth-token",
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getClipboard() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/clipboard",
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Boolean>> postClipboard(String clipboard) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/clipboard",
                        Utils.readObjectAsJsonNode(clipboard)
                ), Boolean.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String[]>> getCommandLineArgs() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/command-line-args",
                        null
                ), String[].class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> killAndRestartUx() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/kill-and-restart-ux",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> killUx() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/kill-ux",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> launchUx() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/launch-ux",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getMachineId() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/machine-id",
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> openUrlInBrowser(String url) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/open-url-in-browser",
                        Utils.readObjectAsJsonNode(url)
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<RegionLocale>> getRegionLocale() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/region-locale",
                        null
                ), RegionLocale.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> showSwagger() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/show-swagger",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> hideSplashScreen() {
        return (
                lcuHttpConnector -> new LCUApiResponse<>(
                        lcuHttpConnector.sendApiRequest(
                                HttpMethod.DELETE,
                                RELATIVE_PATH + "/splash",
                                null
                        ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> showSplashScreen() {
        return (
                lcuHttpConnector -> new LCUApiResponse<>(
                        lcuHttpConnector.sendApiRequest(
                                HttpMethod.PUT,
                                RELATIVE_PATH + "/splash?splash=logo",
                                null
                        ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<SystemInfo>> getBasicInfo() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/basic-info",
                        null
                ), SystemInfo.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> unloadUxProcess() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/unload",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> uxAllowForeground() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/ux-allow-foreground",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Integer>> getUxCrashCount() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/ux-crash-count",
                        null
                ), Integer.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> uxFlash() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/ux-flash",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> putUxLoadComplete() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        RELATIVE_PATH + "/ux-load-complete",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> uxMinimize() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/ux-minimize",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> uxShow() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/ux-show",
                        null
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> getUxState() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/ux-state",
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> acknowledgeUxState(String state) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/ux-state/ack",
                        Utils.readObjectAsJsonNode(state)
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> deleteAuthToken(String token) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.DELETE,
                        RELATIVE_PATH + "/auth-tokens/" + token,
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<String>> registerAuthToken(String token) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/auth-tokens/" + token,
                        null
                ), String.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<CrashEnvironment>> getCrashEnvironment() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/v1/crash-reporting/environment",
                        null
                ), CrashEnvironment.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setCrashEnvironment(CrashEnvironment crashEnvironment) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.PUT,
                        RELATIVE_PATH + "/v1/crash-reporting/environment",
                        Utils.readObjectAsJsonNode(crashEnvironment)
                ), Void.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Double>> getZoomScale() {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.GET,
                        RELATIVE_PATH + "/zoom-scale",
                        null
                ), Double.class)
        );
    }

    @Override
    public Function<LCUHttpConnector, LCUApiResponse<Void>> setZoomScale(double zoomScale) {
        return (lcuHttpConnector -> new LCUApiResponse<>(
                lcuHttpConnector.sendApiRequest(
                        HttpMethod.POST,
                        RELATIVE_PATH + "/zoom-scale?scale=" + zoomScale,
                        null
                ), Void.class)
        );
    }
}

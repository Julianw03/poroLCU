package com.julianw03.poroLCU.process;

import java.util.Base64;
import java.util.Optional;
import java.util.regex.Pattern;

public class LeagueClientProcessParameters {
    public static final String CAPTURE_GROUP_ABSOLUTE_FILEPATHS = "([\\w. \\\\/:]+)";
    public static final String CAPTURE_GROUP_BASE64_STRING      = "([A-Za-z0-9+/=_\\-]+)";

    public static final String KEY_RIOTCLIENT_AUTH_TOKEN     = "riotclient-auth-token";
    public static final String KEY_RIOTCLIENT_APP_PORT       = "riotclient-app-port";
    public static final String KEY_NO_RADS                   = "no-rads";
    public static final String KEY_DISABLE_SELF_UPDATE       = "disable-self-update";
    public static final String KEY_REGION                    = "region";
    public static final String KEY_LOCALE                    = "locale";
    public static final String KEY_RIOTGAMESAPI_SETTINGS     = "riotgamesapi-settings";
    public static final String KEY_RGA_LITE                  = "rga-lite";
    public static final String KEY_REMOTING_AUTH_TOKEN       = "remoting-auth-token";
    public static final String KEY_RESPAWN_COMMAND           = "respawn-command";
    public static final String KEY_RESPAWN_DISPLAY_NAME      = "respawn-display-name";
    public static final String KEY_APP_PORT                  = "app-port";
    public static final String KEY_INSTALL_DIRECTORY         = "install-directory";
    public static final String KEY_APP_NAME                  = "app-name";
    public static final String KEY_UX_NAME                   = "ux-name";
    public static final String KEY_UX_HELPER_NAME            = "ux-helper-name";
    public static final String KEY_LOG_DIR                   = "log-dir";
    public static final String KEY_CRASH_REPORTING           = "crash-reporting";
    public static final String KEY_CRASH_ENVIRONMENT         = "crash-environment";
    public static final String KEY_CRASH_PIPE                = "crash-pipe";
    public static final String KEY_APP_LOG_FILE_PATH         = "app-log-file-path";
    public static final String KEY_APP_PID                   = "app-pid";
    public static final String KEY_OUTPUT_BASE_DIR           = "output-base-dir";
    public static final String KEY_NO_PROXY_SERVER           = "no-proxy-server";
    public static final String KEY_IGNORE_CERTIFICATE_ERRORS = "ignore-certificate-errors";

    public static final Pattern PATTERN_RIOTCLIENT_AUTH_TOKEN     = Pattern.compile("--" + KEY_RIOTCLIENT_AUTH_TOKEN + "=" + CAPTURE_GROUP_BASE64_STRING);
    public static final Pattern PATTERN_RIOTCLIENT_APP_PORT       = Pattern.compile("--" + KEY_RIOTCLIENT_APP_PORT + "=(\\d+)");
    public static final Pattern PATTERN_NO_RADS                   = Pattern.compile("--" + KEY_NO_RADS);
    public static final Pattern PATTERN_DISABLE_SELF_UPDATE       = Pattern.compile("--" + KEY_DISABLE_SELF_UPDATE);
    public static final Pattern PATTERN_REGION                    = Pattern.compile("--" + KEY_REGION + "=(\\w+)");
    public static final Pattern PATTERN_LOCALE                    = Pattern.compile("--" + KEY_LOCALE + "=(\\w+)");
    public static final Pattern PATTERN_RIOTGAMESAPI_SETTINGS     = Pattern.compile("--" + KEY_RIOTGAMESAPI_SETTINGS + "=" + CAPTURE_GROUP_BASE64_STRING);
    public static final Pattern PATTERN_RGA_LITE                  = Pattern.compile("--" + KEY_RGA_LITE);
    public static final Pattern PATTERN_REMOTING_AUTH_TOKEN       = Pattern.compile("--" + KEY_REMOTING_AUTH_TOKEN + "=" + CAPTURE_GROUP_BASE64_STRING);
    public static final Pattern PATTERN_RESPAWN_COMMAND           = Pattern.compile("--" + KEY_RESPAWN_COMMAND + "=(\\w+)");
    public static final Pattern PATTERN_RESPAWN_DISPLAY_NAME      = Pattern.compile("--" + KEY_RESPAWN_DISPLAY_NAME + "=(\\w+)");
    public static final Pattern PATTERN_APP_PORT                  = Pattern.compile("--" + KEY_APP_PORT + "=(\\d+)");
    public static final Pattern PATTERN_INSTALL_DIRECTORY         = Pattern.compile("--" + KEY_INSTALL_DIRECTORY + "=" + CAPTURE_GROUP_ABSOLUTE_FILEPATHS);
    public static final Pattern PATTERN_APP_NAME                  = Pattern.compile("--" + KEY_APP_NAME + "=(\\w+)");
    public static final Pattern PATTERN_UX_NAME                   = Pattern.compile("--" + KEY_UX_NAME + "=(\\w+)");
    public static final Pattern PATTERN_UX_HELPER_NAME            = Pattern.compile("--" + KEY_UX_HELPER_NAME + "=(\\w+)");
    public static final Pattern PATTERN_LOG_DIR                   = Pattern.compile("--" + KEY_LOG_DIR + "=" + CAPTURE_GROUP_ABSOLUTE_FILEPATHS);
    public static final Pattern PATTERN_CRASHPAD_REPORTING        = Pattern.compile("--" + KEY_CRASH_REPORTING + "=(\\w+)");
    public static final Pattern PATTERN_CRASH_ENVIRONMENT         = Pattern.compile("--" + KEY_CRASH_ENVIRONMENT + "=(\\w+)");
    public static final Pattern PATTERN_CRASH_PIPE                = Pattern.compile("--" + KEY_CRASH_PIPE + "=" + CAPTURE_GROUP_ABSOLUTE_FILEPATHS);
    public static final Pattern PATTERN_APP_LOG_FILE_PATH         = Pattern.compile("--" + KEY_APP_LOG_FILE_PATH + "=" + CAPTURE_GROUP_ABSOLUTE_FILEPATHS);
    public static final Pattern PATTERN_APP_PID                   = Pattern.compile("--" + KEY_APP_PID + "=(\\d+)");
    public static final Pattern PATTERN_OUTPUT_BASE_DIR           = Pattern.compile("--" + KEY_OUTPUT_BASE_DIR + "=" + CAPTURE_GROUP_ABSOLUTE_FILEPATHS);
    public static final Pattern PATTERN_NO_PROXY_SERVER           = Pattern.compile("--" + KEY_NO_PROXY_SERVER);
    public static final Pattern PATTERN_IGNORE_CERTIFICATE_ERRORS = Pattern.compile("--" + KEY_IGNORE_CERTIFICATE_ERRORS);

    public static final LCUConnectionProperty<String> RIOTCLIENT_AUTH_TOKEN = new LCUConnectionProperty<>(PATTERN_RIOTCLIENT_AUTH_TOKEN, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<Integer> RIOTCLIENT_APP_PORT = new LCUConnectionProperty<>(PATTERN_RIOTCLIENT_APP_PORT, matcher -> Integer.parseInt(matcher.group(1)));

    public static final LCUConnectionProperty<Boolean> NO_RADS = new LCUConnectionProperty<>(PATTERN_NO_RADS, matcher -> true);

    public static final LCUConnectionProperty<Boolean> DISABLE_SELF_UPDATE = new LCUConnectionProperty<>(PATTERN_DISABLE_SELF_UPDATE, matcher -> true);

    public static final LCUConnectionProperty<String> REGION = new LCUConnectionProperty<>(PATTERN_REGION, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> LOCALE = new LCUConnectionProperty<>(PATTERN_LOCALE, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> RIOTGAMESAPI_SETTINGS = new LCUConnectionProperty<>(PATTERN_RIOTGAMESAPI_SETTINGS, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<Boolean> RGA_LITE = new LCUConnectionProperty<>(PATTERN_RGA_LITE, matcher -> true);

    public static final LCUConnectionProperty<String> REMOTING_AUTH_TOKEN = new LCUConnectionProperty<>(PATTERN_REMOTING_AUTH_TOKEN, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> RESPAWN_COMMAND = new LCUConnectionProperty<>(PATTERN_RESPAWN_COMMAND, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> RESPAWN_DISPLAY_NAME = new LCUConnectionProperty<>(PATTERN_RESPAWN_DISPLAY_NAME, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<Integer> APP_PORT = new LCUConnectionProperty<>(PATTERN_APP_PORT, matcher -> Integer.parseInt(matcher.group(1)));

    public static final LCUConnectionProperty<String> INSTALL_DIRECTORY = new LCUConnectionProperty<>(PATTERN_INSTALL_DIRECTORY, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> APP_NAME = new LCUConnectionProperty<>(PATTERN_APP_NAME, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> UX_NAME = new LCUConnectionProperty<>(PATTERN_UX_NAME, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> UX_HELPER_NAME = new LCUConnectionProperty<>(PATTERN_UX_HELPER_NAME, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> LOG_DIR = new LCUConnectionProperty<>(PATTERN_LOG_DIR, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> CRASHPAD_REPORTING = new LCUConnectionProperty<>(PATTERN_CRASHPAD_REPORTING, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> CRASH_ENVIRONMENT = new LCUConnectionProperty<>(PATTERN_CRASH_ENVIRONMENT, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> CRASH_PIPE = new LCUConnectionProperty<>(PATTERN_CRASH_PIPE, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<String> APP_LOG_FILE_PATH = new LCUConnectionProperty<>(PATTERN_APP_LOG_FILE_PATH, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<Integer> APP_PID = new LCUConnectionProperty<>(PATTERN_APP_PID, matcher -> Integer.parseInt(matcher.group(1)));

    public static final LCUConnectionProperty<String> OUTPUT_BASE_DIR = new LCUConnectionProperty<>(PATTERN_OUTPUT_BASE_DIR, matcher -> matcher.group(1));

    public static final LCUConnectionProperty<Boolean> NO_PROXY_SERVER = new LCUConnectionProperty<>(PATTERN_NO_PROXY_SERVER, matcher -> true);

    public static final LCUConnectionProperty<Boolean> IGNORE_CERTIFICATE_ERRORS = new LCUConnectionProperty<>(PATTERN_IGNORE_CERTIFICATE_ERRORS, matcher -> true);

    private String riotClientAuthToken;

    private Integer riotClientAppPort;
    private Boolean noRads;
    private Boolean disableSelfUpdate;
    private String  region;
    private String  locale;
    private String  riotGamesApiSettings;
    private Boolean rgaLite;
    private String  remotingAuthToken;
    private String  respawnCommand;
    private String  respawnDisplayName;
    private Integer appPort;
    private String  installDirectory;
    private String  appName;
    private String  uxName;
    private String  uxHelperName;
    private String  logDir;
    private String  crashReporting;
    private String  crashEnvironment;
    private String  crashPipe;
    private String  appLogFilePath;
    private Integer appPid;
    private String  outputBaseDir;
    private Boolean noProxyServer;
    private Boolean ignoreCertificateErrors;

    private String authHeaderValue;

    private LeagueClientProcessParameters() {
    }

    public LeagueClientProcessParameters(
            int appPort,
            String authToken
    ) {

        if (appPort <= 0) {
            throw new IllegalArgumentException("appPort must be greater than 0");
        }

        if (authToken == null || authToken.isEmpty()) {
            throw new IllegalArgumentException("authToken must not be null or empty");
        }

        this.appPort = appPort;
        this.remotingAuthToken = authToken;
        this.authHeaderValue = "Basic " + Base64.getEncoder().encodeToString(
                "riot:".concat(authToken).getBytes()
        );
    }

    private void setRiotClientAuthToken(String riotClientAuthToken) {
        this.riotClientAuthToken = riotClientAuthToken;
    }

    private void setRiotClientAppPort(Integer riotClientAppPort) {
        this.riotClientAppPort = riotClientAppPort;
    }

    private void setNoRads(Boolean noRads) {
        this.noRads = noRads;
    }

    private void setDisableSelfUpdate(Boolean disableSelfUpdate) {
        this.disableSelfUpdate = disableSelfUpdate;
    }

    private void setRegion(String region) {
        this.region = region;
    }

    private void setLocale(String locale) {
        this.locale = locale;
    }

    private void setRiotGamesApiSettings(String riotGamesApiSettings) {
        this.riotGamesApiSettings = riotGamesApiSettings;
    }

    private void setRgaLite(Boolean rgaLite) {
        this.rgaLite = rgaLite;
    }

    private void setRemotingAuthToken(String remotingAuthToken) {
        this.remotingAuthToken = remotingAuthToken;
    }

    private void setRespawnCommand(String respawnCommand) {
        this.respawnCommand = respawnCommand;
    }

    private void setRespawnDisplayName(String respawnDisplayName) {
        this.respawnDisplayName = respawnDisplayName;
    }

    private void setAppPort(Integer appPort) {
        this.appPort = appPort;
    }

    private void setInstallDirectory(String installDirectory) {
        this.installDirectory = installDirectory;
    }

    private void setAppName(String appName) {
        this.appName = appName;
    }

    private void setUxName(String uxName) {
        this.uxName = uxName;
    }

    private void setUxHelperName(String uxHelperName) {
        this.uxHelperName = uxHelperName;
    }

    private void setLogDir(String logDir) {
        this.logDir = logDir;
    }

    private void setCrashReporting(String crashReporting) {
        this.crashReporting = crashReporting;
    }

    private void setCrashEnvironment(String crashEnvironment) {
        this.crashEnvironment = crashEnvironment;
    }

    private void setCrashPipe(String crashPipe) {
        this.crashPipe = crashPipe;
    }

    private void setAppLogFilePath(String appLogFilePath) {
        this.appLogFilePath = appLogFilePath;
    }

    private void setAppPid(Integer appPid) {
        this.appPid = appPid;
    }

    private void setOutputBaseDir(String outputBaseDir) {
        this.outputBaseDir = outputBaseDir;
    }

    private void setNoProxyServer(Boolean noProxyServer) {
        this.noProxyServer = noProxyServer;
    }

    private void setIgnoreCertificateErrors(Boolean ignoreCertificateErrors) {
        this.ignoreCertificateErrors = ignoreCertificateErrors;
    }

    public String getRemotingAuthToken() {
        return remotingAuthToken;
    }

    public Integer getAppPort() {
        return appPort;
    }

    public Optional<String> getRiotClientAuthToken() {
        return Optional.ofNullable(riotClientAuthToken);
    }

    public Optional<Integer> getRiotClientAppPort() {
        return Optional.ofNullable(riotClientAppPort);
    }

    public Optional<Boolean> getNoRads() {
        return Optional.ofNullable(noRads);
    }

    public Optional<Boolean> getDisableSelfUpdate() {
        return Optional.ofNullable(disableSelfUpdate);
    }

    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }

    public Optional<String> getLocale() {
        return Optional.ofNullable(locale);
    }

    public Optional<String> getRiotGamesApiSettings() {
        return Optional.ofNullable(riotGamesApiSettings);
    }

    public Optional<Boolean> getRgaLite() {
        return Optional.ofNullable(rgaLite);
    }

    public Optional<String> getRespawnCommand() {
        return Optional.ofNullable(respawnCommand);
    }

    public Optional<String> getRespawnDisplayName() {
        return Optional.ofNullable(respawnDisplayName);
    }

    public Optional<String> getInstallDirectory() {
        return Optional.ofNullable(installDirectory);
    }

    public Optional<String> getAppName() {
        return Optional.ofNullable(appName);
    }

    public Optional<String> getUxName() {
        return Optional.ofNullable(uxName);
    }

    public Optional<String> getUxHelperName() {
        return Optional.ofNullable(uxHelperName);
    }

    public Optional<String> getLogDir() {
        return Optional.ofNullable(logDir);
    }

    public Optional<String> getCrashReporting() {
        return Optional.ofNullable(crashReporting);
    }

    public Optional<String> getCrashEnvironment() {
        return Optional.ofNullable(crashEnvironment);
    }

    public Optional<String> getCrashPipe() {
        return Optional.ofNullable(crashPipe);
    }

    public Optional<String> getAppLogFilePath() {
        return Optional.ofNullable(appLogFilePath);
    }

    public Optional<Integer> getAppPid() {
        return Optional.ofNullable(appPid);
    }

    public Optional<String> getOutputBaseDir() {
        return Optional.ofNullable(outputBaseDir);
    }

    public Optional<Boolean> getNoProxyServer() {
        return Optional.ofNullable(noProxyServer);
    }

    public Optional<Boolean> getIgnoreCertificateErrors() {
        return Optional.ofNullable(ignoreCertificateErrors);
    }

    public String getAuthHeaderValue() {
        return authHeaderValue;
    }

    public static class Builder {

        private final LeagueClientProcessParameters parameters;

        public Builder(
                int appPort,
                String authToken
        ) {
            parameters = new LeagueClientProcessParameters(
                    appPort,
                    authToken
            );
        }

        public Builder setRiotClientAuthToken(String riotClientAuthToken) {
            parameters.setRiotClientAuthToken(riotClientAuthToken);
            return this;
        }

        public Builder setRiotClientAppPort(Integer riotClientAppPort) {
            parameters.setRiotClientAppPort(riotClientAppPort);
            return this;
        }

        public Builder setNoRads(Boolean noRads) {
            parameters.setNoRads(noRads);
            return this;
        }

        public Builder setDisableSelfUpdate(Boolean disableSelfUpdate) {
            parameters.setDisableSelfUpdate(disableSelfUpdate);
            return this;
        }

        public Builder setRegion(String region) {
            parameters.setRegion(region);
            return this;
        }

        public Builder setLocale(String locale) {
            parameters.setLocale(locale);
            return this;
        }

        public Builder setRiotGamesApiSettings(String riotGamesApiSettings) {
            parameters.setRiotGamesApiSettings(riotGamesApiSettings);
            return this;
        }

        public Builder setRgaLite(Boolean rgaLite) {
            parameters.setRgaLite(rgaLite);
            return this;
        }

        public Builder setRespawnCommand(String respawnCommand) {
            parameters.setRespawnCommand(respawnCommand);
            return this;
        }

        public Builder setRespawnDisplayName(String respawnDisplayName) {
            parameters.setRespawnDisplayName(respawnDisplayName);
            return this;
        }

        public Builder setInstallDirectory(String installDirectory) {
            parameters.setInstallDirectory(installDirectory);
            return this;
        }

        public Builder setAppName(String appName) {
            parameters.setAppName(appName);
            return this;
        }

        public Builder setUxName(String uxName) {
            parameters.setUxName(uxName);
            return this;
        }

        public Builder setUxHelperName(String uxHelperName) {
            parameters.setUxHelperName(uxHelperName);
            return this;
        }

        public Builder setLogDir(String logDir) {
            parameters.setLogDir(logDir);
            return this;
        }

        public Builder setCrashpadReporting(String crashReporting) {
            parameters.setCrashReporting(crashReporting);
            return this;
        }

        public Builder setCrashEnvironment(String crashEnvironment) {
            parameters.setCrashEnvironment(crashEnvironment);
            return this;
        }

        public Builder setCrashPipe(String crashPipe) {
            parameters.setCrashPipe(crashPipe);
            return this;
        }

        public Builder setAppLogFilePath(String appLogFilePath) {
            parameters.setAppLogFilePath(appLogFilePath);
            return this;
        }

        public Builder setAppPid(Integer appPid) {
            parameters.setAppPid(appPid);
            return this;
        }

        public Builder setOutputBaseDir(String outputBaseDir) {
            parameters.setOutputBaseDir(outputBaseDir);
            return this;
        }

        public Builder setNoProxyServer(Boolean noProxyServer) {
            parameters.setNoProxyServer(noProxyServer);
            return this;
        }

        public Builder setIgnoreCertificateErrors(Boolean ignoreCertificateErrors) {
            parameters.setIgnoreCertificateErrors(ignoreCertificateErrors);
            return this;
        }

        public LeagueClientProcessParameters build() {
            return parameters;
        }
    }

    public static Optional<LeagueClientProcessParameters> createFromWindowsCommandLine(String commandLine) {
        String token = REMOTING_AUTH_TOKEN.extract(commandLine);
        Integer port = APP_PORT.extract(commandLine);

        if (token == null || port == null) {
            return Optional.empty();
        }

        LeagueClientProcessParameters.Builder builder = new LeagueClientProcessParameters.Builder(
                port,
                token
        )
                .setNoRads(NO_RADS.extract(commandLine))
                .setDisableSelfUpdate(DISABLE_SELF_UPDATE.extract(commandLine))
                .setRegion(REGION.extract(commandLine))
                .setLocale(LOCALE.extract(commandLine))
                .setRiotGamesApiSettings(RIOTGAMESAPI_SETTINGS.extract(commandLine))
                .setRgaLite(RGA_LITE.extract(commandLine))
                .setRespawnCommand(RESPAWN_COMMAND.extract(commandLine))
                .setRespawnDisplayName(RESPAWN_DISPLAY_NAME.extract(commandLine))
                .setInstallDirectory(INSTALL_DIRECTORY.extract(commandLine))
                .setAppName(APP_NAME.extract(commandLine))
                .setUxName(UX_NAME.extract(commandLine))
                .setUxHelperName(UX_HELPER_NAME.extract(commandLine))
                .setLogDir(LOG_DIR.extract(commandLine))
                .setCrashpadReporting(CRASHPAD_REPORTING.extract(commandLine))
                .setCrashEnvironment(CRASH_ENVIRONMENT.extract(commandLine))
                .setCrashPipe(CRASH_PIPE.extract(commandLine))
                .setAppLogFilePath(APP_LOG_FILE_PATH.extract(commandLine))
                .setAppPid(APP_PID.extract(commandLine))
                .setOutputBaseDir(OUTPUT_BASE_DIR.extract(commandLine))
                .setNoProxyServer(NO_PROXY_SERVER.extract(commandLine))
                .setIgnoreCertificateErrors(IGNORE_CERTIFICATE_ERRORS.extract(commandLine));


        return Optional.of(builder.build());
    }
}

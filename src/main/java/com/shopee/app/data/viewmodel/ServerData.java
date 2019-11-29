package com.shopee.app.data.viewmodel;

import java.util.List;

public class ServerData {
    private String key;
    private List<ServerInfo> servers;

    public String getKey() {
        return this.key;
    }

    public List<ServerInfo> getServers() {
        return this.servers;
    }

    public static class ServerInfo {
        private String country;
        private String domain;
        private String port;

        public String getCountry() {
            return this.country;
        }

        public String getDomain() {
            return this.domain;
        }

        public String getPort() {
            return this.port;
        }

        public String getURL() {
            return this.domain + ":" + this.port;
        }
    }
}

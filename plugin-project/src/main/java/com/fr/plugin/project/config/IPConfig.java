package com.fr.plugin.project.config;

import com.fr.config.DefaultConfiguration;
import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.stable.StringUtils;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class IPConfig extends DefaultConfiguration {
    private static IPConfig config = null;
    private Conf<String> startIP = Holders.simple(StringUtils.EMPTY);
    private Conf<String> endIP = Holders.simple(StringUtils.EMPTY);

    public static IPConfig getInstance(){
        if (config == null) {
            config = new IPConfig();
        }
        return config;
    }

    @Override
    public String getNameSpace() {
        return "IPConfig";
    }

    public String getStartIP() {
        return startIP.get();
    }

    public void setStartIP(String ip) {
        startIP.set(ip);
    }

    public String getEndIP() {
        return endIP.get();
    }

    public void setEndIP(String ip) {
        endIP.set(ip);
    }

}

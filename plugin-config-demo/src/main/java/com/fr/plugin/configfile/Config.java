package com.fr.plugin.configfile;

import com.fr.config.ConfigContext;
import com.fr.config.DefaultConfiguration;
import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.config.holder.impl.ColConf;
import com.fr.config.holder.impl.MapConf;
import com.fr.config.holder.impl.ObjectColConf;
import com.fr.config.holder.impl.ObjectMapConf;
import com.fr.stable.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joe
 * Created by Joe on 8/26/2020
 */
public class Config extends DefaultConfiguration {
    private static Config config = null;
    private Conf<String> demoString = Holders.simple(StringUtils.EMPTY);
    private Conf<CustomConfig> democusConfig = Holders.obj(new CustomConfig(), CustomConfig.class);
    private ColConf<Collection<String>> stringList = Holders.collection(new ArrayList<String>(), String.class);
    private ObjectColConf<Collection<CustomConfig>> customConfigList = Holders.objCollection(new ArrayList<CustomConfig>(), CustomConfig.class);
    private MapConf<Map<String, Integer>> mapString = Holders.map(new HashMap<String, Integer>(), String.class, Integer.class);
    private ObjectMapConf<Map<String, CustomConfig>> mapCustomConfig = Holders.objMap(new HashMap<String, CustomConfig>(), String.class, CustomConfig.class);

    // Use singleton to create the instance.
    public static Config getInstance() {
        if (config == null) {
            config = ConfigContext.getConfigInstance(Config.class);
        }
        return config;
    }

    // The namespace is the prefix of the config in FINE_CONF_ENTITY
    public String getNameSpace() {
        return "configFR";
    }

    public String getDemoString() {
        return this.demoString.get();
    }

    public void setDemoString(String s) {
        this.demoString.set(s);
    }

    public CustomConfig getDemocusConfig() {
        return democusConfig.get();
    }

    public void setDemocusConfig(CustomConfig democusConfig) {
        this.democusConfig.set(democusConfig);
    }

    public List<String> getStringList() {
        return (List<String>) this.stringList.get();
    }

    public void setStringList(List<String> list) {
        this.stringList.set(list);
    }

    public void addStringListValue(String s) {

        this.stringList.add(s);
    }

    public List<CustomConfig> getCustomConfigList() {
        return (List<CustomConfig>) this.customConfigList.get();
    }

    public void setCustomConfigList(List<CustomConfig> list) {
        this.customConfigList.set(list);
    }

    public void addCustomConfigListValue(CustomConfig config) {
        this.customConfigList.add(config);
    }

    public Map<String, Integer> getStringMap() {
        return this.mapString.get();
    }

    public void setStringMap(Map<String, Integer> mapString) {

        this.mapString.set(mapString);
    }

    public void putStringMap(String key, Integer value) {
        this.mapString.put(key, value);
    }

    public Map<String, CustomConfig> getCustomconfigMap() {
        return this.mapCustomConfig.get();
    }

    public void setCustomconfigMap(Map<String, CustomConfig> map) {
        this.mapCustomConfig.set(map);
    }

    public void putCustomConfigMap(String key, CustomConfig value) {
        this.mapCustomConfig.put(key, value);
    }
}

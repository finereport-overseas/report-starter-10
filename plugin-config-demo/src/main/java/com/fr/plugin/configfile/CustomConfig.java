package com.fr.plugin.configfile;

import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.config.utils.UniqueKey;
import com.fr.stable.StringUtils;

/**
 * @author Joe
 * Created by Joe on 8/26/2020
 */
public class CustomConfig extends UniqueKey {
    private Conf<String> simpledata = Holders.simple(StringUtils.EMPTY);

    public CustomConfig(){}

    public CustomConfig(String simple) {
        simpledata.set(simple);
    }

    public String getSimpledata(){
        return simpledata.get();
    }
    public void setSimpledata(String simple){
        simpledata.set(simple);
    }
}

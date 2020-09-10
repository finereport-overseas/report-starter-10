package com.fr.plugin.passport.demo;

import com.fr.config.Identifier;
import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.decision.authorize.impl.AbstractPassport;
import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.StringUtils;

/**
 * @author Joe
 * Created by Joe on 9/10/2020
 */
@FunctionRecorder
public class DemoPassport extends AbstractPassport {

    public static final String DEMO_PASSPORT_TYPE = "demo";
    @Identifier("suffix")
    private Conf<String> suffix = Holders.simple(StringUtils.EMPTY); //add a config, @Identifier required

    @Override
    public String markType() {
        return DEMO_PASSPORT_TYPE;
    }

    @Override
    @ExecuteFunctionRecord
    public boolean checkTicket(String username, String inputPassword, String savedPassword, String hashPassword) {
        // A simple example. The username must end with the suffix and the password must match.
        return username.endsWith(getSuffix()) && savedPassword.equals(hashPassword);
    }

    public String getSuffix() {
        return suffix.get();
    }

    public void setSuffix(String suffix) {
        this.suffix.set(suffix);
    }
}

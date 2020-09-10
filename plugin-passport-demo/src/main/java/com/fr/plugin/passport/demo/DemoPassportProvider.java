package com.fr.plugin.passport.demo;

import com.fr.decision.authorize.Passport;
import com.fr.decision.fun.impl.AbstractPassportProvider;
import com.fr.decision.webservice.bean.authentication.PassportBean;

/**
 * @author Joe
 * Created by Joe on 9/10/2020
 */
public class DemoPassportProvider extends AbstractPassportProvider {
    @Override
    public String passportType() {
        return DemoPassport.DEMO_PASSPORT_TYPE;
    }

    @Override
    public Class<? extends PassportBean> classForPassportBean() {
        return DemoPassportBean.class;
    }

    @Override
    public Class<? extends Passport> classForPassportConfig() {
        return DemoPassport.class;
    }
}

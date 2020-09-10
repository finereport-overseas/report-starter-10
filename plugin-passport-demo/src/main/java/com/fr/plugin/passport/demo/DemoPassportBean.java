package com.fr.plugin.passport.demo;

import com.fr.decision.authorize.Passport;
import com.fr.decision.webservice.bean.authentication.PassportBean;
import com.fr.third.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * @author Joe
 * Created by Joe on 9/10/2020
 */
@JsonSubTypes.Type(value = DemoPassportBean.class, name = "com.fr.plugin.passport.demo.DemoPassportBean") // This annotation is a must-have.
public class DemoPassportBean extends PassportBean<DemoPassport> {

    private String suffix;

    @Override
    public String markType() {
        return DemoPassport.DEMO_PASSPORT_TYPE;
    }

    @Override
    public PassportBean<DemoPassport> createPassportBean(DemoPassport demoPassport) {
        this.suffix = demoPassport.getSuffix();
        return this;
    }

    @Override
    public Passport createPassport() {
        DemoPassport demoPassport = new DemoPassport();
        demoPassport.setSuffix(this.getSuffix());
        return demoPassport;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

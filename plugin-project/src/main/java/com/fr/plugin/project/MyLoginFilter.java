package com.fr.plugin.project;

import com.fr.decision.fun.impl.AbstractGlobalRequestFilterProvider;
import com.fr.general.ComparatorUtils;
import com.fr.plugin.project.config.IPConfig;
import com.fr.web.utils.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joe
 * Created by Joe on 9/2/2020
 */
public class MyLoginFilter extends AbstractGlobalRequestFilterProvider {
    @Override
    public String filterName() {
        return "login filter";
    }

    @Override
    public String[] urlPatterns() {
        return new String[] {
                "/decision/*"
        };
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) {
        System.out.println(req.getRequestURL()+"?"+req.getQueryString());
        try {
            String currentIP = WebUtils.getIpAddr(req);
            String startIP = IPConfig.getInstance().getStartIP();
            String endIP = IPConfig.getInstance().getEndIP();
            if(ComparatorUtils.compare(currentIP,startIP) < 0 || ComparatorUtils.compare(currentIP,endIP) > 0){
                WebUtils.printAsString(res,"Not in the white list!");
                return;
            }
            filterChain.doFilter(req,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

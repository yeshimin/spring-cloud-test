package com.yeshimin.test.springcloudtest.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul Filter
 *
 * @author yeshimin
 * @since 2017-09-18
 */
@Component
public class PreZuulTestFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PreZuulTestFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        logger.info("PreZuulTestFilter.shouldFilter()");

        return true;
    }

    @Override
    public Object run() {
        logger.info("PreZuulTestFilter.shouldFilter()");

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        if (StringUtils.isEmpty(request.getParameter("token"))) {
            logger.info("unauthorized");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            return null;
        }

        logger.info("authorized");
        context.setSendZuulResponse(true);
        return null;
    }
}

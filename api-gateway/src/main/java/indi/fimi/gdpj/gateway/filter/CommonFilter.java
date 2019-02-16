package indi.fimi.gdpj.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Mr.ZHUANG
 */
public class CommonFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(CommonFilter.class);

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
        return true;
    }

    @Override
    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        log.info("send {} request to {} ",request.getMethod(),request.getRequestURL().toString());
//
//        HttpSession session = request.getSession();
//        if(null == session.getAttribute("user")){
//            log.warn("this user didn't login ");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        }
        log.info("Access the CommonFilter!!");
        return null;
    }
}

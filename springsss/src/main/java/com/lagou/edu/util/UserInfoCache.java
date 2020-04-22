package com.lagou.edu.util;

import com.lagou.edu.pojo.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @author bobcheng
 * @date 2020/4/22
 */
public class UserInfoCache {

    private UserInfoCache() {
    }

    private static final String OAUTH_SESSION_ID = "oauth_session_id";

    private static Map<String, User> cacheMap = new HashMap<>();

    public static void setCurrentUser(User user, HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        Cookie cookie = new Cookie(OAUTH_SESSION_ID, sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
        cacheMap.put(sessionId, user);
    }

    public static User getCurrentUser(HttpServletRequest request) {
        String sessionId = getSessionId(request);
        if (StringUtils.isEmpty(sessionId)) {
            return null;
        }
        return cacheMap.get(sessionId);
    }

    private static String getSessionId(HttpServletRequest request) {
        String oauthSessionId = request.getHeader(OAUTH_SESSION_ID);
        if (!StringUtils.isEmpty(oauthSessionId)) {
            return oauthSessionId;
        }
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return request.getParameter(OAUTH_SESSION_ID);
        }

        return Arrays.stream(cookies)
                .filter(cookie -> OAUTH_SESSION_ID.equals(cookie.getName()) && !StringUtils.isEmpty(cookie.getValue()))
                .map(Cookie::getValue)
                .findFirst().orElse(request.getParameter(OAUTH_SESSION_ID));
    }
}

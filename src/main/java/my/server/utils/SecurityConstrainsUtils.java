package my.server.utils;

public class SecurityConstrainsUtils {
    public static final String SECRET = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 60_000; // 1 min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Авторизация";
    public static final String SIGN_UP_URL = "api/v1/user";
}
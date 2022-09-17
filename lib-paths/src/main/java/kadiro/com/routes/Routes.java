package kadiro.com.routes;

public class Routes {
    public static final String API_BASE_PATH_V1 = "/api/v1";
    public static final String LOGIN = API_BASE_PATH_V1 + "/login";
    public static final String LOGOUT = API_BASE_PATH_V1 + "/logout";
    public static final String REGISTER = API_BASE_PATH_V1 + "/register";
    public static final String USERS = API_BASE_PATH_V1 + "/users";
    public static final String USERS_ID = API_BASE_PATH_V1 + "/users/{id}";
    public static final String ROLES = API_BASE_PATH_V1 + "/roles";
    public static final String ROLES_ID = API_BASE_PATH_V1 + "/roles/{id}";
    public static final String PERMISSIONS = API_BASE_PATH_V1 + "/permissions";
    public static final String PERMISSIONS_ID = API_BASE_PATH_V1 + "/permissions/{id}";
}

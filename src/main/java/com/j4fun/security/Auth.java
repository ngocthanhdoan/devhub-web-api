package com.j4fun.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.j4fun.eNum.CodeEnum;
import com.j4fun.plugins.env;

/**
 * Class đại diện cho việc thực hiện các chức năng xác thực.
 */
public class Auth {
    /**example : localhost:8080/example/role => check /example/role */
    private Set<String> AUTH_URL_FUNCTION   = new HashSet<>();

    /**example : addRoleFunction => [class com.app.pulgins.Auth/addRoleFunction]*/
    private Set<String> AUTH_FUNCTION_NAME  = new HashSet<>();

    /**example : admin,ROLE_IT,ROLE_SALE,...*/
    private Set<String> AUTH_ROLES_FUNCTION = new HashSet<>();

    /**example : query,create,update,delete */
    private Set<String> AUTH_ACTION_ALLOW   = new HashSet<>();
    
    /**example : SUCCESS,NOTPASS_AUTH_URL_FUNCTION,vvv... */
    private CodeEnum AUTH_CODE_RETURN;

    /**
     * Constructor của Auth.
     * Khởi tạo các vai trò và chức năng mặc định.
     */
    public Auth()                                       {      
        if(!env.isProd()) {
            // Khởi tạo các vai trò và chức năng mặc định
            addUrl("example/role");
            addRoleFunction("admin");
            //addRoleFunction("user");
            addFunctionName("addRoleFunction");
            addActionAllow("create");
        }
      
    }

    /**
     * Thêm một URL vào danh sách chức năng.
     * 
     * @param url Địa chỉ URL cần thêm.
     */
    private void addUrl(String url)                     {
        this.AUTH_URL_FUNCTION.add(url);
    }

    /**
     * Thêm tên chức năng vào danh sách.
     * 
     * @param function_name Tên chức năng cần thêm.
     */
    private void addFunctionName(String function_name)  {
        this.AUTH_FUNCTION_NAME.add(function_name);
    }

    /**
     * Thêm vai trò chức năng vào danh sách.
     * 
     * @param role_function Vai trò chức năng cần thêm.
     */
    private void addRoleFunction(String role_function)  {
        this.AUTH_ROLES_FUNCTION.add(role_function);
    }
    /**
     * Lấy mã trạng thái xác thực chức năng
     * 
     * @return AUTH_CODE_RETURN Trả về 1 code enum.
     */
    public CodeEnum getReturnCode()                        {
        return AUTH_CODE_RETURN;
    }

    /**
     * Thêm hành động cho phép vào danh sách.
     * 
     * @param action Hành động cần thêm.
     */
    private void addActionAllow(String action)          {
        this.AUTH_ACTION_ALLOW.add(action);
    }

    public boolean hasPermission(User user, String url, String function_name, String action)       {
        if (user == null || url == null || function_name == null || action == null) {
            return false;
        }
        return checkRole(user, url, function_name, action, CodeEnum.VERY_AUTH_TYPE_PRIVATE.getCode());
    }

    public boolean hasPermissionPublic() {
        return checkRole(null, null, null, null, CodeEnum.VERY_AUTH_TYPE_PUBLIC.getCode());
    }
    public boolean hasPermissionApi(String url) {
        return checkRole(null, null, null, null, CodeEnum.VERY_AUTH_TYPE_PUBLIC.VERY_AUTH_TYPE_API.getCode());
    }
    private boolean checkRole(User user, String url, String function_name, String action, int type) {
        if (type == CodeEnum.VERY_AUTH_TYPE_PRIVATE.getCode()) {
            Set<String> userRoles = user.getRoles();
            if (!AUTH_URL_FUNCTION.contains(url)) {
                System.err.println(CodeEnum.NOTPASS_AUTH_URL_FUNCTION);
                this.AUTH_CODE_RETURN = CodeEnum.NOTPASS_AUTH_URL_FUNCTION;
                return false;
            }
            if (!AUTH_FUNCTION_NAME.contains(function_name)) {
                System.err.println(CodeEnum.NOTPASS_AUTH_FUNCTION_NAME);
                this.AUTH_CODE_RETURN = CodeEnum.NOTPASS_AUTH_FUNCTION_NAME;
                return false;
            }

            // Kiểm tra xem người dùng có vai trò phù hợp không
            if (userRoles.stream().noneMatch(AUTH_ROLES_FUNCTION::contains)) {
                System.err.println(CodeEnum.NOTPASS_AUTH_ROLES_FUNCTION);
                this.AUTH_CODE_RETURN = CodeEnum.NOTPASS_AUTH_ROLES_FUNCTION;
                return false;
            }

            // Kiểm tra xem hành động có nằm trong danh sách các hành động cho phép không
            if (!AUTH_ACTION_ALLOW.contains(action)) {
                System.err.println(CodeEnum.NOTPASS_AUTH_ACTION_ALLOW);
                this.AUTH_CODE_RETURN = CodeEnum.NOTPASS_AUTH_ACTION_ALLOW;
                return false;
            }
        }
        this.AUTH_CODE_RETURN = CodeEnum.SUCCESS;
        return true;
    }

    public class User                     {
        private String      username;

        private Set<String> roles;

        public User(String  username)     {
            this.username = username;
        }

        public String getUsername()       {
            return username;
        }

        public Set<String> getRoles() {
            if (username.equals("admin")) {
                roles = new HashSet<>(Arrays.asList("admin"));
            } else {
                roles = new HashSet<>(Arrays.asList("user"));
            }
            return roles;
        }
    }

    public static void main(String[] args) {
        // Tạo một người dùng với vai trò là "admin"
        //Auth.User adminUser = new Auth().new User("admin");

        // Tạo một người dùng với vai trò là "user"

        // Tạo một đối tượng Auth
        Auth authMain = new Auth();
        Auth.User auth = new Auth().new User("admin");
        authMain.hasPermission(auth, "example/role", "addRoleFunction", "create");
       
        // Kiểm tra quyền của người dùng adminUser
        System.out.println("Testing permissions for admin user:");
        if(authMain.getReturnCode().getCode()!=0) {
            System.out.println("very thất bại");
        }else {
            System.out.println("very thành công!");
        }
        System.out.println( authMain.hasPermissionPublic());
    }
}

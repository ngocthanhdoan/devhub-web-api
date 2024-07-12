package com.j4fun.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AuthorizationManager {
    // Mock user roles (can be replaced with actual roles from your system)
    private static final Set<String> ADMIN_ROLES = new HashSet<>(Arrays.asList("admin", "superadmin"));
    private static final Set<String> USER_ROLES = new HashSet<>(Arrays.asList("user"));
    private static final Set<String> IT_ROLES = new HashSet<>(Arrays.asList("IT01", "IT02"));
    private static final Set<String> BP_ROLES = new HashSet<>(Arrays.asList("BP01", "BP02"));

    // Method to check if a user has permission to perform a specific action
    public static boolean hasPermission(User user, String action) {
        if (user == null || action == null) {
            return false;
        }
       
        // Get user roles
        Set<String> userRoles = user.getRoles();
        System.out.println(user.getRoles());
        // Check if user has permission based on their roles and the action
        switch (action) {
            case "create":
                System.out.println(ADMIN_ROLES);
                return ADMIN_ROLES.stream().anyMatch(userRoles::contains);
            case "read":
            case "update":
            case "delete":
                System.out.println(ADMIN_ROLES);
                return ADMIN_ROLES.stream().anyMatch(userRoles::contains)
                        || USER_ROLES.stream().anyMatch(userRoles::contains);
            case "ITFunction":
                System.out.println(IT_ROLES);
                return IT_ROLES.stream().anyMatch(userRoles::contains);
            case "BPFunction":
                System.out.println(BP_ROLES);
                return BP_ROLES.stream().anyMatch(userRoles::contains);
            default:
                return false;
        }
    }

    // Method to perform an action based on user's permission
    public static void performAction(User user, String action) {
        if (hasPermission(user, action)) {
            // Execute the action
            System.out.println("User " + user.getUsername() + " is performing action: " + action);
        } else {
            System.out.println("User " + user.getUsername() + " does not have permission to perform action: " + action);
        }
    }

    public static void main(String[] args) {
        // Create a user and assign roles (this can be replaced with your user authentication logic)
        User user = new User("john", new HashSet<>(Arrays.asList("IT01", "admin")));

        // Test permission for various actions
        performAction(user, "create");
        performAction(user, "read");
        performAction(user, "update");
        performAction(user, "delete");
        performAction(user, "ITFunction");
        performAction(user, "BPFunction");
    }
}

class User {
    private String username;
    private Set<String> roles;

    public User(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getRoles() {
        return roles;
    }
}

package com.knockturnmc.devathlon.utils;

public class PermissionsImpl implements Permissions {

    private String ADMIN_PERMISSION = "dathlon.admin";

    private String USER_PERMISSION = "dathlon.user";

    /**
     * Gives admin permission
     * @return permission String
     */
    @Override
    public final String getADMIN_PERMISSION() {
        return ADMIN_PERMISSION;
    }

    /**
     * Gives user permission
     * @return permission String
     */
    @Override
    public final String getUSER_PERMISSION() {
        return USER_PERMISSION;
    }
}

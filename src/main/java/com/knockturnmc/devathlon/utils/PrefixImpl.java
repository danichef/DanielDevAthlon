package com.knockturnmc.devathlon.utils;

import org.bukkit.ChatColor;

public class PrefixImpl implements Prefix {

    private String PREFIX = ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "DevAthlon" +ChatColor.GRAY + "] ";

    /**
     * Returns plugin prefix
     * @return String
     */
    @Override
    public String getPREFIX() {
        return PREFIX;
    }
}

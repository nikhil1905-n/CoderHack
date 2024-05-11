package com.nikhiln.coderHack.model;

public enum Badges {

    // Badge awarded for beginners who have shown promise
    Code_Ninja("Code Ninja"),

    // Badge awarded for coders who have mastered the basics
    Code_Champ("Code Champ"),

    // Badge awarded for coders who have demonstrated advanced skills
    Code_Master("Code Master");

    private final String badgeName;

    Badges(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeName() {
        return this.badgeName;
    }

}

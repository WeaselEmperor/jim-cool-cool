package com.weasel.cool.domain;

public class JamieCoolThing {

    private String name;
    private CoolnessRating coolnessRating;

    public JamieCoolThing(final String name, final CoolnessRating coolnessRating) {
        this.name = name;
        this.coolnessRating = coolnessRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoolnessRating getCoolnessRating() {
        return coolnessRating;
    }

    public void setCoolnessRating(CoolnessRating coolnessRating) {
        this.coolnessRating = coolnessRating;
    }
}

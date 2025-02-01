package com.weasel.cool.domain;

public class JamieCoolThing {

    private static final JamieCoolThing singleCoolestJamie = new JamieCoolThing("jamie", CoolnessRating.OH_MY_WOOORD);

    public static final JamieCoolThing coolestJamie() { return new JamieCoolThing("jamie", CoolnessRating.OH_MY_WOOORD);}
    public static final JamieCoolThing singleCoolestJamie() { return singleCoolestJamie;}


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

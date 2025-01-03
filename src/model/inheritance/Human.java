package model.inheritance;

import model.inheritance.abilitiesenum.Abilities;

public abstract class Human {

    protected int level;

    private String appearance;

    private String feelings;

    private int age;

    private String accessory;

    private Abilities specialAbility;

    public Human () {}

    public Human ( int level, String appearance, String feelings, int age, String accessory,
                   Abilities specialAbility ) {

        this.level = level;

        this.appearance = appearance;

        this.feelings = feelings;

        this.age = age;

        this.accessory = accessory;

        this.specialAbility = specialAbility;

    }

    public Human ( int level, String appearance, String accessory, Abilities specialAbility ) {

        this.level = level;

        this.appearance = appearance;

        this.accessory = accessory;

        this.specialAbility = specialAbility;

    }

    public int getLevel () {

        return level;

    }

    public String getAppearance () {

        return appearance;

    }

    public String getFeelings () {

        return feelings;

    }

    public String getAccessory () {

        return accessory;

    }

    public int getAge () {

        return age;

    }

    public Abilities getSpecialAbility () {

        return specialAbility;

    }

    @Override
    public String toString () {

        StringBuilder sb;

        sb = new StringBuilder();

        sb.append( "Level: " ).append( getLevel() )
                .append( " Appearance: " ).append( getAppearance() )
                .append( " Feelings: " ).append( getFeelings() )
                .append( " Age: " ).append( getAge() )
                .append( " Accessory: " ).append( getAccessory() )
                .append( " Abilities: " ).append( getSpecialAbility() );

        return sb.toString();

    }

}
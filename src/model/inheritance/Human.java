package model.inheritance;

import model.inheritance.abilitiesenum.Abilities;

public abstract class Human {

    // feelings ( String ), appearance ( String )
    // age ( int ), accessory ( String ), specialAbility ( String )

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

    public Abilities getSpecialAbility () {

        return specialAbility;

    }

    @Override
    public String toString () {

        StringBuilder sb;

        sb = new StringBuilder();

        sb.append( "Level: " ).append( level )
                .append( " Appearance: " ).append( appearance )
                .append( " Feelings: " ).append( feelings )
                .append( " Age: " ).append( age )
                .append( " Accessory: " ).append( accessory )
                .append( " Abilities: " ).append( specialAbility );

        return sb.toString();

    }

}
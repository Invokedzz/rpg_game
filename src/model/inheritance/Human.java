package model.inheritance;

import model.inheritance.abilitiesenum.Abilities;

public abstract class Human {

    protected String name;

    protected int level;

    private String accessory;

    private Abilities specialAbility;

    public Human () {}

    public Human ( String name, int level, String accessory, Abilities specialAbility ) {

        this.name = name;

        this.level = level;

        this.accessory = accessory;

        this.specialAbility = specialAbility;

    }

    public String getName () {

        return name;

    }

    public int getLevel () {

        return level;

    }


    public String getAccessory () {

        return accessory;

    }


    public Abilities getSpecialAbility () {

        return specialAbility;

    }

    @Override
    public String toString () {

        StringBuilder sb;

        sb = new StringBuilder();

        sb.append( "Level: " ).append( getLevel() )
                .append( " Accessory: " ).append( getAccessory() )
                .append( " Abilities: " ).append( getSpecialAbility() );

        return sb.toString();

    }

}
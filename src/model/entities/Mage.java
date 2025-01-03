package model.entities;

import model.inheritance.abilitiesenum.Abilities;

public final class Mage extends Knight {

    // a mage can deal great damage, but have a poor defense overall

    // mage is going to have a whole system for attack, defense and life points

    private double mana;

    public Mage () {

        super ();

    }

    public Mage ( double lifePoints, String armor, String weapon, double attackPoints, double defensePoints,
                  String name, int level, String appearance, String accessory, Abilities specialAbility, double mana ) {

        // constructor for other classes

        super ( lifePoints, armor, weapon, attackPoints, defensePoints, level, appearance, accessory,
                specialAbility );

        // thinking about methods/variables for the Mage class

        this.mana = mana;

    }

    public double getMana () {

        return mana;

    }

    @Override
    public double declareAttack () {

        // attack points, min: 5, max: 300 -> default,
        // without considering any kind of boosts or abilities

        super.declareAttack();

        return getAttackPoints() + ( level * 10 ) + getMana();

    }

    @Override
    public double blockAttack () {

        // defense points, min: 1, max: 250 -> default,
        // without considering any kind of boosts or abilities

        // getValues += Math.floor(Math.random() * (level + 1));

        super.blockAttack();

        return getDefensePoints() + ( level * 1.2 );

    }

    @Override
    public double calculateLifePoints () {

        super.calculateLifePoints();

        return getLifePoints() + ( level * 5 );

    }


}

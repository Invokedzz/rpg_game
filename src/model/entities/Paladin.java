package model.entities;

import model.inheritance.abilitiesenum.Abilities;

public final class Paladin extends Knight {

    // paladin have a great defense, an ok attack, but the capacity of healing during battle

    // paladin is going to have a whole system for attack, defense and life points

    private double divineStrike;

    public Paladin () {

        super ();

    }

    public Paladin ( double lifePoints, String armor, String weapon, double attackPoints, double defensePoints,
                     String name, int level, String appearance, String accessory, Abilities specialAbility, double divineStrike ) {

        // constructor for other classes

        super ( lifePoints, armor, weapon, attackPoints, defensePoints, level, appearance, accessory,
                specialAbility );

        // thinking about methods/variables for the Paladin class

        this.divineStrike = divineStrike;

    }

    public double getDivineStrike () {

        return divineStrike;

    }

    @Override
    public double declareAttack () {

        // attack points, min: 5, max: 300 -> default,
        // without considering any kind of boosts or abilities

        super.declareAttack();

        return getAttackPoints() + ( level * 2 );

    }

    @Override
    public double blockAttack () {

        // defense points, min: 1, max: 250 -> default,
        // without considering any kind of boosts or abilities

        // getValues += Math.floor(Math.random() * (level + 1));

        super.blockAttack();

        return getDefensePoints() + ( level * 4 );

    }

    @Override
    public double calculateLifePoints () {

        super.calculateLifePoints();

        return getLifePoints() + ( level * 20 );

    }

    public double heal () {

        return calculateLifePoints() + getDivineStrike();

    }

}

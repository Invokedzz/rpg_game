package model.entities;

import model.inheritance.abilitiesenum.Abilities;

public final class Barbarian extends Knight {

    // barbarian is pure gas. great life points and attack damage.

    private double fury;

    public Barbarian () {

        super ();

    }

    public Barbarian ( double lifePoints, String armor, String weapon, double attackPoints, double defensePoints,
                       String name, int level, String accessory, Abilities specialAbility, double fury ) {

        // constructor for other classes

        super ( lifePoints, armor, weapon, attackPoints, defensePoints, name, level, accessory, specialAbility );

        // thinking about methods/variables for the Barbarian class

        this.fury = fury;

    }

    // barbarian is going to have a whole system for attack, defense and life points

    public double getFury () {

        return fury;

    }

    @Override
    public double declareAttack () {

        // attack points, min: 5, max: 300 -> default,
        // without considering any kind of boosts or abilities

        super.declareAttack();

        return getAttackPoints() + ( level * 5 ) + getFury();

    }

    @Override
    public double blockAttack () {

        // defense points, min: 1, max: 250 -> default,
        // without considering any kind of boosts or abilities

        // getValues += Math.floor(Math.random() * (level + 1));

        super.blockAttack();

        return getDefensePoints() + ( level * 4 ) + getFury();

    }

    @Override
    public double calculateLifePoints () {

        super.calculateLifePoints();

        return getLifePoints() + ( level * 14 );

    }


}

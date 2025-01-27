package model.entities;

import model.inheritance.Human;

import model.inheritance.abilitiesenum.Abilities;

public class Knight extends Human implements Attributes {

    // armor ( String ), weapon ( String ),
    // attackPoints ( double ), defensePoints ( double )

    // feelings ( String ), appearance ( String )
    // age ( int ), accessory ( String ), specialAbility ( String )

    protected double lifePoints;

    private String armor;

    private String weapon;

    protected double attackPoints;

    protected double defensePoints;

    private int potionsQuantity = 3;

    public Knight () {}

    public Knight ( double lifePoints, String armor, String weapon, double attackPoints, double defensePoints, String name, int level,
                    String accessory, Abilities specialAbility ) { // constructor for knight class

        super ( name, level, accessory, specialAbility );

        this.lifePoints = lifePoints;

        this.armor = armor;

        this.weapon = weapon;

        this.attackPoints = attackPoints;

        this.defensePoints = defensePoints;

    }

    // STRENGTH_BOOST: raises the atk by 50% for 3 turns;
    // DEFENSE_BOOST: the user can't take damage for 2 turns,
    // but his atk drops by 80%.

    public double getLifePoints () {

        return lifePoints;

    }

    public double getAttackPoints () {

        return attackPoints;

    }

    public double getDefensePoints () {

        return defensePoints;

    }

    public String getArmor () {

        return armor;

    }

    public String getWeapon () {

        return weapon;

    }

    // Battle methods
    // declareAttack, blockAttack, calculateLifePoints, resolveAttackImpact & isAlive

    public double declareAttack () {

        // attack points, min: 5, max: 300 -> default,
        // without considering any kind of boosts or abilities

        return getAttackPoints() + ( level * 6 );

    }

    public double blockAttack () {

        // defense points, min: 1, max: 250 -> default,
        // without considering any kind of boosts or abilities

        // getValues += Math.floor(Math.random() * (level + 1));
        //    don't forget about the validations!
        //    double getDefensePoints = character.validateDefensePoints( defensePoints, level );

        return getDefensePoints() + ( level * 4 );

    }

    public double calculateLifePoints () {

        return getLifePoints() + ( level * 8 );

    }


    public boolean isAlive () {

        return calculateLifePoints () > 0;

    }

    public double takeDamage ( double damage ) {

        this.lifePoints -= damage;

        return this.lifePoints;

    }

    public int usePotions ( int quantity ) {

        this.potionsQuantity -= quantity;

        if ( this.potionsQuantity <= 0 ) {

            System.out.println( "You ran out of potions!" );

            System.out.println();

            return 0;

        }

        System.out.printf("30 HP was healed! %s HP is now %s ", getName(), healPlayer() );

        System.out.println();

        return this.potionsQuantity;

    }

    public double healPlayer () {

        this.lifePoints += 30;

        return this.lifePoints;

    }

    @Override
    public String toString () {

        StringBuilder sb;

        sb = new StringBuilder();

        sb.append( "Name: " ).append( getName() )
                .append( " Armor: " ).append( getArmor() )
                .append( ", Weapon: " ).append( getWeapon() )
                .append( ", Attack Points: " ).append( getAttackPoints() )
                .append( ", Defense Points: " ).append( getDefensePoints() )
                .append( " Special Ability: " ).append( getSpecialAbility() );

        return sb.toString();

    }


}

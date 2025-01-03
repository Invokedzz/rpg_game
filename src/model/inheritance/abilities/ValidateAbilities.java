package model.inheritance.abilities;

import model.entities.*;

import model.exceptions.InvalidAbilityException;

import model.inheritance.abilitiesenum.Abilities;

// MAGICAL_BOOST, STRENGTH_BOOST, WRATH_BOOST,

// DEFENSE_BOOST, HEALING_BOOST

public final class ValidateAbilities {

    public double abilitiesKnight ( Knight knight ) {

        if ( knight.getSpecialAbility().equals ( Abilities.STRENGTH_BOOST ) ) return knight.getAttackPoints() + 50.0;

        if ( knight.getSpecialAbility().equals ( Abilities.DEFENSE_BOOST ) ) return knight.getDefensePoints() + 30.0;

        if ( knight.getSpecialAbility().equals( Abilities.NONE ) ) return knight.getAttackPoints();

        throw new InvalidAbilityException( "Enter a valid ability! (STRENGTH_BOOST, DEFENSE_BOOST or NONE)" );
    }

    public double abilitiesBarbarian ( Barbarian barbarian ) {

        if ( barbarian.getSpecialAbility().equals ( Abilities.WRATH_BOOST ) ) return barbarian.getFury();

        if ( barbarian.getSpecialAbility().equals ( Abilities.STRENGTH_BOOST ) ) return barbarian.getAttackPoints() + 50.0;

        if ( barbarian.getSpecialAbility().equals ( Abilities.NONE ) ) return barbarian.getAttackPoints();

        throw new InvalidAbilityException( "Enter a valid ability! (WRATH_BOOST, STRENGTH_BOOST or NONE)" );

    }

    public double abilitiesMage ( Mage mage ) {

        if ( mage.getSpecialAbility().equals ( Abilities.MAGICAL_BOOST ) ) return mage.getAttackPoints() + mage.getMana();

        if ( mage.getSpecialAbility().equals ( Abilities.NONE ) ) return mage.getAttackPoints();

        throw new InvalidAbilityException( "Enter a valid ability! (MAGICAL_BOOST or NONE)" );

    }

    public double abilitiesPaladin ( Paladin paladin ) {

        if ( paladin.getSpecialAbility().equals ( Abilities.DEFENSE_BOOST ) ) return paladin.getDefensePoints() + 50.0;

        if ( paladin.getSpecialAbility().equals ( Abilities.HEALING_BOOST ) ) return paladin.getAttackPoints() + paladin.getDivineStrike();

        if ( paladin.getSpecialAbility().equals( Abilities.NONE ) ) return paladin.getAttackPoints();

        throw new InvalidAbilityException( "Enter a valid ability! (DEFENSE_BOOST, HEALING_BOOST or NONE)" );

    }

}

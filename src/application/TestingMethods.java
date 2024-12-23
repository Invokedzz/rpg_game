package application;

import java.util.Scanner;

import model.entities.Barbarian;

import model.entities.Knight;

import model.entities.Mage;

import model.entities.Paladin;

import model.exceptions.AttackPointsException;

import model.exceptions.InvalidLevelException;

import model.inheritance.abilities.ValidateAbilities;

import model.inheritance.abilities.ValidateStats;

import model.inheritance.abilities.ValidateUniqueAttributes;

import model.inheritance.abilitiesenum.Abilities;

public class TestingMethods {

    public static void main ( String[] args ) {

        Scanner init = new Scanner ( System.in );

        //    testLevelOfCharacter ( init );

        System.out.println( "##############################" );

        //    testCharacterAttributes ( init );

        System.out.println( "##############################" );

            testCharactersAbilitiesKnight ( init );

        //    testCharactersAbilitiesBarbarian( init );

        //     testCharactersAbilitiesMage( init );

        //testCharactersAbilitiesPaladin( init );

    }

    private static void testLevelOfCharacter ( Scanner init ) {

        try {

            ValidateStats character = new ValidateStats();

            int level = character.levelValidation ( init );

            double attackPoints = character.attackValidation ( init );

            double defensePoints = character.defensePoints ( init );

            character.validateAllMethods( level, attackPoints, defensePoints );

        } catch (InvalidLevelException | AttackPointsException error ) {

            System.out.printf( "Error message: %s", error.getMessage() );

        }

    }

    private static void testCharacterAttributes ( Scanner init ) {

        ValidateUniqueAttributes validateUniqueAttributes = new ValidateUniqueAttributes();

        double fury = validateUniqueAttributes.validateFury( init );

        double mana = validateUniqueAttributes.validateMana( init );

        double divineStrike = validateUniqueAttributes.validateDivineStrike( init );

        System.out.printf( "Fury: %s\nMana: %s\nDivine Strike: %s\n", fury, mana, divineStrike );

    }

    private static void testCharactersAbilitiesKnight ( Scanner init ) {

        ValidateAbilities validateAbilities = new ValidateAbilities();

        // Exceptions registered: IllegalArgumentException

        ValidateStats validateStats = new ValidateStats();

        int level = validateStats.levelValidation( init );

        double attackPoints = validateStats.attackValidation( init );

        double defensePoints = validateStats.defensePoints( init );

        validateStats.validateAllMethods( level, attackPoints, defensePoints );

        try {

            Abilities value = Abilities.valueOf ( init.next() );

            Knight knight = new Knight( 1000.0, "Armor", "Sword", attackPoints,
                    defensePoints, level, "idk", "idk", value );

            if ( value.equals( Abilities.valueOf ( "DEFENSE_BOOST" ) ) ) {

                double getBonusStats = validateAbilities.abilitiesKnight( knight );

                double attackDeclaration = knight.declareAttack();

                double blockAttack = knight.blockAttack() + getBonusStats;

                double lifePoints = knight.calculateLifePoints();

                System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\n", attackDeclaration, blockAttack, lifePoints );

                return;

            }

            double getBonusStats = validateAbilities.abilitiesKnight( knight );

            double attackDeclaration = knight.declareAttack() + getBonusStats;

            double blockAttack = knight.blockAttack();

            double lifePoints = knight.calculateLifePoints();

            System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\n", attackDeclaration, blockAttack, lifePoints );

        } catch ( IllegalArgumentException error ) {

            System.out.println( error.getMessage() );

        }

    }

    private static void testCharactersAbilitiesBarbarian ( Scanner init ) {

        // wrath_boost, strength_boost, none

        ValidateAbilities validateAbilities = new ValidateAbilities();

        // Exceptions registered: IllegalArgumentException

        ValidateStats validateStats = new ValidateStats();

        int level = validateStats.levelValidation( init );

        double attackPoints = validateStats.attackValidation( init );

        double defensePoints = validateStats.defensePoints( init );

        validateStats.validateAllMethods( level, attackPoints, defensePoints );

        try {

            Abilities value = Abilities.valueOf ( init.next() );

            ValidateUniqueAttributes validateUniqueAttributes = new ValidateUniqueAttributes();

            double fury = validateUniqueAttributes.validateFury( init );

            Barbarian barbarian = new Barbarian( 1000.0, "Armor", "Club",
                    attackPoints, defensePoints, level, "idk", "idk", value, fury );

            if ( value.equals( Abilities.valueOf ( "STRENGTH_BOOST" ) ) ) {

                double getBonusStats = validateAbilities.abilitiesBarbarian( barbarian );

                double attackDeclaration = barbarian.declareAttack() + getBonusStats;

                double blockAttack = barbarian.blockAttack();

                double lifePoints = barbarian.calculateLifePoints();

                double getFury = barbarian.getFury();

                System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nFury: %s\n", attackDeclaration, blockAttack, lifePoints, getFury );

                return;

            }

            if ( value.equals( Abilities.valueOf ( "WRATH_BOOST" ) ) ) {

                double getBonusStats = validateAbilities.abilitiesBarbarian( barbarian );

                double getFury = barbarian.getFury() + getBonusStats;

                double attackDeclaration = barbarian.declareAttack() + getFury;

                double blockAttack = barbarian.blockAttack() + getFury;

                double lifePoints = barbarian.calculateLifePoints() + getFury;

                System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nFury: %s\n", attackDeclaration, blockAttack, lifePoints, getFury );

                return;

            }

            double getFury = barbarian.getFury();

            double attackDeclaration = barbarian.declareAttack();

            double blockAttack = barbarian.blockAttack();

            double lifePoints = barbarian.calculateLifePoints();

            System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nFury: %s\n", attackDeclaration, blockAttack, lifePoints, getFury );

        } catch ( IllegalArgumentException error ) {

            System.out.println( error.getMessage() );

        }

    }

    private static void testCharactersAbilitiesMage ( Scanner init ) {

        // magical_boost, none

        ValidateAbilities validateAbilities = new ValidateAbilities();

        // Exceptions registered: IllegalArgumentException

        ValidateStats validateStats = new ValidateStats();

        int level = validateStats.levelValidation( init );

        double attackPoints = validateStats.attackValidation( init );

        double defensePoints = validateStats.defensePoints( init );

        validateStats.validateAllMethods( level, attackPoints, defensePoints );

        try {

            Abilities value = Abilities.valueOf ( init.next() );

            ValidateUniqueAttributes validateUniqueAttributes = new ValidateUniqueAttributes();

            double mana = validateUniqueAttributes.validateMana( init );

            Mage mage = new Mage( 1000.0, "Armor", "Staff",
                    attackPoints, defensePoints, level, "idk", "idk", value, mana );

            if ( value.equals( Abilities.valueOf ( "MAGICAL_BOOST" ) ) ) {

                double getBonusStats = validateAbilities.abilitiesMage( mage );

                double attackDeclaration = mage.declareAttack() + getBonusStats;

                double blockAttack = mage.blockAttack();

                double lifePoints = mage.calculateLifePoints();

                double getMana = mage.getMana();

                System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nMana: %s\n", attackDeclaration, blockAttack, lifePoints, getMana );

                return;

            }

            double getMana = mage.getMana();

            double attackDeclaration = mage.declareAttack();

            double blockAttack = mage.blockAttack();

            double lifePoints = mage.calculateLifePoints();

            System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nMana: %s\n", attackDeclaration, blockAttack, lifePoints, getMana );

        } catch ( IllegalArgumentException error ) {

            System.out.println( error.getMessage() );

        }

    }

    private static void testCharactersAbilitiesPaladin ( Scanner init ) {

        // healing_boost, defense_boost, none;

        ValidateAbilities validateAbilities = new ValidateAbilities();

        // Exceptions registered: IllegalArgumentException

        ValidateStats validateStats = new ValidateStats();

        int level = validateStats.levelValidation( init );

        double attackPoints = validateStats.attackValidation( init );

        double defensePoints = validateStats.defensePoints( init );

        validateStats.validateAllMethods( level, attackPoints, defensePoints );

        try {

            Abilities value = Abilities.valueOf ( init.next() );

            ValidateUniqueAttributes validateUniqueAttributes = new ValidateUniqueAttributes();

            double divineStrike = validateUniqueAttributes.validateDivineStrike( init );

            Paladin paladin = new Paladin( 1000.0, "Armor", "Staff",
                    attackPoints, defensePoints, level, "idk", "idk", value, divineStrike );

            if ( value.equals( Abilities.valueOf ( "HEALING_BOOST" ) ) ) {

                double getBonusStats = validateAbilities.abilitiesPaladin( paladin );

                double attackDeclaration = paladin.declareAttack() + getBonusStats;

                double blockAttack = paladin.blockAttack();

                double lifePoints = paladin.calculateLifePoints();

                double getDivineStrike = paladin.getDivineStrike();

                System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nDivine Strike: %s\n", attackDeclaration, blockAttack, lifePoints, getDivineStrike );

                return;

            }

            if ( value.equals( Abilities.valueOf ( "DEFENSE_BOOST" ) ) ) {

                double getBonusStats = validateAbilities.abilitiesPaladin( paladin );

                double attackDeclaration = paladin.declareAttack();

                double blockAttack = paladin.blockAttack() + getBonusStats;

                double lifePoints = paladin.calculateLifePoints();

                double getDivineStrike = paladin.getDivineStrike();

                System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nDivine Strike: %s\n", attackDeclaration, blockAttack, lifePoints, getDivineStrike );

                return;

            }

            double getDivineStrike = paladin.getDivineStrike();

            double attackDeclaration = paladin.declareAttack();

            double blockAttack = paladin.blockAttack();

            double lifePoints = paladin.calculateLifePoints();

            System.out.printf( "Attack: %s\nDefense: %s\nLife Points: %s\nMana: %s\n", attackDeclaration, blockAttack, lifePoints, getDivineStrike );

        } catch ( IllegalArgumentException error ) {

            System.out.println( error.getMessage() );

        }

    }

}

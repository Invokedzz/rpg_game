package application;

import java.util.Scanner;

import model.entities.*;

import model.inheritance.Human;

import model.inheritance.abilities.ValidateAbilities;

import model.inheritance.abilities.ValidateStats;

import model.inheritance.abilities.ValidateUniqueAttributes;

import model.inheritance.abilitiesenum.Abilities;

public class KingdomApp {

    public static void main ( String[] args ) {

        Scanner init = new Scanner ( System.in );

        chooseYourCharacter( init );

    }

    private static void chooseYourCharacter ( Scanner init ) {


            System.out.println( "Player 1, choose your character!" );

            System.out.println( "Select k for Knight, m for Mage, b for Barbarian or p for Paladin! " );

            char playerOneChoice = init.next().charAt( 0 );

            createYourCharacter( playerOneChoice, init );

            System.out.println( "Player 2, choose your character!" );

            System.out.println( "Select k for Knight, m for Mage, b for Barbarian or p for Paladin! " );

            char playerTwoChoice = init.next().charAt( 0 );

            createYourCharacter( playerTwoChoice, init );


    }

    private static void createYourCharacter ( char playerChoice, Scanner init ) {

        switch ( playerChoice ) {

            case 'k' | 'K':

                ValidateAbilities validateAbilitiesKnight = new ValidateAbilities();

                // Exceptions registered: IllegalArgumentException

                ValidateStats validateStatsKnight = new ValidateStats();

                int levelKnight = validateStatsKnight.levelValidation( init );

                double attackPointsKnight = validateStatsKnight.attackValidation( init );

                double defensePointsKnight = validateStatsKnight.defensePoints( init );

                validateStatsKnight.validateAllMethods( levelKnight, attackPointsKnight, defensePointsKnight );

                try {

                    Abilities knightAbility = Abilities.valueOf ( init.next() );

                    Knight knight = new Knight( 1000.0, "Armor", "Sword", attackPointsKnight,
                            defensePointsKnight, levelKnight, "idk", "idk", knightAbility );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            case 'p' | 'P':

            //    ValidateAbilities validateAbilities = new ValidateAbilities();

                // Exceptions registered: IllegalArgumentException

                ValidateStats validateStatsPaladin = new ValidateStats();

                ValidateUniqueAttributes validatePaladinAttributes = new ValidateUniqueAttributes();

                int levelPaladin = validateStatsPaladin.levelValidation( init );

                double attackPointsPaladin = validateStatsPaladin.attackValidation( init );

                double defensePointsPaladin = validateStatsPaladin.defensePoints( init );

                validateStatsPaladin.validateAllMethods( levelPaladin, attackPointsPaladin, defensePointsPaladin);

                try {

                    Abilities paladinAbility = Abilities.valueOf ( init.next() );

                    double divineStrike = validatePaladinAttributes.validateDivineStrike( init );

                    Paladin paladin = new Paladin( 1000.0, "Armor", "Staff",
                            attackPointsPaladin, defensePointsPaladin, levelPaladin, "idk", "idk", paladinAbility, divineStrike );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            case 'b' | 'B':

                ValidateStats validateStatsBarbarian = new ValidateStats();

                ValidateUniqueAttributes validateBarbarianAttributes = new ValidateUniqueAttributes();

                int levelBarbarian = validateStatsBarbarian.levelValidation( init );

                double attackPointsBarbarian = validateStatsBarbarian.attackValidation( init );

                double defensePointsBarbarian = validateStatsBarbarian.defensePoints( init );

                validateStatsBarbarian.validateAllMethods( levelBarbarian, attackPointsBarbarian, defensePointsBarbarian);

                try {

                    Abilities barbarianAbility = Abilities.valueOf ( init.next() );

                    double fury = validateBarbarianAttributes.validateFury( init );

                    Barbarian barbarian = new Barbarian( 1000.0, "Armor", "Club",
                            attackPointsBarbarian, defensePointsBarbarian, levelBarbarian, "idk", "idk", barbarianAbility, fury );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            case 'm' | 'M':

                ValidateStats validateStatsMage = new ValidateStats();

                ValidateUniqueAttributes validateMageAttributes = new ValidateUniqueAttributes();

                int levelMage = validateStatsMage.levelValidation( init );

                double attackPointsMage = validateStatsMage.attackValidation( init );

                double defensePointsMage = validateStatsMage.defensePoints( init );

                validateStatsMage.validateAllMethods( levelMage, attackPointsMage, defensePointsMage);

                try {

                    Abilities mageAbility = Abilities.valueOf ( init.next() );

                    double mana = validateMageAttributes.validateMana( init );

                    Mage mage = new Mage( 1000.0, "Armor", "Staff",
                            attackPointsMage, defensePointsMage, levelMage, "idk", "idk", mageAbility, mana );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            default:

                System.out.println( "Enter a valid option!" );

                break;

        }

    }

}

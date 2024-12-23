package application;

import java.util.Scanner;

import model.inheritance.abilities.ValidateAbilities;

import model.inheritance.abilities.ValidateStats;

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

                break;

            case 'p' | 'P':

            //    ValidateAbilities validateAbilities = new ValidateAbilities();

                // Exceptions registered: IllegalArgumentException

                ValidateStats validateStatsPaladin = new ValidateStats();

                int levelPaladin = validateStatsPaladin.levelValidation( init );

                double attackPointsPaladin = validateStatsPaladin.attackValidation( init );

                double defensePointsPaladin = validateStatsPaladin.defensePoints( init );

                validateStatsPaladin.validateAllMethods( levelPaladin, attackPointsPaladin, defensePointsPaladin);

                break;

            case 'b' | 'B':

                ValidateStats validateStatsBarbarian = new ValidateStats();

                int levelBarbarian = validateStatsBarbarian.levelValidation( init );

                double attackPointsBarbarian = validateStatsBarbarian.attackValidation( init );

                double defensePointsBarbarian = validateStatsBarbarian.defensePoints( init );

                validateStatsBarbarian.validateAllMethods( levelBarbarian, attackPointsBarbarian, defensePointsBarbarian);

                break;

            case 'm' | 'M':

                ValidateStats validateStatsMage = new ValidateStats();

                int levelMage = validateStatsMage.levelValidation( init );

                double attackPointsMage = validateStatsMage.attackValidation( init );

                double defensePointsMage = validateStatsMage.defensePoints( init );

                validateStatsMage.validateAllMethods( levelMage, attackPointsMage, defensePointsMage);

                break;

            default:

                System.out.println( "Enter a valid option!" );

                break;

        }

    }

}

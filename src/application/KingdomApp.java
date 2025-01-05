package application;

import java.util.Scanner;

import model.entities.*;

import model.inheritance.abilities.*;

import model.inheritance.abilitiesenum.Abilities;

public class KingdomApp {

    public static void initSystem () {

        Scanner sc = new Scanner ( System.in );

        chooseYourCharacter( sc );

    }

    private static void chooseYourCharacter ( Scanner sc ) {

            System.out.println( "Player 1, choose your character!" );

            System.out.println( "Select k for Knight, m for Mage, b for Barbarian or p for Paladin! " );

            char playerOneChoice = sc.next().charAt( 0 );

            Knight playerOne = createYourCharacter( playerOneChoice, sc );

            System.out.println( "Player 2, choose your character!" );

            System.out.println( "Select k for Knight, m for Mage, b for Barbarian or p for Paladin! " );

            char playerTwoChoice = sc.next().charAt( 0 );

            Knight playerTwo = createYourCharacter( playerTwoChoice, sc );

            assert playerOne != null;

            startBattle( playerOne, playerTwo, sc );

    }

    private static void startBattle ( Knight playerOne, Knight playerTwo, Scanner sc ) {

        System.out.println( "Now, be prepared! The battle has begun!\n" );

        int turns = 1;

        while ( playerOne.isAlive() && playerTwo.isAlive() ) {

            System.out.println();

            System.out.printf( "Turn %s\n", turns );

            if ( turns % 2 == 0 ) {

                System.out.println( "Player one turn!\n" );

                determinePlayerTurn( playerOne, playerTwo, sc );

            }

            if ( turns % 2 != 0 ) {

                System.out.println( "Player two turn!\n" );

                determinePlayerTurn( playerTwo, playerOne, sc );

            }

            turns ++;

        }

        if ( playerOne.isAlive() ) System.out.println( "Player one wins!" );

        else System.out.println( "Player two wins!" );

    }

    private static void determinePlayerTurn ( Knight turnPlayer, Knight opponent, Scanner sc ) {

         System.out.println();

         System.out.printf( "%s turn!", turnPlayer.getName() );

         System.out.printf( " %s waits for the move...", opponent.getName() );

        System.out.println( "Choose your action!\n" );

        System.out.println( "1. Attack" );

        System.out.println( "2. Heal" );

        System.out.println( "3. Run" );

        int choice = sc.nextInt();

        double damage;

        switch ( choice ) {

            case 1: // attack

                damage = turnPlayer.declareAttack();

                System.out.println();

                System.out.printf( "%s declares a powerful attack, that deals %s damage!\n", turnPlayer.getName(), damage );

                double opponentTakenDamageOutput = opponent.takeDamage( damage );

                System.out.printf( "The attack was brutal! %s have %s life points remaining!\n", opponent.getName(), opponentTakenDamageOutput );

                break;

            case 2: // heal

                // 3 potions for each player

                // I need to fix this shit

                int potionsQuantity = turnPlayer.usePotions( 1 );

                System.out.printf( "You have %s potions left!\n", potionsQuantity );

                break;

            case 3: // run (surrender)

                System.out.println();

                System.out.println( turnPlayer.getName() + " runs from the battle! Coward!\n" );

                turnPlayer.takeDamage( 9999 );

                return;

            default:

                System.out.println( "Invalid choice, dummy!" );

                determinePlayerTurn( turnPlayer, opponent, sc );

        }

    }

    private static Knight createYourCharacter ( char playerChoice, Scanner sc ) {

        switch ( playerChoice ) {

            case 'k', 'K':

                ValidateAbilities validateAbilitiesKnight = new ValidateAbilities();

                CharacterName characterNameKnight = new CharacterName();

                // Exceptions registered: IllegalArgumentException

                ValidateStats validateStatsKnight = new ValidateStats();

                String knightName = characterNameKnight.validateName( sc );

                int levelKnight = validateStatsKnight.levelValidation( sc );

                double attackPointsKnight = validateStatsKnight.attackValidation( sc );

                double defensePointsKnight = validateStatsKnight.defensePoints( sc );

                validateStatsKnight.validateAllMethods( levelKnight, attackPointsKnight, defensePointsKnight );

                try {

                    Abilities knightAbility = Abilities.valueOf ( sc.next() );

                    Knight knight = new Knight( 1000.0, "Armor", "Sword", attackPointsKnight,
                            defensePointsKnight, knightName, levelKnight, "idk", knightAbility );

                    if ( knightAbility.equals( Abilities.valueOf ( "DEFENSE_BOOST" ) ) ) {

                        double getBonusStats = validateAbilitiesKnight.abilitiesKnight( knight );

                        double attackDeclaration = knight.declareAttack();

                        double blockAttack = knight.blockAttack() + getBonusStats;

                        double lifePoints = knight.calculateLifePoints();

                        return new Knight ( lifePoints, "Armor", "Sword", attackDeclaration, blockAttack,
                                knightName, levelKnight, "idk", knightAbility );

                    }

                    if ( knightAbility.equals( Abilities.valueOf( "STRENGTH_BOOST" ) ) ) {

                        double getBonusStats = validateAbilitiesKnight.abilitiesKnight( knight );

                        double attackDeclaration = knight.declareAttack() + getBonusStats;

                        double blockAttack = knight.blockAttack();

                        double lifePoints = knight.calculateLifePoints();

                        return new Knight ( lifePoints, "Armor", "Sword",
                                attackDeclaration, blockAttack, knightName, levelKnight,
                                "idk", knightAbility );

                    }

                    double attackDeclaration = knight.declareAttack();

                    double blockAttack = knight.blockAttack();

                    double lifePoints = knight.calculateLifePoints();

                    return new Knight ( lifePoints, "Armor", "Sword",
                            attackDeclaration, blockAttack, knightName, levelKnight,
                            "idk", knightAbility );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            case 'p', 'P':

                // Exceptions registered: IllegalArgumentException

                ValidateAbilities validateAbilitiesPaladin = new ValidateAbilities();

                CharacterName characterNamePaladin = new CharacterName();

                ValidateStats validateStatsPaladin = new ValidateStats();

                ValidateUniqueAttributes validatePaladinAttributes = new ValidateUniqueAttributes();

                String paladinName = characterNamePaladin.validateName( sc );

                int levelPaladin = validateStatsPaladin.levelValidation( sc );

                double attackPointsPaladin = validateStatsPaladin.attackValidation( sc );

                double defensePointsPaladin = validateStatsPaladin.defensePoints( sc );

                validateStatsPaladin.validateAllMethods( levelPaladin, attackPointsPaladin, defensePointsPaladin);

                try {

                    System.out.println( "Enter the Paladin Ability! (HEALING_BOOST, DEFENSE_BOOST or NONE" );

                    Abilities paladinAbility = Abilities.valueOf ( sc.next() );

                    double divineStrike = validatePaladinAttributes.validateDivineStrike( sc );

                    Paladin paladin = new Paladin( 1000.0, "Armor", "Hammer",
                            attackPointsPaladin, defensePointsPaladin, paladinName,
                            levelPaladin, "idk", paladinAbility, divineStrike );

                    if ( paladinAbility.equals( Abilities.valueOf ( "HEALING_BOOST" ) ) ) {

                        double getBonusStats = validateAbilitiesPaladin.abilitiesPaladin( paladin );

                        double attackDeclaration = paladin.declareAttack() + getBonusStats;

                        double blockAttack = paladin.blockAttack();

                        double lifePoints = paladin.calculateLifePoints();

                        double getDivineStrike = paladin.getDivineStrike();

                        return new Paladin ( lifePoints, "Armor", "Hammer",
                                attackDeclaration, blockAttack, paladinName, levelPaladin,
                                "idk", paladinAbility, getDivineStrike );

                    }

                    if ( paladinAbility.equals( Abilities.valueOf ( "DEFENSE_BOOST" ) ) ) {

                        double getBonusStats = validateAbilitiesPaladin.abilitiesPaladin( paladin );

                        double attackDeclaration = paladin.declareAttack();

                        double blockAttack = paladin.blockAttack() + getBonusStats;

                        double lifePoints = paladin.calculateLifePoints();

                        double getDivineStrike = paladin.getDivineStrike();

                        return new Paladin ( lifePoints, "Armor", "Hammer",
                                attackDeclaration, blockAttack, paladinName, levelPaladin,
                                "idk", paladinAbility, getDivineStrike );

                    }

                    double getDivineStrike = paladin.getDivineStrike();

                    double attackDeclaration = paladin.declareAttack();

                    double blockAttack = paladin.blockAttack();

                    double lifePoints = paladin.calculateLifePoints();

                    return new Paladin ( lifePoints, "Armor", "Hammer",
                            attackDeclaration, blockAttack, paladinName, levelPaladin, "idk"
                            , paladinAbility, getDivineStrike );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            case 'b', 'B':

                ValidateAbilities validateAbilitiesBarbarian = new ValidateAbilities();

                ValidateStats validateStatsBarbarian = new ValidateStats();

                ValidateUniqueAttributes validateBarbarianAttributes = new ValidateUniqueAttributes();

                CharacterName characterNameBarbarian = new CharacterName();

                String barbarianName = characterNameBarbarian.validateName( sc );

                int levelBarbarian = validateStatsBarbarian.levelValidation( sc );

                double attackPointsBarbarian = validateStatsBarbarian.attackValidation( sc );

                double defensePointsBarbarian = validateStatsBarbarian.defensePoints( sc );

                validateStatsBarbarian.validateAllMethods( levelBarbarian, attackPointsBarbarian, defensePointsBarbarian );

                try {

                    System.out.println( "Enter the Barbarian Ability! (STRENGTH_BOOST, WRATH_BOOST or NONE)" );

                    Abilities barbarianAbility = Abilities.valueOf ( sc.next() );

                    double fury = validateBarbarianAttributes.validateFury( sc );

                    Barbarian barbarian = new Barbarian ( 1000.0, "Armor", "Club",
                            attackPointsBarbarian, defensePointsBarbarian, barbarianName,
                            levelBarbarian, "idk", barbarianAbility, fury );

                    if ( barbarianAbility.equals( Abilities.valueOf ( "STRENGTH_BOOST" ) ) ) {

                        double getBonusStats = validateAbilitiesBarbarian.abilitiesBarbarian( barbarian );

                        double attackDeclaration = barbarian.declareAttack() + getBonusStats;

                        double blockAttack = barbarian.blockAttack();

                        double lifePoints = barbarian.calculateLifePoints();

                        double getFury = barbarian.getFury();

                        return new Barbarian ( lifePoints, "Armor", "Club",
                                attackDeclaration, blockAttack, barbarianName, levelBarbarian, "idk"
                                , barbarianAbility, getFury );

                    }

                    if ( barbarianAbility.equals( Abilities.valueOf ( "WRATH_BOOST" ) ) ) {

                        double getBonusStats = validateAbilitiesBarbarian.abilitiesBarbarian( barbarian );

                        double getFury = barbarian.getFury() + getBonusStats;

                        double attackDeclaration = barbarian.declareAttack() + getFury;

                        double blockAttack = barbarian.blockAttack() + getFury;

                        double lifePoints = barbarian.calculateLifePoints() + getFury;

                        return new Barbarian ( lifePoints, "Armor", "Club",
                                attackDeclaration, blockAttack, barbarianName, levelBarbarian, "idk"
                                , barbarianAbility, getFury );

                    }

                    double getFury = barbarian.getFury();

                    double attackDeclaration = barbarian.declareAttack();

                    double blockAttack = barbarian.blockAttack();

                    double lifePoints = barbarian.calculateLifePoints();

                    return new Barbarian ( lifePoints, "Armor", "Club",
                            attackDeclaration, blockAttack, barbarianName, levelBarbarian, "idk"
                            , barbarianAbility, getFury );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            case 'm', 'M':

                ValidateAbilities validateAbilitiesMage = new ValidateAbilities();

                CharacterName characterNameMage = new CharacterName();

                ValidateStats validateStatsMage = new ValidateStats();

                ValidateUniqueAttributes validateMageAttributes = new ValidateUniqueAttributes();

                String mageName = characterNameMage.validateName( sc );

                int levelMage = validateStatsMage.levelValidation( sc );

                double attackPointsMage = validateStatsMage.attackValidation( sc );

                double defensePointsMage = validateStatsMage.defensePoints( sc );

                validateStatsMage.validateAllMethods( levelMage, attackPointsMage, defensePointsMage);

                try {

                    System.out.println( "Enter the Mage Ability (MAGICAL_BOOST or NONE)" );

                    Abilities mageAbility = Abilities.valueOf ( sc.next() );

                    double mana = validateMageAttributes.validateMana( sc );

                    Mage mage = new Mage( 1000.0, "Armor", "Staff",
                            attackPointsMage, defensePointsMage, mageName, levelMage,
                            "idk", mageAbility, mana );

                    if ( mageAbility.equals( Abilities.valueOf ( "MAGICAL_BOOST" ) ) ) {

                        double getBonusStats = validateAbilitiesMage.abilitiesMage( mage );

                        double attackDeclaration = mage.declareAttack() + getBonusStats;

                        double blockAttack = mage.blockAttack();

                        double lifePoints = mage.calculateLifePoints();

                        double getMana = mage.getMana();

                        return new Mage ( lifePoints, "Armor", "Staff",
                                attackDeclaration, blockAttack, mageName, levelMage,
                                "idk", mageAbility, getMana );

                    }

                    double getMana = mage.getMana();

                    double attackDeclaration = mage.declareAttack();

                    double blockAttack = mage.blockAttack();

                    double lifePoints = mage.calculateLifePoints();

                    return new Mage ( lifePoints, "Armor", "Staff",
                            attackDeclaration, blockAttack, mageName, levelMage,
                            "idk", mageAbility, getMana );

                } catch ( IllegalArgumentException error ) {

                    System.out.printf( "Error: %s", error.getMessage() );

                }

                break;

            default:

                System.out.println( "Enter a valid option!" );

                break;

        }

        return null;

    }

}

package model.inheritance.abilities;

import model.exceptions.AttackPointsException;

import model.exceptions.InvalidLevelException;

import java.util.Scanner;

public final class ValidateStats {

    // class created to validate attack/defense points
    // attack points, min: 5, max: 100 -> default,
    // without considering any kind of boosts or abilities
    // level limit: 100

    private boolean trueIntComponent (Scanner init ) {

        return !init.hasNextInt();

    }

    private boolean trueDoubleComponent(Scanner init ) {

        return !init.hasNextDouble();

    }

    public int levelValidation ( Scanner level ) {

        int verifyLevel;

        System.out.println( "Enter your character level, REMEMBER: atk, def and lvl must be equals!" );

        while ( trueIntComponent( level ) ) {

            System.out.println( "Enter a valid level!" );

            level.next();

        }

        verifyLevel = level.nextInt();

        while ( verifyLevel <= 0 || verifyLevel > 100 ) {

            System.out.println( "Enter a valid level! (max: 100/min: 1)" );

            while ( trueIntComponent( level ) ) {

                System.out.println( "Enter a valid level! (max: 100/min: 1)" );

                level.next();

            }

            verifyLevel = level.nextInt();

        }

        return verifyLevel;

    }

    public double attackValidation ( Scanner attackPoints ) {

        double verifyAttack;

        System.out.println( "Enter your character attack points: (max: 100/min: 5)" );

        System.out.println("REMEMBER, atk, def and lvl must be equals!");

        while ( trueDoubleComponent( attackPoints ) ) {

            System.out.println( "Enter valid attack points!" );

            attackPoints.next();

        }

        verifyAttack = attackPoints.nextDouble();

        while ( verifyAttack < 5 || verifyAttack > 100 ) {

            System.out.println( "Enter valid attack points (max: 100/min: 5)" );

            while ( trueDoubleComponent( attackPoints ) ) {

                System.out.println( "Enter valid attack points!" );

                attackPoints.next();

            }

            verifyAttack = attackPoints.nextDouble();

        }

        return verifyAttack;

    }

    public double defensePoints ( Scanner defensePoints ) {

        double verifyDefense;

        System.out.println( "Enter your character defense points (max: 100/min: 5): " );

        System.out.println("REMEMBER, atk, def and lvl must be equals!");

        while ( trueDoubleComponent( defensePoints ) ) {

            System.out.println( "Enter valid defense points!" );

            defensePoints.next();

        }

        verifyDefense = defensePoints.nextDouble();

        while ( verifyDefense < 5 || verifyDefense > 100 ) {

            System.out.println( "Enter valid defense points! (max: 100/min: 1)" );

            while ( trueDoubleComponent( defensePoints ) ) {

                System.out.println( "Enter valid defense points!" );

                defensePoints.next();

            }

            verifyDefense = defensePoints.nextDouble();

        }

        return verifyDefense;

    }

    // level, attack, defense must be equal

    public void validateAllMethods ( int level, double attackPoints, double defensePoints ) {

        if ( level != attackPoints || level != defensePoints ) {

            try {

                if ( attackPoints != defensePoints ) throw new AttackPointsException( "Level, Attack and Defense must be equals." );

                throw new InvalidLevelException( "Level, Attack and Defense must be equals." );

            } catch ( AttackPointsException | InvalidLevelException error ) {

                System.out.printf( "Error: %s", error.getMessage() );

            }

        }

        System.out.println( "All stats validated!\n" );

    }

}

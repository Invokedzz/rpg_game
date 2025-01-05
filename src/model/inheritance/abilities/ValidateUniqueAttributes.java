package model.inheritance.abilities;

import java.util.Scanner;

// fury (double), mana (double), divineStrike (double) -> Barbarian, Mage, Paladin

public final class ValidateUniqueAttributes {

    private boolean trueDoubleComponent ( Scanner init ) {

        return !init.hasNextDouble();

    }

    public double validateFury ( Scanner furyPoints ) {

        double validFury;

        System.out.println( "Enter the value for Fury stats (max: 100/min: 1)" );

        while (trueDoubleComponent(furyPoints)) {

            System.out.println( "Enter a valid number for Fury stat!" );

            furyPoints.next();

        }

        validFury = furyPoints.nextDouble();

        while ( validFury <= 0 || validFury > 100 ) {

            System.out.println( "Enter a valid Fury value! (max: 100/min: 1)" );

            while (trueDoubleComponent(furyPoints)) {

                System.out.println( "Enter a double number for Fury stat!" );

                furyPoints.next();

            }

            validFury = furyPoints.nextDouble();

        }

        return validFury;

    }

    public double validateMana ( Scanner manaPoints ) {

        double validMana;

        System.out.println( "Enter the value for Mana stats (max: 100/min: 1)" );

        while (trueDoubleComponent(manaPoints)) {

            System.out.println( "Enter a valid number for Mana stat!" );

            manaPoints.next();

        }

        validMana = manaPoints.nextDouble();

        while ( validMana <= 0 || validMana > 100 ) {

            System.out.println( "Enter a valid Mana value! (max: 100/min: 1)" );

            while (trueDoubleComponent(manaPoints)) {

                System.out.println( "Enter a double number for Mana stat!" );

                manaPoints.next();

            }

            validMana = manaPoints.nextDouble();

        }

        return validMana;

    }

    public double validateDivineStrike ( Scanner divineStrikePoints ) {

        double validDivineStrike;

        System.out.println( "Enter the value for Divine Strike stat (max: 100/min: 1)" );

        while (trueDoubleComponent(divineStrikePoints)) {

            System.out.println( "Enter a valid number for Divine Strike stat!" );

            divineStrikePoints.next();

        }

        validDivineStrike = divineStrikePoints.nextDouble();

        while ( validDivineStrike <= 0 || validDivineStrike > 100 ) {

            System.out.println( "Enter a valid Divine Strike value! (max: 100/min: 1)" );

            while (trueDoubleComponent(divineStrikePoints)) {

                System.out.println( "Enter a double number for Divine Strike stat!" );

                divineStrikePoints.next();

            }

            validDivineStrike = divineStrikePoints.nextDouble();

        }

        return validDivineStrike;

    }

}

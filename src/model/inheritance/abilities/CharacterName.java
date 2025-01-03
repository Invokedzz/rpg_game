package model.inheritance.abilities;

import java.util.Scanner;

public class CharacterName {

    public String validateName ( Scanner sc ) {

        String name;

        System.out.println( "Enter your character name: " );

        name = sc.next();

        while ( !name.matches("^[a-zA-Z]+$")) {

            System.out.println( "Enter a valid name for your character!" );

            name = sc.next();

        }

        return name;

    }

}

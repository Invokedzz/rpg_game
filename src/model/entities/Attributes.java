package model.entities;

public interface Attributes {

    double declareAttack ();

    double blockAttack ();

    double calculateLifePoints ();

    boolean isAlive ();

    double takeDamage ( double damage );

    int usePotions ( int quantity );

}

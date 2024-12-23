package model.inheritance.abilitiesenum;

public enum Abilities {

    MAGICAL_BOOST, // Mage, Necromancer -> extends Human

    STRENGTH_BOOST, // Knight, Samurai -> extends Human

    WRATH_BOOST, // Barbarian

    DEFENSE_BOOST, // Tank, Paladin -> extends Human

    HEALING_BOOST, // Paladin, Healer

    NONE,

    // For the Knight class,
    // we're going to use the STRENGTH_BOOST AND DEFENSE_BOOST

    // STRENGTH_BOOST: raises the atk by 50% for 3 turns;
    // DEFENSE_BOOST: the user can't take damage for 2 turns,
    // but his atk drops by 80%.

    // WRATH_BOOST: raises the atk and def by 100% for 2 turns,
    // but the user can't atk for 1 turn, and also, they lose half of their life points

}

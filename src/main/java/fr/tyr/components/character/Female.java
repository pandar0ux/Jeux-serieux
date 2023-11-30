package fr.tyr.components.character;

import fr.tyr.components.character.identity.enums.FirstName;
import fr.tyr.components.character.identity.enums.LastName;
import fr.tyr.components.character.personality.enums.thoughts.GenderThoughts;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.enums.thoughts.OriginThoughts;
import fr.tyr.components.character.personality.enums.thoughts.StyleThoughts;
import fr.tyr.components.character.personality.enums.pastFacts.CommonPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.GenderPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.OriginPastFacts;
import fr.tyr.components.character.personality.enums.pastFacts.StylePastFacts;
import fr.tyr.components.character.style.*;
import fr.tyr.tools.Vector2D;

public class Female extends Character{
    /**
     * Create a Female Character
     * @param position The position of the component
     * @param skin The character's skin
     * @param hair The character's hair
     * @param eyes The character's eyes
     * @param shirt The character's shirt
     * @param firstName The character's firstname
     * @param lastName The character's lastname
     * @param age The character's age
     */
    public Female(Vector2D position, Skin skin, Hair hair, Eyes eyes, Shirt shirt, FirstName firstName, LastName lastName, int age, CommonPastFacts commonPastFact, OriginPastFacts originPastFact, GenderPastFacts genderPastFact, StylePastFacts stylePastFact, MentalStrength mentalStrength, OriginThoughts originThoughts, GenderThoughts genderThoughts, StyleThoughts styleThoughts) {
        super(position, skin, hair, eyes, shirt, firstName, lastName, age, commonPastFact, originPastFact, genderPastFact, stylePastFact, mentalStrength, originThoughts, genderThoughts, styleThoughts);
    }
}

package fr.tyr.components.character.personality.pastFacts.enums;

import fr.tyr.components.character.identity.enums.Gender;
import fr.tyr.components.character.personality.enums.MentalStrength;
import fr.tyr.components.character.personality.thoughts.enums.GenderThoughts;
import fr.tyr.components.violence.enums.Types;

import java.util.ArrayList;
import java.util.List;

public enum GenderPastFacts {
    NONE("Aucun fait", "Rien n'a particulièrement marqué la personne sur son sexe", MentalStrength.NORMAL, null, Gender.UNKNOWN, Types.VERBAL),
    SEXUAL_HARASSMENT("Harcèlement sexuel", "La personne a vécu un harcèlement sexuel", MentalStrength.WEAK, null, Gender.UNKNOWN, Types.VERBAL),
    MALE_SUDDEN_DUMP("Séparation soudaine", "La personne ne supporte pas sa séparation", MentalStrength.NORMAL, GenderThoughts.MISOGYNIST, Gender.UNKNOWN, Types.VERBAL),
    FEMALE_SUDDEN_DUMP("Séparation soudaine", "La personne ne supporte pas sa séparation", MentalStrength.NORMAL, GenderThoughts.MISANDRE, Gender.UNKNOWN, Types.VERBAL),
    ACTIVIST("Activiste", "La personne trouve insensé les différences faites entre les genres", MentalStrength.BOLD, GenderThoughts.DISLIKES_ALL_COMMENTS, Gender.UNKNOWN, Types.VERBAL),
    EXTREM_FEMINIST("Féministe extrêmiste", "", MentalStrength.BOLD, GenderThoughts.MISANDRE, Gender.FEMALE, Types.PSYCHOLOGICAL),
    SOCIAL_OPPRESSION_ON_WOMEN("Oppression sociale sur les femmes", "La personne a grandi auprès de personnes se moquant des femmes", MentalStrength.NORMAL, GenderThoughts.MISOGYNIST, Gender.UNKNOWN, Types.VERBAL),
    SOCIAL_OPPRESSION_ON_MEN("Oppression sociale sur les homme", "La personne vit avec des personnes trouvant les hommes dégoûtants", MentalStrength.NORMAL, GenderThoughts.MISANDRE, Gender.UNKNOWN, Types.VERBAL),
    ;
    private final String title;
    private final String description;
    private final MentalStrength leaningMentalStrength;
    private final GenderThoughts overridingThoughts;
    private final Gender concernedGender;
    private final Types type;

    /**
     * Create an instance of GenderPastFacts
     * @param title The past fact's title
     * @param description The past fact's description
     * @param leaningMentalStrength The leaning mental strength of the character
     * @param overridingThoughts The overrided GenderThought
     * @param concernedGender The concerned gender
     * @param type vulnerability or invulnerability to violence
     */
    GenderPastFacts(String title, String description, MentalStrength leaningMentalStrength, GenderThoughts overridingThoughts, Gender concernedGender, Types type){
        this.title = title;
        this.description = description;
        this.leaningMentalStrength = leaningMentalStrength;
        this.overridingThoughts = overridingThoughts;
        this.concernedGender = concernedGender;
        this.type = type;
    }

    /**
     * Send the past fact's title
     * @return The past fact's title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Send the past fact's description
     * @return The past fact's description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Send the leaning mental strength
     * @return The leaning mental strength
     */
    public MentalStrength getLeaningMentalStrength(){
        return this.leaningMentalStrength;
    }

    /**
     * Send the overrided GenderThought
     * @return The overrided GenderThought
     */
    public GenderThoughts getOverridingThoughts() {
        return overridingThoughts;
    }

    /**
     * Send the concerned gender
     * @return The concerned gender
     */
    public Gender getConcernedGender(){
        return this.concernedGender;
    }
    /**
     * Send the concerned violence type
     * @return The concerned violence type
     */
    public Types getType(){return this.type;}

    /**
     * Send all the past facts from the enum concerning the gender g in the parameters
     * @param g The gender
     * @return The past facts corresponding to the gender
     */
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g){
        List<GenderPastFacts> facts = new ArrayList<>();

        for(GenderPastFacts fact : GenderPastFacts.values()){
            if(fact.concernedGender == Gender.UNKNOWN || fact.concernedGender == g)
                facts.add(fact);
        }
        return facts;
    }

    /**
     * Send all the past facts from the list parameter concerning the gender g in the parameters
     * @param g The gender
     * @param genderPastFacts The array of GenderPastFacts
     * @return The past facts corresponding to the gender
     */
    public static List<GenderPastFacts> getAllGenderPastFacts(Gender g, List<GenderPastFacts> genderPastFacts){
        List<GenderPastFacts> facts = new ArrayList<>();

        for(GenderPastFacts fact : genderPastFacts){
            if(fact.concernedGender == Gender.UNKNOWN || fact.concernedGender == g)
                facts.add(fact);
        }
        return facts;
    }
}

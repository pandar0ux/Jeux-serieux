package fr.tyr.components.violence;

import fr.tyr.Main;
import fr.tyr.components.violence.enums.*;

import java.util.List;
import java.util.Random;

import static fr.tyr.components.violence.enums.Types.PSYCHOLOGICAL;

public class ViolenceCardBuilder {
    private ViolenceCard violenceCard = new ViolenceCard();
    static Random rand = new Random();

    /**
     * Generate the violence's icon
     */
    public void generateIcon(Types type){
        Icon icon;
        switch (type){
            case VERBAL -> {
                icon = Icon.VERBAL;
                break;
            }
            case PSYCHOLOGICAL -> {
                icon = Icon.PSYCHOLOGICAL;
            }
            case ECONOMICAL -> {
                icon = Icon.ECONOMICAL;
            }
            case SEXUAL -> {
                icon = Icon.SEXUAL;
            }
            default -> {
                icon = Icon.PHYSICAL;
            }
        }
        this.violenceCard.setIcon(icon);
    }
    /**
     * Generate the violence's background
     */
    public void generateBackground(Types type){
        Background background;
        switch (type){
            case VERBAL -> {
                background = Background.VERBAL;
            }
            case PSYCHOLOGICAL -> {
                background = Background.PSYCHOLOGICAL;
            }
            case ECONOMICAL -> {
                background = Background.ECONOMICAL;
            }
            case SEXUAL -> {
                background = Background.SEXUAL;
            }
            default -> {
                background = Background.PHYSICAL;
            }
        }
        this.violenceCard.setBackground(background);
    }
    /**
     * Generate the violence's acts
     */
    public void generateActs(Types type){
        try {
            List<Acts> actsList = Acts.getAllActs(type);

            this.violenceCard.setActs(Acts.valueOf(actsList.get(rand.nextInt(0, actsList.size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une coupe de base
            this.violenceCard.setType(Types.PHYSICAL);
        }
    }
    /**
     * Generate the violence's types
     */
    public void generateType(){
        try {
            List<Types> typesList = List.of(Types.values());

            this.violenceCard.setType(Types.valueOf(typesList.get(rand.nextInt(0, typesList.size())).name()));
        }
        catch (Exception e){
            //Passage de l'information
            Main.getLogger().info(e.getMessage());

            //Retour d'une coupe de base
            this.violenceCard.setType(Types.PHYSICAL);
        }
    }

    /**
     * Send the violenceCard
     * @return the violenceCard
     */
    public ViolenceCard getViolenceCard(){
        return this.violenceCard;
    }

}
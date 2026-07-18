package oopCode;

public enum GeoPoliticalZone {
    NORTH_CENTRAL("Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateu"),
    NORTH_EAST("Adamawa", "Bauchi", "Borno", "Gambia", "Taraba", "Yobe"),
    NORTH_WEST("Kaduna", "Katsina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"),
    SOUTH_EAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"),
    SOUTH_SOUTH("Akwa-ibom", "Bayelsa", "Cross-river", "Delta", "Edo", "Rivers"),
    SOUTH_WEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo");

    private final String [] states;

    GeoPoliticalZone(String... states){
        this.states = states;
    }

    public boolean presentState(String state){
        for(String realState : states){
            if(realState.equalsIgnoreCase(state)){
                return true;
            }
        }
        return false;
    }

    public static GeoPoliticalZone checkZone(String state){
        for(GeoPoliticalZone zone : GeoPoliticalZone.values()){
            if(zone.presentState(state)){
                return zone;
            }
        }
        return null;
    }
}


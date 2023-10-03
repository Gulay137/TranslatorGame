package enums;







public enum Selections {
	
	    PLAY_AZERBAIJANI("Play (Azerbaijani)"),
	    PLAY_FRENCH("Play (French)"),
	    LOAD_FROM_FILE("Load Word Pairs from File"),
	    EXIT("Exit");

	    private final String option;

	    Selections(String option) {
	        this.option = option;
	    }

	    @Override
	    public String toString() {
	        return option;
	    }
	}



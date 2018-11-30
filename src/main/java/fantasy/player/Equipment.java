package fantasy.player;

public enum Equipment {
    AXE(10),
    POTION(15),
    SWORD(20),
    WAND(8),
    STAFF(11),
    ARMOR(18);

    private final int value;

    Equipment(int value) {
        this.value = value;
    }
        public int getValue () {
            return value;
        }
    }



package org.minty.superteams.util;
public enum Team {

    YELLOW("yellow", "white"),
    WHITE("white", "green"),
    GREEN("green", "blue"),
    BLUE("blue", "yellow");

    private final String name;
    private final String nextTeamName;

    Team(String name, String nextTeamName) {
        this.name = name;
        this.nextTeamName = nextTeamName;
    }

    public static Team fromName(String name) {
        for (Team team : values()) {
            if (team.name.equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null; // Или бросить исключение, если команда не найдена
    }

    public String getNextTeamName() {
        return nextTeamName;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package BusinessLogic.Match;

public class Team {
    private String teamID;
    private String name;
    private String country;
    private Integer playerCount;
    private Integer memberCount;

    public Team(String teamID, String name, String country, Integer playerCount, Integer memberCount) {
        this.teamID = teamID;
        this.name = name;
        this.country = country;
        this.playerCount = playerCount;
        this.memberCount = memberCount;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }
}

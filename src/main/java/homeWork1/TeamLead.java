package homeWork1;

public class TeamLead {
    private int id;
    private String name;
    private String surname;
    private int teamLeadAge;

    public TeamLead(int id, String name, String surname, int teamLeadAge) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.teamLeadAge = teamLeadAge;
    }

    public TeamLead(String name, String surname, int teamLeadAge) {
        this.name = name;
        this.surname = surname;
        this.teamLeadAge = teamLeadAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTeamLeadAge() {
        return teamLeadAge;
    }

    public void setTeamLeadAge(int teamLeadAge) {
        this.teamLeadAge = teamLeadAge;
    }

    @Override
    public String toString() {
        return "TeamLead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", team_lead_age=" + teamLeadAge +
                '}';
    }
}

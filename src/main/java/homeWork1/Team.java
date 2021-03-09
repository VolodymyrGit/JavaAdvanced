package homeWork1;

public class Team {
    private int id;
    private String name;
    private int teamSize;
    private int classRoom;
    private int teamLeadId;

    public Team(int id, String name, int teamSize, int classRom, int teamLeadId) {
        this.id = id;
        this.name = name;
        this.teamSize = teamSize;
        this.classRoom = classRom;
        this.teamLeadId = teamLeadId;
    }

    public Team(String name, int teamSize, int classRom, int teamLeadId) {
        this.name = name;
        this.teamSize = teamSize;
        this.classRoom = classRom;
        this.teamLeadId = teamLeadId;
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

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public int getTeamLeadId() {
        return teamLeadId;
    }

    public void setTeamLeadId(int teamLeadId) {
        this.teamLeadId = teamLeadId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamSize=" + teamSize +
                ", classRoom=" + classRoom +
                ", teamLeadId=" + teamLeadId +
                '}';
    }
}

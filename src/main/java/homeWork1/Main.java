package homeWork1;

public class Main {

    public static void main(String[] args) {

//        TeamLeadDao.addToTable(new TeamLead("John", "Doe", 45));

        TeamLeadDao teamLeadDao = new TeamLeadDao();
        teamLeadDao.findById(1);
    }
}

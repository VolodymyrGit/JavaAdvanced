package homeWork1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamLeadDao {

//    CREATE
    public static void addToTable(TeamLead teamLead) {
        try (Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO " +
                            "team_lead (name, surname, team_lead_age) VALUES (?,?,?)");

            statement.setString(1, teamLead.getName());
            statement.setString(2, teamLead.getSurname());
            statement.setInt(3, teamLead.getTeamLeadAge());

            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    READ ALL
    public static List<TeamLead> findAll() {

        List<TeamLead> teamLeads = new ArrayList();

        try (Connection connection = PostgresqlConnector.getConnection()) {

            Statement statement =
                    connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT  * FROM team_lead");

            while (rs.next()) {
                TeamLead teamLead = new TeamLead(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("team_lead_age"));

                System.out.println(teamLead);
                teamLeads.add(teamLead);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamLeads;
    }


//    READ BY ID
    public static Optional<TeamLead> findById(int id) {

        try (Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM team_lead WHERE id = ?");
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                TeamLead tl = new TeamLead(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("team_lead_age"));

                System.out.println(tl);
                return Optional.ofNullable(tl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


//    UPDATE
    public TeamLead updateTL(int idWHERE, TeamLead teamLead) {

        String sqlUpdate = "UPDATE team_lead SET name = ?, surname = ?, team_lead_age = ? WHERE id = ?";

        try(Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sqlUpdate);

            statement.setString(1, teamLead.getName());
            statement.setString(2, teamLead.getSurname());
            statement.setInt(3, teamLead.getTeamLeadAge());
            statement.setInt(4, idWHERE);

            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findById(idWHERE).orElseThrow(() -> new RuntimeException());
    }

}
//    Create DB "Course"
//        - student (name, email, phone)
//        - home_work (title, start_date, deadline_date, description)
//
//        realize Dao, CRUD for each model (don`t forget condition and exception)
//
//        add tests and logginig for CRUD operation
package homeWork1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {

//    CREATE
    public static void addToTable(Team team) {
        try (Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO " +
                    "team (name, team_size, class_room, team_lead_id) VALUES (?,?,?,?)");

            statement.setString(1, team.getName());
            statement.setInt(2, team.getTeamSize());
            statement.setInt(3, team.getClassRoom());
            statement.setInt(4, team.getTeamLeadId());

            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    READ
    public static List<Team> chekTableTeamLead() {

        List<Team> teams = new ArrayList();

        try (Connection connection = PostgresqlConnector.getConnection()) {

            Statement statement =
                    connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT  * FROM team");

            while (rs.next()) {
                Team team = new Team(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("team_size"),
                        rs.getInt("class_room"),
                        rs.getInt("team_lead_id"));

                System.out.println(team);
                teams.add(team);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }
}

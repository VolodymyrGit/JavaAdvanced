package homeWork1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamDao {

    //    CREATE
    public void addToTable(Team team) {

        String sqlQuery = "INSERT INTO team (name, team_size, class_room, team_lead_id) VALUES (?,?,?,?)";

        try (Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sqlQuery);

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


    //    READ ALL
    public List<Team> findAll() {

        String sqlQuery = "SELECT  * FROM team";

                List<Team> teams = new ArrayList<>();

        try (Connection connection = PostgresqlConnector.getConnection()) {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);

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


    //    READ BY ID
    public Optional<Team> findById(int id) {

        String sqlQuery = "SELECT * FROM team_lead WHERE id = ?";

        try (Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Team t = new Team(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("team_size"),
                        rs.getInt("class_room"),
                        rs.getInt("team_lead_id"));

                System.out.println(t);
                return Optional.ofNullable(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    //    UPDATE
    public Team update(int idWHERE, Team team) {

        String sqlQuery = "UPDATE team SET name = ?, team_size = ?, class_room = ?, team_lead_id = ? WHERE id = ?";

        try(Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, team.getName());
            statement.setInt(2, team.getTeamSize());
            statement.setInt(3, team.getClassRoom());
            statement.setInt(4, team.getTeamLeadId());
            statement.setInt(5, idWHERE);

            System.out.println(statement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findById(idWHERE).orElseThrow(() -> new RuntimeException());
    }


    //    DELETE
    public int delete(int idWHERE) {

        String sqlQuery = "DELETE FROM team WHERE id = ?";

        try(Connection connection = PostgresqlConnector.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, idWHERE);

            return statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

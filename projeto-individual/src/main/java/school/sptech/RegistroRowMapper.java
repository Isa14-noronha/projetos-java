package school.sptech;

import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroRowMapper implements RowMapper<Registro> {


    @Override
    public Registro mapRow(ResultSet resultSet, int i) throws SQLException {
        int idRegistro = resultSet.getInt("idRegistro");
        String nomeRegistro = resultSet.getString("nomeRegistro");
        double valorRegitro = resultSet.getDouble("valorRegitro");

        return new Registro(idRegistro, nomeRegistro, valorRegitro);
    }
}

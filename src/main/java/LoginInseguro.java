import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginInseguro {
    public static  boolean autenticar(Usuario usuario) throws Exception {
        Connection conexao = Conexao.conectar();
        String sql = "SELECT * FROM usuarios WHERE login = '"
                + usuario.getLogin() + "' AND senha = '" + usuario.getSenha() +"'";

        System.out.println(sql + " sql gerada");

        Statement smt = conexao.createStatement();
        ResultSet rs = smt.executeQuery(sql);

        return rs.next();
    }

    public static boolean autenticarPrepare(Usuario usuario) throws Exception {
        Connection conexao = Conexao.conectar();
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

        System.out.println(sql + " sql gerada");

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getLogin());
        statement.setString(2, usuario.getSenha());

        ResultSet rs = statement.executeQuery();
        return rs.next();

    }
}

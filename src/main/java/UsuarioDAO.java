import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public static boolean loginExiste(Usuario usuario) throws Exception {
        Connection conexao = Conexao.conectar();
        String sql = "SELECT * FROM usuarios WHERE login = ?";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getLogin());

        ResultSet rs = statement.executeQuery();

        return rs.next();
    }
    public static void cadastrar(Usuario usuario) throws Exception {

        boolean resutado = UsuarioDAO.loginExiste(usuario);

        if(resutado) {
            System.out.println("usuario ja existe");
        } else {
            Connection conexao = Conexao.conectar();
            String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
            System.out.println(sql + " sql gerada");

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());

            statement.executeUpdate();

            System.out.println("Usuario criado");
        }
    }
    public static void atualizar(Usuario usuario) throws Exception {

        boolean resutado = UsuarioDAO.loginExiste(usuario);

        if(resutado){
            Connection conexao = Conexao.conectar();
            String sql = "UPDATE usuarios SET senha = ? WHERE login = ?";

            System.out.println(sql + " sql gerada");

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getSenha());
            statement.setString(2, usuario.getLogin());

            statement.executeUpdate();

        } else{
            System.out.println("Usuario nao existe");
        }
    }
}

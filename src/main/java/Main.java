import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(login, senha);

        //boolean resultado = UsuarioDAO.loginExiste(usuario);

        //UsuarioDAO.cadastrar(usuario);

        UsuarioDAO.atualizar(usuario);

        //boolean resultado = LoginInseguro.autenticar(usuario);

        //boolean resultado = LoginInseguro.autenticarPrepare(usuario);

        //if (resultado) {
        //   System.out.println("Suscesso");
        //} else {
        //    System.out.println("falha");
        //}

        //' OR '1'='1

    }
}

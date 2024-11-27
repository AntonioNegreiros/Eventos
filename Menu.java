import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/eventojoinville";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - CADASTRAR EVENTO");
            System.out.println("2 - CADASTRAR LOCAL");
            System.out.println("3 - CADASTRAR ORGANIZADOR");
            System.out.println("4 - CADASTRAR PARTICIPANTE");
            System.out.println("5 - LISTAR EVENTO");
            System.out.println("6 - LISTAR LOCAL");
            System.out.println("7 - LISTAR ORGANIZADOR");
            System.out.println("8 - LISTAR PARTICIPANTE");
            System.out.println("9 - SAIR");

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opção Inválida, escolha uma opção conforme o menu.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement()) {
                        System.out.println("Digite o ID do Evento:");
                        int id = scanner.nextInt();
                        System.out.println("Digite o ID do Organizador:");
                        String idOrganizador = scanner.next();
                        System.out.println("Digite o ID do Local:");
                        String idLocal = scanner.next();
                        System.out.println("Digite a data (YYYY-MM-DD):");
                        String data = scanner.next();
                        System.out.println("Digite a descrição do evento:");
                        String descricao = scanner.next();
                        System.out.println("Informe os participantes:");
                        String participante = scanner.next();
                        System.out.println("Informe a quantidade de vagas:");

                        String vagas = scanner.next();

                        String sql = "INSERT INTO Evento (id, idOrganizador, idLocal, data, descricao, participantes, vagas) "
                                +
                                "VALUES ('" + id + "', '" + idOrganizador + "', '" + idLocal + "', '" + data + "', '"
                                + descricao + "', '" + participante + "', '" + vagas + "')";
                        stm.execute(sql);
                        System.out.println("Evento cadastrado com sucesso.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar evento: " + e.getMessage());
                    }
                    break;

                case 2:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement()) {
                        System.out.println("Digite a descrição do local:");
                        String Descricao = scanner.next();
                        System.out.println("Digite a quantidade de vagas:");
                        int Vagas = scanner.nextInt();
                        System.out.println("Digite o evento:");
                        int Eventos = scanner.nextInt();

                        String sql = "INSERT INTO Local (Descricao, Vagas,Eventos) VALUES ('" + Descricao + "', '" + Vagas + "','" + Eventos +"')";
                        stm.execute(sql);
                        System.out.println("Local cadastrado com sucesso.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar local: " + e.getMessage());
                    }
                    break;

                case 3:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement()) {
                        System.out.println("Digite o e-mail do organizador:");
                        String email = scanner.next();
                        System.out.println("Enviar Notificação (S/N):");
                        String notificacao = scanner.next();

                        String sql = "INSERT INTO Organizador (Email, NotificacaoO) VALUES ('" + email + "', '"
                                + notificacao + "')";
                        stm.execute(sql);
                        System.out.println("Organizador cadastrado com sucesso.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar organizador: " + e.getMessage());
                    }
                    break;

                case 4:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement()) {
                        System.out.println("Digite o telefone do participante:");
                        String telefone = scanner.next();

                        String sql = "INSERT INTO Participante (Telefone) VALUES ('" + telefone + "')";
                        stm.execute(sql);
                        System.out.println("Participante cadastrado com sucesso.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar participante: " + e.getMessage());
                    }
                    break;

                case 5:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT * FROM Evento")) {
                        System.out.println("Listagem dos eventos:");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    ", IdOrganizador: " + rs.getString("idOrganizador") +
                                    ", IdLocal: " + rs.getString("idLocal") +
                                    ", Data: " + rs.getString("data") +
                                    ", Descrição: " + rs.getString("descricao") +
                                    ", Participante: " + rs.getString("participante") +
                                    ", Vagas: " + rs.getInt("vagas"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao l1istar eventos: " + e.getMessage());
                    }
                    break;

                case 6:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT * FROM Local")) {
                        System.out.println("Listagem dos locais:");
                        while (rs.next()) {
                            System.out.println("Descrição: " + rs.getString("Descricao") +
                                    ", Vagas: " + rs.getInt("Vagas"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar locais: " + e.getMessage());
                    }
                    break;

                case 7:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT * FROM Organizador")) {
                        System.out.println("Listagem dos organizadores:");
                        while (rs.next()) {
                            System.out.println("Email: " + rs.getString("Email") +
                                    ", Notificação: " + rs.getString("NotificacaoO"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar organizadores: " + e.getMessage());
                    }
                    break;

                case 8:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("SELECT * FROM Participante")) {
                        System.out.println("Listagem dos participantes:");
                        while (rs.next()) {
                            System.out.println("Telefone: " + rs.getString("Telefone"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar participantes: " + e.getMessage());
                    }
                    break;

                case 9:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida, por favor tente novamente.");
            }
        } while (option != 9);

        scanner.close();
    }
}

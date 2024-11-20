import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/eventos";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - CADASTRAR EVENTO");
            System.out.println("2 - CADASTRAR CURSO");
            System.out.println("3 - CADASTRAR ALUNO");
            System.out.println("4 - LISTAR PROFESSORES");
            System.out.println("5 - LISTAR CURSOS");
            System.out.println("6 - LISTAR ALUNOS");
            System.out.println("7 - SAIR");

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
                        System.out.println("Digite data:");
                        String data = scanner.next();
                        System.out.println("Digite a descrição do evento:");
                        String descricao = scanner.next();
                        System.out.println("Informe os participantes:");
                        String participantes = scanner.next();
                        System.out.println("Informe a quantidade de vagas:");
                        String vagas = scanner.next();


                        String sql = "INSERT INTO Evento (id, idOrganizador, idLocal,data,descricao,participantes,vagas) VALUES ('" + id + "', '" + idOrganizador + "', '" + idLocal + "','" + data +"','" + descricao +"','" + participantes +"','" + vagas +"')";
                        stm.execute(sql);
                        System.out.println("Professor cadastrado com sucesso.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar professor: " + e.getMessage());
                    }
                    break;

                case 2:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                         Statement stm = con.createStatement()) {
                        System.out.println("Digite o ID do curso:");
                        int idCurso = scanner.nextInt();
                        System.out.println("Digite o nome do curso:");
                        String nomeCurso = scanner.next();
                        System.out.println("Digite a carga horária do curso:");
                        int cargaHoraria = scanner.nextInt();

                        String sql = "INSERT INTO curso (IdCurso, NomeCurso, CargaHoraria) VALUES ('" + idCurso + "', '" + nomeCurso + "', '" + cargaHoraria + "')";
                        stm.execute(sql);
                        System.out.println("Curso cadastrado com sucesso.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar curso: " + e.getMessage());
                    }
                    break;

                case 3:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                         Statement stm = con.createStatement()) {
                        System.out.println("Digite o ID do aluno:");
                        int idAluno = scanner.nextInt();
                        System.out.println("Digite o nome do aluno:");
                        String nomeAluno = scanner.next();
                        System.out.println("Digite a data de nascimento do aluno (AAAA-MM-DD):");
                        String dataNascimento = scanner.next();
                        System.out.println("Digite o CPF do aluno:");
                        String cpf = scanner.next();

                        String sql = "INSERT INTO aluno (IdAluno, NomeAluno, DataNascimento, cpf) VALUES ('" + idAluno + "', '" + nomeAluno + "', '" + dataNascimento + "', '" + cpf + "')";
                        stm.execute(sql);
                        System.out.println("Aluno cadastrado com sucesso.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
                    }
                    break;

                case 4:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                         Statement stm = con.createStatement();
                         ResultSet rs = stm.executeQuery("SELECT * FROM professor")) {
                        System.out.println("Listagem dos professores:");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("IdProfessor") +
                                               ", Nome: " + rs.getString("NomeProfessor") +
                                               ", Departamento: " + rs.getString("Departamento"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar professores: " + e.getMessage());
                    }
                    break;

                case 5:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                         Statement stm = con.createStatement();
                         ResultSet rs = stm.executeQuery("SELECT * FROM curso")) {
                        System.out.println("Listagem dos cursos:");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("IdCurso") +
                                               ", Nome: " + rs.getString("NomeCurso") +
                                               ", Carga Horária: " + rs.getInt("CargaHoraria"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar cursos: " + e.getMessage());
                    }
                    break;

                case 6:
                    try (Connection con = DriverManager.getConnection(url, user, password);
                         Statement stm = con.createStatement();
                         ResultSet rs = stm.executeQuery("SELECT * FROM aluno")) {
                        System.out.println("Listagem dos alunos:");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("IdAluno") +
                                               ", Nome: " + rs.getString("NomeAluno") +
                                               ", Data de Nascimento: " + rs.getString("DataNascimento") +
                                               ", CPF: " + rs.getString("cpf"));
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar alunos: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida, por favor tente novamente.");
            }
        } while (option != 7);
        
        scanner.close();
    }
}

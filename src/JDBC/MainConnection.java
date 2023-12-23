package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Departement;
import Classes.Enseignant;
import Main.Main;
import Services.EnseignantServices;

public class MainConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Dept_db";
        String user = "root";
        String pwd = "ohdlamya";

        try (Connection cx = DriverManager.getConnection(url, user, pwd)) {
            System.out.println("Good Connection");

            createTable(cx);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("-------------------------[ Départements ]---------------------------");

                System.out.println("1: Pour ajouter un département");
                System.out.println("2: Pour afficher les départements");
                System.out.println("3: Pour supprimer un département");
                System.out.println("0: Quitter");

                int option = Main.getIntInput("Veuillez sélectionner une option : ");

                switch (option) {
                    case 1:
                        addDepartement(cx, scanner);
                        break;
                    case 2:
                        getAllDepartements(cx);
                        break;
                    case 3:
                        deleteDepartement(scanner.nextInt(), cx);
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        return;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();
        }
    }


    public static void addDepartement(Connection cx, Scanner scanner) {
        Departement newDepartement = new Departement();
        System.out.print("Enter department name: ");
        newDepartement.setIntitule(scanner.nextLine());


        Enseignant newResponsable = new Enseignant();
        System.out.print("Enter responsable's id: ");
        newResponsable.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter responsable's name: ");
        newResponsable.setNom(scanner.nextLine());
        System.out.print("Enter responsable's prenom:");
        newResponsable.setPrenom(scanner.nextLine());
        System.out.print("Enter responsable's email:");
        newResponsable.setEmail(scanner.nextLine());
        System.out.print("Enter responsable's grade:");
        newResponsable.setGrade(scanner.nextLine());


        newDepartement.setResponsable(newResponsable);


        try {
            insertDepartement(newDepartement, cx);
            System.out.println("Department added: " + newDepartement);


            List<Departement> allDepartements = getAllDepartements(cx);


            Departement addedDepartment = allDepartements.stream()
                    .filter(d -> d.getIntitule().equals(newDepartement.getIntitule()))
                    .findFirst()
                    .orElse(null);


            if (addedDepartment != null) {
                System.out.println("Department found in the database: " + addedDepartment);
            } else {
                System.out.println("Department not found in the database.");
            }


            System.out.println("All Departments:");
            for (Departement departement : allDepartements) {
                System.out.println(departement.toString());
            }
        } catch (SQLException e) {
            System.out.println("Error adding department: " + e.getMessage());
        }
        try {
            List<Departement> allDepartements = getAllDepartements(cx);


            System.out.println("All Departments:");
            for (Departement departement : allDepartements) {
                System.out.println(departement.toString());
            }
        } catch (SQLException e) {
            System.out.println("Error fetching departments: " + e.getMessage());
        }
    }


    public static void insertDepartement(Departement departement, Connection cx) throws SQLException {
        String query = "INSERT INTO Departements (intitule, responsable) VALUES (?, ?)";
        try (PreparedStatement ps = cx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, departement.getIntitule());


            if (departement.getResponsable() != null) {
                ps.setString(2, departement.getResponsable().getNom());
            } else {

                ps.setNull(2, Types.VARCHAR);
            }

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                departement.setId(generatedKeys.getInt(1));
            }
        }
    }

    public static void deleteDepartement(int id, Connection cx) throws SQLException {
        String query = "DELETE FROM Departements WHERE id = ?";
        try (PreparedStatement ps = cx.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static List<Departement> getAllDepartements(Connection cx) throws SQLException {
        String query = "SELECT * FROM Departements";
        List<Departement> departements = new ArrayList<>();

        try (Statement st = cx.createStatement();
             ResultSet r = st.executeQuery(query)) {
            while (r.next()) {
                Departement departement = new Departement();
                departement.setId(r.getInt("id"));
                departement.setIntitule(r.getString("intitule"));


                int responsableId = 0;
                if (r.getObject("responsable") != null) {
                    responsableId = r.getInt("responsable");
                }

                departement.setResponsable(EnseignantServices.getEnsById(responsableId));
                departements.add(departement);
            }
        }

        return departements;
    }

    public static void createTable(Connection cx) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Departements (\n" +
                "id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "intitule NVARCHAR(100),\n" +
                "responsable VARCHAR(255),\n" +
                "FOREIGN KEY (responsable) REFERENCES Enseignants(nom)\n" +
                ")";
        try (Statement st = cx.createStatement()) {
            st.execute(query);
        }
    }
}

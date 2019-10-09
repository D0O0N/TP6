package testingwithhsqldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DAO {
	private final DataSource myDataSource;
	
	public DAO(DataSource dataSource) {
		myDataSource = dataSource;
	}

	/**
	 * Renvoie le nom d'un client à partir de son ID
	 * @param id la clé du client à chercher
	 * @return le nom du client (LastName) ou null si pas trouvé
	 * @throws SQLException 
	 */
	public String nameOfCustomer(int id) throws SQLException {
		String result = null;
		
		String sql = "SELECT LastName FROM Customer WHERE ID = ?";
		try (Connection myConnection = myDataSource.getConnection(); 
		     PreparedStatement statement = myConnection.prepareStatement(sql)) {
			statement.setInt(1, id); // On fixe le 1° paramètre de la requête
			try ( ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					// est-ce qu'il y a un résultat ? (pas besoin de "while", 
                                        // il y a au plus un enregistrement)
					// On récupère les champs de l'enregistrement courant
					result = resultSet.getString("LastName");
				}
			}
		}
		// dernière ligne : on renvoie le résultat
		return result;
	}
        /**
	 * @param id la clé du produit, name son nom, price son prix
	 * @throws SQLException 
	 */
        public void addProduct(Integer ID,String name, float price) throws SQLException{
            String sql = "INSERT INTO PRODUCT VALUES (?,?,?)";
            try (Connection myConnection = myDataSource.getConnection(); 
		     PreparedStatement statement = myConnection.prepareStatement(sql)) {
			statement.setInt(1, ID); // On fixe le 1° paramètre de la requête
                        statement.setString(2, name); // On fixe le 1° paramètre de la requête
                        statement.setFloat(3, price); // On fixe le 1° paramètre de la requête
                        statement.executeUpdate();
                        
		}
            
        }
        /**
	 * Renvoie le nom d'un client à partir de son ID
	 * @param id la clé du client à chercher
	 * @return le nom du client (LastName) ou null si pas trouvé
	 * @throws SQLException 
	 */
        //CREATE TABLE Product(ID INTEGER PRIMARY KEY, Name VARCHAR(30), Price DECIMAL(10,2));
	public ProductEntity getProduct(int id) throws SQLException {
		ProductEntity result;
		
		String sql = "SELECT * FROM PRODUCT WHERE ID = ?";
		try (Connection myConnection = myDataSource.getConnection(); 
		     PreparedStatement statement = myConnection.prepareStatement(sql)) {
			statement.setInt(1, id); // On fixe le 1° paramètre de la requête
			try ( ResultSet res = statement.executeQuery()) {
				res.next();
				result = new ProductEntity(res.getInt("ID"),res.getString("Name"), res.getFloat("Price")) ;
				
			}
		}
		// dernière ligne : on renvoie le résultat
		return result;
	}
	
}

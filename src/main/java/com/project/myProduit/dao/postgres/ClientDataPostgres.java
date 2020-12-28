package com.project.myProduit.dao.postgres;

import com.project.myProduit.dao.IClientData;
import com.project.myProduit.metierEntity.Client;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe permet la gestion des données via Postgres
 * Biensur il faudrais implementer la connection a la base de donner
 * Mais cette exemple reste volontairment primitif
 */
@Repository
public class ClientDataPostgres implements IClientData {

    private static List<Client> clientList = new ArrayList<>();

    private DataSource dataSource;

    public void create(Client client){

        // ici on peut creat l'acces au données avec jdbc
        clientList.add(client);
        System.out.println("Postgres : Ajout de la facture : " + client.getNumber()+
                "\nau client : " + client.getCustomerName() );
    }

    @Override
    public boolean insert(Client client) {
        return false;
    }

    @Override
    public boolean update(Client client) {
        return false;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }
}

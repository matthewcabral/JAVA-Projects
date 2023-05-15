/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class exceptionsController {
    private String msgReturn = "Mensagem: ";
    private String dbConnectionEx = "Erro: Não foi possível conectar com o Banco de Dados!";
    private String dbDisconnectEx = "Erro: Não foi possível fechar a conexão com o Banco de Dados!";
    private String dbODBCEx = "Erro: Não foi possível encontrar o Driver do ODBC!";

    public String getMsgReturn() { return msgReturn; }
    public String getDbConnectionEx() { return dbConnectionEx; }
    public String getDbDisconnectEx() { return dbDisconnectEx; }
    public String getDbODBCEx() { return dbODBCEx; }
}

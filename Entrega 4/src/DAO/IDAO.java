package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface padrão com assinatura dos metodos que cada DAO irá implementar
 *
 * @param <Object> Classe modelo
 */
public interface IDAO<Object> {
	

	 //  public static Connection conexao = null;
	  // public AcessoDados ad = new AcessoDados();
    /**
     * Recebe um objeto e atualiza no banco de dados com base no id
     *
     * @param obj a ser atualizado
     * @return true se atualizou com sucesso | false caso contrario
     */
    public boolean atualizar(Object obj);

    /**
     * Recebe um objeto e insere no banco de dados
     *
     * @param obj a ser inserido
     * @return true se inseriu com sucesso | false caso contrario
     */
    public boolean adicionar(Object obj);

    /**
     * Recebe um objeto e o exclui do banco de dados
     *
     * @param obj a ser excluido
     * @return true se excluiu com sucesso | false caso contrario
     */
    public boolean excluir(Object obj);

    /**
     * Realiza a consulta no banco de dados pelo id, monta o objeto e retorna
     *
     * @param id consultado
     * @return Object recuperado do banco | null se não existir
     */
    public Object selecionarPorID(int id);

    /**
     * Recupera todas as entidades da tabela do banco de dados
     *
     * @return ArrayList do tipo de objeto
     */
    public ArrayList<Object> selecionarTudo();

    /**
     * Método padrãp de conexão com o banco de dados
     *
     * @return a conexão estabelecida
     * @throws SQLException 
     */
   // public static void setConexao(Connection conexao);
    
    
    public Object montar(ResultSet rs) throws SQLException;

}

package br.com.cwi.crescer.aula2;

import dnl.utils.text.table.TextTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Máicon Loebens
 */
public class MeuSQLUtils {

    public static void main(String[] args) {
        //new MeuSQLUtils().executarComandosSql(new File("teste.sql"));
        //new MeuSQLUtils().importarCSV(new File("base.csv"));
        //new MeuSQLUtils().exibirDados("select * from pessoa");
    }

    public void executarComandosSql(File sqlFile) {
        boolean ehSQL = sqlFile.getName().toLowerCase().contains(".sql");
        if (ehSQL) {
            String[] comandos = lerComandosDoArquivo(sqlFile);
            if (comandos != null) {
                for (String comandoSQL : comandos) {
                    executeUpdate(comandoSQL);
                }
            }
        }
    }

    /*
       Utilizado biblioteca j-text-utils(https://code.google.com/archive/p/j-text-utils/) para exibir a tabela
     */
    public void exibirDados(String sql) {
        try (Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement();) {
                ResultSet resultado = statement.executeQuery(sql);

                ResultSetMetaData metaData = resultado.getMetaData();
                int columnCount = metaData.getColumnCount();
                String[] cabecalho = new String[columnCount];

                //armazena nome das colunas
                for (int i = 1; i <= columnCount; i++) {
                    cabecalho[i - 1] = metaData.getColumnName(i);
                }

                //armazena os valores em um lista
                List<List<String>> listaDeValores = new ArrayList<>();
                int contador = 0;
                while (resultado.next()) {
                    listaDeValores.add(new ArrayList<>());
                    listaDeValores.get(contador).add(Long.toString(resultado.getLong(1)));
                    listaDeValores.get(contador).add(resultado.getString(2));
                    contador++;
                }

                //transforma os valores em objeto para ser exibidos na tela
                Object[][] dados = new Object[listaDeValores.size()][cabecalho.length];
                for (int i = 0; i < listaDeValores.size(); i++) {
                        dados[i][0] = listaDeValores.get(i).get(0);
                        dados[i][1] = listaDeValores.get(i).get(1);
                }

                //exibe valores na tela
                TextTable tabelaDeResultados = new TextTable(cabecalho, dados);
                tabelaDeResultados.printTable();

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public void importarCSV(File csv) {
        Map<Integer, String> dados = lerArquivoCSV(csv);
        if (dados != null) {
            
            final String insert = "INSERT INTO PESSOA("
                    + "ID_PESSOA, NM_PESSOA ) "
                    + "VALUES (?, ?)";
            
            try (Connection connection = ConnectionUtils.getConnection()) {
                try (final PreparedStatement preparedStatement = connection.prepareStatement(insert);) {
                    for (Entry linha : dados.entrySet()) {
                        preparedStatement.setLong(1, (int)linha.getKey());
                        preparedStatement.setString(2,linha.getValue().toString());
                        preparedStatement.executeUpdate();
                    }
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        }
    }

    private void executeUpdate(String sql) {
        try (Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement();) {
                statement.executeUpdate(sql);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public String[] lerComandosDoArquivo(File sqlFile) {
        if (sqlFile != null) {
            try (
                    Reader reader = new FileReader(sqlFile);
                    BufferedReader bufferReader = new BufferedReader(reader);) {

                StringBuilder sb = new StringBuilder();
                //concatena todas as linhas do sql, os comandos podem estar em mais de uma linha
                bufferReader.lines().forEach(linha -> sb.append(linha));
                //quebra os comandos em linhas
                return sb.toString().split(";");

            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não econtrado.");
            } catch (IOException ex) {
                System.out.println("Não foi possível ler o arquivo.");
            }
        }
        return null;
    }

    private Map<Integer, String> lerArquivoCSV(File csv) {
        Map<Integer, String> dados = new HashMap<>();
        if (csv != null) {
            boolean ehCSV = csv.getName().contains(".csv");
            if (ehCSV) {
                try (
                        Reader reader = new FileReader(csv);
                        BufferedReader bufferReader = new BufferedReader(reader);) {

                    //pular linha de cabeçalho
                    bufferReader.readLine();
                    String linha;
                    while ((linha = bufferReader.readLine()) != null) {

                        String[] resultado = linha.split(";");
                        dados.put(Integer.parseInt(resultado[0]), resultado[1]);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Arquivo não econtrado.");
                } catch (IOException ex) {
                    System.out.println("Não foi possível ler o arquivo.");
                }
            }
        }
        return dados;
    }
}

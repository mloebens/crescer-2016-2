package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
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
        new MeuSQLUtils().exportarCSV();
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
        Map<String, String> dados = consultar(sql);

        for (Entry<String, String> entry : dados.entrySet()) {
            System.out.format("%15s%5s%15s\n", entry.getKey(), "|", entry.getValue());
            System.out.println("----------------------------------------------");
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
                        preparedStatement.setLong(1, (int) linha.getKey());
                        preparedStatement.setString(2, linha.getValue().toString());
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

    public void exportarCSV() {
        Map<String, String> dados = consultar("SELECT * FROM PESSOA");
        if (dados != null) {
            final String nomeArquivo = "exportacao.csv";
            
            try (
                    Writer writer = new FileWriter(nomeArquivo, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);) 
                {
                for (Entry entry : dados.entrySet()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(entry.getKey());
                    sb.append(";");
                    sb.append(entry.getValue());
                    bufferedWriter.append(sb.toString());
                    bufferedWriter.newLine();
                }
                new File(nomeArquivo).createNewFile();
                bufferedWriter.flush();
            } catch (IOException ex) {
                System.out.println("Não foi possível gravar o arquivo.");
            }
        } else {
            System.out.println("Nenhum registro encontrado");
        }
    }

    private Map<String, String> consultar(String sql) {
        Map<String, String> dados = new HashMap<>();
        try (Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement();) {
                ResultSet resultado = statement.executeQuery(sql);
                ResultSetMetaData metaData = resultado.getMetaData();

                //armazena nome das colunas
                dados.put(metaData.getColumnName(1), metaData.getColumnName(2));

                //armazena os valores em um lista
                while (resultado.next()) {
                    dados.put(Long.toString(resultado.getLong(1)), resultado.getString(2));
                }

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return dados;
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

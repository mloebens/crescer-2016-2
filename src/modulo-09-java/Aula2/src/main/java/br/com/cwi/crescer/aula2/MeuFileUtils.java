package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MeuFileUtils {
    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "mk":
                    new MeuFileUtils().mk(args[1]);
                    break;
                case "rm":
                    new MeuFileUtils().rm(args[1]);
                    break;
                case "ls":
                    new MeuFileUtils().ls(args[1]);
                    break;
                case "mv":
                    new MeuFileUtils().mv(args[1], args[2]);
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Parâmetros inválidos");
        }
    }

    // Vai criar o arquivo / diretório.
    private File mk(String nome) {
        if (nome == null) {
            System.out.println("Parâmetro não pode ser vazio");
        }

        if (ehArquivo(nome)) {
            try {
                File arquivo = new File(nome);
                    arquivo.createNewFile();
                    return arquivo;
            } catch (IOException e) {
                System.out.println("Não foi possível criar o arquivo");
            }
        } else {
            File diretorio = new File(nome);
            if (!diretorio.exists()) {
                diretorio.mkdir();
                return diretorio;
            } else {
                System.out.println("Já existe um diretório com este nome.");
            }
        }
        return null;
    }

    // Vai excluir o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    private void rm(String nome) {
        if (ehArquivo(nome)) {
            new File(nome).delete();
        } else {
            System.out.println("Arquivo inválido");
        }
    }

    // Vai mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos.
    private void ls(String nome) {
        if (ehArquivo(nome)) {
            File arquivo = new File(nome);
            if(arquivo.exists()){
                String caminhoAbsoluto = new File(nome).getAbsolutePath();
            System.out.format("%s\\%s\n", caminhoAbsoluto, nome);
            } else {
                System.out.println("Arquivo não existe");
            }
        } else {
            File[] listaDeArquivos = new File(nome).listFiles();
            for (File arquivo : listaDeArquivos) {
                System.out.println(arquivo.getName());
            }
        }
    }

    // Vai mover o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    private void mv(String nome, String novoNome) {
        if (ehArquivo(nome)) {
            Path origem = Paths.get(nome);
            Path destino = Paths.get(novoNome);

            try {
                Files.move(origem, destino);
            } catch (IOException ex) {
                System.out.println("Arquivo já existe no destino");
            }

        } else {
            System.out.println("Arquivo inválido");
        }
    }

    private boolean ehArquivo(String nome) {
        return nome.contains(".");
    }

}

import java.io.*;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FiltroPeliculas {

    public void filtrarPorAño(Integer año) {
        String inputFile = "peliculas.csv";
        String outputFile = "PeliculasPosterioresA"+año+".csv";

        List<String> peliculasFiltradas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length >= 4) {
                    try {
                        int añoPelicula = Integer.parseInt(partes[2].trim());
                        if (añoPelicula > año) {
                            peliculasFiltradas.add(linea);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("El año no es válido en la línea: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String pelicula : peliculasFiltradas) {
                bw.write(pelicula);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        FiltroPeliculas filtro = new FiltroPeliculas();
        filtro.filtrarPorAño(2000);
    }
}

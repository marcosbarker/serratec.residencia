package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeitorDeArquivo {
	File arquivo = new File("Relatorio.txt");
	FileWriter fw = new FileWriter(arquivo, true);
	BufferedWriter bw = new BufferedWriter(fw);

}
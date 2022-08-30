package application;

import entities.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Program {

    public static void main(String[] args) {
        /*
        // File e Scanner
        File file = new File("D:\\João Paulo\\Faculdade\\Curso Java - Udemy\\in.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        finally{
            if(sc != null){
                sc.close();
            }
        }
        
        // FileReader e BufferedReader
        String path = "D:\\João Paulo\\Faculdade\\Curso Java - Udemy\\in.txt";
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        finally{
            try{
                if (br != null){
                    br.close();
                }
                if (fr != null){
                    fr.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
        // Try with resources
        String path = "D:\\João Paulo\\Faculdade\\Curso Java - Udemy\\in.txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }    
        
        // FileWriter e BufferedWriter
        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
        String path = "D:\\João Paulo\\Faculdade\\Curso Java - Udemy\\out.txt";
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        // Manipulando pastas e arquivos com File
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS: ");
        for(File folder : folders){
            System.out.println(folder);
        }
        
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES: ");
        for(File file : files){
            System.out.println(file);
        }
        
        boolean sucess = new File(strPath + "\\pastaTeste").mkdir();
        System.out.println("Directory created sucessfully: " + sucess);
        
        sc.close();
        
        // Informações do caminho do arquivo
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a file path: ");
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        
        System.out.println("getName: " + path.getName());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getPath: " + path.getPath());
        
        
        sc.close();
        */
        // Exercicio proposto
        List<Product> list = new ArrayList<>();
        String strPath = "D:\\temp\\compras.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
            String line = br.readLine();
            while(line != null){
                String[] vect = line.split(Pattern.quote(","));
                list.add(new Product(vect[0], Double.parseDouble(vect[1]), Double.parseDouble(vect[2])));
                line = br.readLine();
            }
            new File("D:\\temp\\out").mkdir();
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\temp\\out\\summary.csv"));
            for(Product p : list){
                String text = p.getName() + "," + String.format("%.2f", p.totalPrice());
                bw.write(text);
                bw.newLine();
            }
            
            bw.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
}

import java.util.ArrayList;
import edu.princeton.cs.algs4.StopwatchCPU;
import edu.princeton.cs.algs4.Out;

public class Experimento {
   
    public static void main(String[] args) {
         int[] n = {1024, 2048, 4096, 8192, 16384, 32768}; 
        
       for (int j = 0; j < n.length; j++) {
            
            System.out.println(">>> Iniciando mediciones para N = " + n[j] + " <<<");
            Out cuchurrumin = new Out("Sort_" + n[j] + ".csv");  
            cuchurrumin.println("sep=;"); 
            cuchurrumin.println( "instancia;Insertion;Selection;Merge;Quick");
            for (int i = 0; i < 100; i++) {
                int vueltaActual = i + 1;
                
                ArrayList<Song> originalSorts = DataGenerator.generateDataBase(n[j], n[j] + i);
                
                ArrayList<Song> copiaInsertion = new ArrayList<>(originalSorts); 
                // b) Nuevo objeto a partir de la copia
                SongDataBase lInsertion = new SongDataBase(copiaInsertion);
                // c) Medir el tiempo
                StopwatchCPU relojInsertion = new StopwatchCPU(); 
                lInsertion.ordenarPorAlgoritmo("insertionSort", "plays");
                double tInsertion = relojInsertion.elapsedTime();

                // ====================================================================
                // 2. PARA ALGORITMO: SELECTION SORT
                // ====================================================================
                // a) Copia independiente
                ArrayList<Song> copiaSelection = new ArrayList<>(originalSorts); 
                // b) Nuevo objeto a partir de la copia
                SongDataBase lSelection = new SongDataBase(copiaSelection);
                // c) Medir el tiempo
                StopwatchCPU relojSelection = new StopwatchCPU();
                lSelection.ordenarPorAlgoritmo("selectionSort", "plays"); 
                double tSelection = relojSelection.elapsedTime();
               
                // ====================================================================
                // 3. PARA ALGORITMO: MERGE SORT
                // ====================================================================
                // a) Copia independiente
                ArrayList<Song> copiaMerge = new ArrayList<>(originalSorts); 
                // b) Nuevo objeto a partir de la copia
                SongDataBase lMerge = new SongDataBase(copiaMerge);
                // c) Medir el tiempo
                StopwatchCPU relojMerge = new StopwatchCPU();
                lMerge.ordenarPorAlgoritmo("mergeSort", "plays"); 
                double tMerge = relojMerge.elapsedTime();

                // ====================================================================
                // 4. PARA ALGORITMO: QUICK SORT
                // ====================================================================
                // a) Copia independiente
                ArrayList<Song> copiaQuick = new ArrayList<>(originalSorts); 
                // b) Nuevo objeto a partir de la copia
                SongDataBase lQuick = new SongDataBase(copiaQuick);
                // c) Medir el tiempo
                StopwatchCPU relojQuick = new StopwatchCPU();
                lQuick.ordenarPorAlgoritmo("quickSort", "plays"); 
                double tQuick = relojQuick.elapsedTime();

                // Guardamos los tiempos de esta vuelta en el archivo del N actual
                cuchurrumin.println(vueltaActual + ";" + tInsertion + ";" + tSelection + ";" + tMerge + ";" + tQuick);
            }
            
            // ====================================================================
            // CIERRE DEL ARCHIVO: Nos aseguramos de guardar los datos de este N
            // ====================================================================
            cuchurrumin.close(); 
            System.out.println("-> Archivo '" + n[j] + ".csv' guardado con sus 100 vueltas.");
        }
        
        System.out.println("\n¡Todo listo! Se han generado los 6 archivos CSV independientes.");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Busquedas");

          

   for (int b = 0; b < n.length; b++) {
    System.out.println(">>> Iniciando mediciones para N = " + n[b] + " <<<");
    Out cuchurruminB = new Out("Search_" + n[b] + ".csv");
    cuchurruminB.println("sep=;"); 
    cuchurruminB.println("instancia;artista;t_lineal;t_binaria");
    
    for (int i = 0; i < 100; i++) {
        ArrayList<Song> originalBusquedas = DataGenerator.generateDataBase(n[b], n[b] + i);
        int[] indiceAr = {0, n[b] / 200, n[b] / 100, (3 * n[b]) / 200, (n[b] / 50) - 1};
        
        // Creamos acumuladores de tiempo al inicio de la instancia
        double sumaLineal = 0;
        double sumaBinaria = 0;
        
        // -----------------------------------------------------------------
        // BUCLE K: Recorre los 5 artistas (NO imprime nada en el CSV aquí adentro)
        // -----------------------------------------------------------------
        for (int k = 0; k < 5; k++) {
            String artistaBuscado = "Artista_" + indiceAr[k]; 
            
            // --- Medición Secuencial ---
            ArrayList<Song> copiaBusqueda = new ArrayList<>(originalBusquedas); 
            SongDataBase BusquedaSecuencial = new SongDataBase(copiaBusqueda);

            
            StopwatchCPU relojitolindo = new StopwatchCPU(); 
            for (int l = 0; l < 1000; l++) {
                BusquedaSecuencial.sequentialSearch(artistaBuscado);
            }   
            sumaLineal += relojitolindo.elapsedTime(); // Sumamos el tiempo de este artista
            
            // --- Medición Binaria ---
            ArrayList<Song> copiaBinaria = new ArrayList<>(originalBusquedas);
            SongDataBase Binaria = new SongDataBase(copiaBinaria);
            Binaria.ordenarPorAlgoritmo("insertionSort", "artist");

            StopwatchCPU relojBinario = new StopwatchCPU();
            for (int r = 0; r < 1000; r++) {
                Binaria.binarySearch(artistaBuscado);
            }
             double t_lineal_prom = sumaLineal / 5.0;
        double t_binaria_prom = sumaBinaria / 5.0;
            sumaBinaria += relojBinario.elapsedTime(); // Sumamos el tiempo de este artista
              cuchurruminB.println((i + 1) + ";" + artistaBuscado + ";" + t_lineal_prom + ";" + t_binaria_prom);
        } 
        // -----------------------------------------------------------------
        // ¡AQUÍ TERMINÓ EL BUCLE DE LOS 5 ARTISTAS!
        // -----------------------------------------------------------------

        // Ahora sí, calculamos los double finales después de recorrer los 5
       
        
        // Imprimimos una única línea en el CSV para esta instancia
      
    }
    
    cuchurruminB.close();
    System.out.println("-> Archivo 'Search_" + n[b] + ".csv' guardado con éxito.");
}
   }
}

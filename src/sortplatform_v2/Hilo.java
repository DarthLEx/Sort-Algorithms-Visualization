package sortplatform_v2;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread {
    
    String dec;
    public Hilo(String dec){
        
        this.dec = dec;
        
    }
    
    
    
    @Override
    public void run(){
        
        if(dec.equals("Bubble")){
            BubbleSort(SortPlatform_V2.SS.Values, SortPlatform_V2.SS.p);
            System.gc();
            
        }
        if(dec.equals("selection")){
            selectionSort(SortPlatform_V2.SS.Values, SortPlatform_V2.SS.p);
            System.gc();
        }
        if(dec.equals("insertion")){
            InsertionSort(SortPlatform_V2.SS.Values, SortPlatform_V2.SS.p);
            System.gc();
        }
        if(dec.equals("shell")){
            
            shell(SortPlatform_V2.SS.Values, SortPlatform_V2.SS.p);
            System.gc();
            
        }
        
    }
    
    
     public void BubbleSort(int Array[], Panel p){
        int Temp;
        for(int i=0; i<Array.length; i++){
            
            for(int j=0; j<Array.length-1; j++){
                if(Array[j]>Array[j+1]){
                    
                    Temp = Array[j];
                    AddArrayAccess();
                    Array[j] = Array[j+1];
                    AddArrayAccess();
                    Array[j+1] = Temp;
                    AddArrayAccess();
                    
                }
                p.repaint();
                try {
                    sleep(SortPlatform_V2.SS.Timer.getValue());
                } catch (InterruptedException ex) {
                    Logger.getLogger(frm_SortSelection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        
    }
     
     
      public static void selectionSort(int[] arr, Panel p){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            AddArrayAccess();
            arr[i] = smallerNumber;  
            AddArrayAccess();
            p.repaint();
            try{
                sleep(SortPlatform_V2.SS.Timer.getValue());
            }catch(Exception e){
                System.out.println(e);
            }
            
        }  
    }
      
      public void InsertionSort(int[] Arr, Panel p){
         
        int temp;
        for (int i = 1; i < Arr.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(Arr[j] < Arr[j-1]){
                    temp = Arr[j];
                    AddArrayAccess();
                    Arr[j] = Arr[j-1];
                    AddArrayAccess();
                    Arr[j-1] = temp;
                    AddArrayAccess();
                }
            }
            p.repaint();
            try {
                sleep(SortPlatform_V2.SS.Timer.getValue());
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
      
   public void shell(int A[], Panel p){
       int salto, aux, i;
       boolean cambios;
       for(salto=A.length/2; salto!=0; salto/=2){
               cambios=true;
               while(cambios){ // Mientras se intercambie algún elemento
                           cambios=false;
                           for(i=salto; i< A.length; i++) // se da una pasada
                                   if(A[i-salto]>A[i]){ // y si están desordenados
                                         aux=A[i]; // se reordenan
                                         A[i]=A[i-salto];
                                         A[i-salto]=aux;
                                         cambios=true; // y se marca como cambio.
                                   }
                           try{
                                p.repaint();
                              sleep(SortPlatform_V2.SS.Timer.getValue());
                           }catch(Exception e){}
                             
                            }
                }
}
      
      
    public static void  AddArrayAccess(){
        
        SortPlatform_V2.SS.Acces.setText(String.valueOf(Integer.parseInt(SortPlatform_V2.SS.Acces.getText())+1));
        
    }
}

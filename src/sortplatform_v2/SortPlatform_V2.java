package sortplatform_v2;

public class SortPlatform_V2 {

    static frm_SortSelection SS;
    
    public static void main(String[] args) {
       initComponents();
       //SS.BubbleSort();
    }
    
    
    public static void initComponents(){
         SS = new frm_SortSelection();
         SS.setVisible(true);
        
    }
    
}

package sortplatform_v2;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
public class Panel extends JPanel{
    
    int FWidth;
    int FHeight;
    int Values[];
    Color LineColor;
    
    public Panel(int w, int h){
        
        setBackground(new Color(79, 76, 76));
        FWidth = w;
        FHeight = h;
        LineColor = new Color(61, 59, 59);
        Values = new int[FWidth];
        initArray();
    }
    
    public void initArray(){
        
        for(int i = 0; i<Values.length; i++){
            
            Values[i] = (int)(Math.random()*FHeight+1);
            
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.white);
        for(int i = 0; i<Values.length; i++){
            
            g.drawLine(i, FHeight, i, FHeight-Values[i]);
            
        }
        
    }
    
    
}

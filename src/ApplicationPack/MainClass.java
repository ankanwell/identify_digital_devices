//identification of digital devices
package ApplicationPack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class SubPanel extends JPanel implements ActionListener //Orange Panel
{
    private JLabel      lblKboard,lblMouse,lblMonitor,lblMboard,lblCD;
    private JCheckBox   chbxKboard,chbxMouse,chbxMonitor,chbxMboard,chbxCD;
    private ImageIcon   imgKboard,imgMouse,imgMonitor,imgMboard,imgCD;
    
    private JLabel makeLabel(int x,int y,int w,int h)
    {
        JLabel temp = new JLabel();
        temp.setBounds(x,y,w,h);
        temp.setOpaque(true);
        temp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        super.add(temp);
        return temp;
    }
    private JCheckBox makeCheckBox(String cap,int x,int y,int w,int h)
    {
        JCheckBox temp = new JCheckBox(cap);
        temp.setFont(new Font("Courier New", 1, 18));
        temp.setBounds(x,y,w,h);
        temp.setOpaque(false);
        temp.addActionListener(this);
        super.add(temp);
        return temp;
    }
    private ImageIcon makeImageIcon(String picfile)
    {
        ImageIcon temp = null;
        try
        {
            File imgpath = new File(picfile);
            BufferedImage bimg = ImageIO.read(imgpath);
            Image scaled = bimg.getScaledInstance(240,180,Image.SCALE_SMOOTH);
            temp = new ImageIcon(scaled);
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return temp;
    }
    public SubPanel()
    {
        try
        {
            imgKboard   = makeImageIcon("d0.jpg");
            imgMouse    = makeImageIcon("d1.jpg");
            imgMonitor  = makeImageIcon("d2.jpg");
            imgMboard   = makeImageIcon("d3.jpg");
            imgCD       = makeImageIcon("d4.jpg");
            
            chbxKboard  = makeCheckBox("Keyboard",       20, 30,225,30);
            lblKboard   = makeLabel(                    255, 30,225,70);
            
            chbxMouse   = makeCheckBox("Mouse",          20,110,225,30);
            lblMouse    = makeLabel(                    255,110,225,70);
            
            chbxMonitor = makeCheckBox("Monitor",        20,190,225,30);
            lblMonitor  = makeLabel(                    255,190,225,70);
            
            chbxMboard  = makeCheckBox("Mother Board",   20,270,225,30);
            lblMboard   = makeLabel(                    255,270,225,70);
            
            chbxCD      = makeCheckBox("Compact Disc",   20,350,225,30);
            lblCD       = makeLabel(                    255,350,225,70);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object ob = e.getSource();
        if(ob == chbxKboard)
        {
            if(chbxKboard.isSelected())
                lblKboard.setIcon(imgKboard);
            else
                lblKboard.setIcon(null);
        }
        else if(ob == chbxMouse)
        {
            if(chbxMouse.isSelected())
                lblMouse.setIcon(imgMouse);
            else
                lblMouse.setIcon(null);
        }
        else if(ob == chbxMonitor)
        {
            if(chbxMonitor.isSelected())
                lblMonitor.setIcon(imgMonitor);
            else
                lblMonitor.setIcon(null);
        }
        else if(ob == chbxMboard)
        {
            if(chbxMboard.isSelected())
                lblMboard.setIcon(imgMboard);
            else
                lblMboard.setIcon(null);
        }
        else if(ob == chbxCD)
        {
            if(chbxCD.isSelected())
                lblCD.setIcon(imgCD);
            else
                lblCD.setIcon(null);
        }
    }
}
class MainPanel extends JPanel  //Yellow Panel
{
    private JLabel   lblCaption;
    private SubPanel subpanel;
    private JLabel makeLabel(String cap)
    {
        Border brd = BorderFactory.createLineBorder(Color.BLUE, 3);
        JLabel temp = new JLabel(cap);
        temp.setBounds(50,10,500,45);
        temp.setFont(new Font("Verdana", 1, 25));
        temp.setHorizontalAlignment(JLabel.CENTER);
        temp.setOpaque(true);
        temp.setBackground(Color.RED);
        temp.setForeground(Color.WHITE);
        temp.setBorder(brd);
        super.add(temp);
        return temp;
    }
    public MainPanel()
    {
        Border br1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border br2 = BorderFactory.createLineBorder(Color.BLUE, 3);
        Border br3 = BorderFactory.createTitledBorder(br2, "Know Digital Devices", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Georgia", 1, 14));
        Border br4 = BorderFactory.createCompoundBorder(br1, br3);
        
        lblCaption = makeLabel("Identification of Digital Devices");
        subpanel = new SubPanel();
        subpanel.setBackground(Color.ORANGE);
        subpanel.setLayout(new BorderLayout());
        subpanel.setBorder(br4);
        subpanel.setBounds(50,70,500,440);
        super.add(subpanel);
    }
}
class MainFrame extends JFrame
{
    private MainPanel mainpanel;
    public MainFrame()
    {
        mainpanel = new MainPanel();
        mainpanel.setBackground(Color.YELLOW);
        mainpanel.setLayout(new BorderLayout());
        super.add(mainpanel);
    }
}
public class MainClass
{
    public static void main(String[] args)
    {
        JFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,550);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Digital Devices");
        frame.setResizable(false);
    }
}
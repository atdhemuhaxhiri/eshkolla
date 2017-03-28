package gui;

import entities.InstitutionType;
import services.InstitutionTypeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hotelkey on 3/9/17.
 */
public class InstitutionTypeGui extends JFrame{
    private JPanel panelMain;
    private JTextField txtName;
    private JTextArea taDescription;
    private JButton saveButton;
    private JButton deleteButton;
    private JTable tblInstitytionTypes;

    public InstitutionTypeGui(){
        loadAllInstitutionTypes2();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Save clicked");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Delete clicked");
            }
        });

        pack();
        setSize(400,400);
        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
//        List<InstitutionType> institutionTypeList = InstitutionTypeService.getAll();
//        String col[] = {"Id", "Name","Description"};
//
//        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
//
//        // The 0 argument is number rows.
//
//        for (InstitutionType institutionType : institutionTypeList){
//            Object[] data = {institutionType.getId(), institutionType.getName(), institutionType.getDepartment()};
//            tableModel.addRow(data);
//        }
//
////        tblInstitytionTypes = new JTable(tableModel);
//
//        tblInstitytionTypes.setModel(tableModel);
    }

    private void loadAllInstitutionTypes() {
        this.tblInstitytionTypes.removeAll();
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        dtm.addColumn("Id");
        dtm.addColumn("Name");
        dtm.addColumn("Department");
        this.tblInstitytionTypes.setModel(dtm);
        this.tblInstitytionTypes.setTableHeader(new JTableHeader());

        List<InstitutionType> institutionTypeList = InstitutionTypeService.getAll();
        for (Iterator<InstitutionType> it = institutionTypeList.iterator(); it.hasNext();) {
            InstitutionType institutionType = it.next();
            dtm.addRow(new Object[]{""
                    + institutionType.getId(),
                    institutionType.getName(),
                    institutionType.getDepartment()
            });
        }
    }

    private void loadAllInstitutionTypes2() {
        this.tblInstitytionTypes.removeAll();

        String[] cols = new String[]{"Id","Name","Department"};

//        this.tblInstitytionTypes.setModel(dtm);
//        this.tblInstitytionTypes.setTableHeader(new JTableHeader());


        List<InstitutionType> institutionTypeList = InstitutionTypeService.getAll();

        Object[][] data = new Object[institutionTypeList.size()][3];

        for (int j = 0; j<institutionTypeList.size(); j++)
        {
            InstitutionType myTeach = institutionTypeList.get(j);
            data[j][0] = myTeach.getId();
            data[j][1] = myTeach.getName();
            data[j][2] = myTeach.getDepartment();
        }

        tblInstitytionTypes = new JTable (data, cols);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new InstitutionTypeGui().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

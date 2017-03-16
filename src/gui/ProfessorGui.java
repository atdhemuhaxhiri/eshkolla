package gui;

import entities.Professor;
import entities.ProfessorType;
import services.ProfessorService;
import services.ProfessorTypeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hotelkey on 3/16/17.
 */
public class ProfessorGui extends JFrame{
    private JPanel pnlMain;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtBirthday;
    private JRadioButton rbMail;
    private JRadioButton rbFemail;
    private JTextField txtAddress;
    private JTextField txtEmail;
    private JComboBox cbType;
    private JTextField txtMobile;
    private JButton btnSave;
    private JButton btnDelete;
    private JTable tblProfessors;
    private JScrollPane jsProfessors;

    public ProfessorGui(){
        loadTypes();
        loadAll();

        pack();
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        setVisible(true);
    }

    private void loadTypes(){
        List<ProfessorType> professorTypeList = ProfessorTypeService.getAll();

        cbType.removeAllItems();;

        for (ProfessorType professorType : professorTypeList) {
            cbType.addItem(professorType.getType());
        }
    }

    private void loadAll(){
        this.tblProfessors.removeAll();
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        dtm.addColumn("Id");
        dtm.addColumn("Year");
        dtm.addColumn("Active");
        this.tblProfessors.setModel(dtm);

        List<Professor> professorTypes = ProfessorService.getAll();
        for (Iterator<Professor> it = professorTypes.iterator(); it.hasNext();) {
            Professor professorType = it.next();
            dtm.addRow(new Object[]{""
                    + professorType.getId(),
                    professorType.getYear(),
                    professorType.isActive()
            });
        }
    }
}

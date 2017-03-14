package gui;

import com.sun.codemodel.internal.JOp;
import entities.ProfessorType;
import services.ProfessorTypeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by hotelkey on 3/14/17.
 */
public class ProfessorTypeGui extends JFrame{
    private JTextField txtType;
    private JTextArea taDescription;
    private JButton saveButton;
    private JButton deleteButton;
    private JTable tblProfessorTypes;
    private JPanel pnlMain;

    public ProfessorTypeGui(){
        loadAll();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfessorType professorType = new ProfessorType();
                professorType.setId(UUID.randomUUID().toString());
                professorType.setType(txtType.getText());
                professorType.setDescription(taDescription.getText());

                if (ProfessorTypeService.insert(professorType) > 0){
                    JOptionPane.showMessageDialog(null,
                            "Professor type inserted successfully.");
                    loadAll();
                }else {
                    JOptionPane.showMessageDialog(null,
                            "Professor type failed to insert.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Delete\nType: " + txtType.getText()
                        + "\nDescription: " + taDescription.getText());
            }
        });

        pack();
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        setVisible(true);
    }

    private void loadAll(){
        this.tblProfessorTypes.removeAll();
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        dtm.addColumn("Id");
        dtm.addColumn("Type");
        dtm.addColumn("Description");
        this.tblProfessorTypes.setModel(dtm);

        List<ProfessorType> professorTypes = ProfessorTypeService.getAll();
        for (Iterator<ProfessorType> it = professorTypes.iterator(); it.hasNext();) {
            ProfessorType professorType = it.next();
            dtm.addRow(new Object[]{""
                    + professorType.getId(),
                    professorType.getType(),
                    professorType.getDescription()
            });
        }
    }
}

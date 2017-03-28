package gui;

//import com.sun.codemodel.internal.JOp;
import entities.ProfessorType;
import services.ProfessorTypeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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
    private JScrollPane spTbl;

    private ProfessorType selectedProfessorType;

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
                    loadAll();
                    txtType.setText("");
                    taDescription.setText("");
                    JOptionPane.showMessageDialog(null,
                            "Professor type inserted successfully.");

                }else {
                    JOptionPane.showMessageDialog(null,
                            "Professor type failed to insert.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (null != selectedProfessorType && null != selectedProfessorType.getId() && !selectedProfessorType.getId().isEmpty()){
                    int answer = JOptionPane.showConfirmDialog(null, "A jeni i sigurt?", "aaa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (answer != JOptionPane.YES_OPTION){
                        return;
                    }

                    if (ProfessorTypeService.delete(selectedProfessorType.getId()) > 0){
                        selectedProfessorType = null;
                        loadAll();
                        JOptionPane.showMessageDialog(null, "Deleted successfully.");
                    }else {
                        JOptionPane.showMessageDialog(null, "Failed to delete.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Please select type to delete.");
                }
            }
        });

        tblProfessorTypes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfessorTypeMouseClicked(evt);
            }
        });
        spTbl.setViewportView(tblProfessorTypes);

        pack();
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        setVisible(true);
    }

    private void tblProfessorTypeMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            tblProfessorTypes.getSelectedRow();
            selectedProfessorType = new ProfessorType();
            selectedProfessorType.setId(tblProfessorTypes.getModel().getValueAt(tblProfessorTypes.getSelectedRow(), 0).toString());
            selectedProfessorType.setType(tblProfessorTypes.getModel().getValueAt(tblProfessorTypes.getSelectedRow(), 1).toString());
            selectedProfessorType.setDescription(tblProfessorTypes.getModel().getValueAt(tblProfessorTypes.getSelectedRow(), 2).toString());

            txtType.setText(selectedProfessorType.getType());
            taDescription.setText(selectedProfessorType.getDescription());
        }
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

package core.gui;

import java.awt.Dimension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author astiservices
 */
public class EditionBar extends javax.swing.JPanel {
    
    private ICrudFrame crudFrame;
    private EditionBar.State state;
    
    private final Logger LOGGER = LogManager.getLogger("appLogger");

    public EditionBar() {
        initComponents();
        Dimension preferredButtonSize = new Dimension(32, 32);
        btnCancel.setPreferredSize(preferredButtonSize);
        btnCreate.setPreferredSize(preferredButtonSize);
        btnDelete.setPreferredSize(preferredButtonSize);
        btnEdit.setPreferredSize(preferredButtonSize);
        btnSave.setPreferredSize(preferredButtonSize);
        btnSearch.setPreferredSize(preferredButtonSize);
    }
    
    public void activateState(EditionBar.State state) {
        btnSearch.setEnabled(false);
        btnCreate.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(false);
        
        btnSearch.setEnabled(true);
        btnCreate.setEnabled(true);
        btnEdit.setEnabled(true);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
        btnCancel.setEnabled(true);
        switch (state) {
            case EDITING:
                btnSearch.setEnabled(false);
                btnCreate.setEnabled(false);
                btnEdit.setEnabled(false);
                break;
            case ROW_SELECTED:
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
                break;
            case STAND_BY:
                btnDelete.setEnabled(false);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
        }
        this.state = state;
    }
    
    public EditionBar.State getState() {
        return state;
    }
    
    public void setCrudFrame(ICrudFrame frame) {
        crudFrame = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(260, 46));
        setMinimumSize(new java.awt.Dimension(260, 46));
        setPreferredSize(new java.awt.Dimension(260, 46));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch);

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new.png"))); // NOI18N
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.png"))); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        add(btnCancel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            crudFrame.findRecords();
        } catch(Exception ex) {
            LOGGER.error(ex);
            MessageDialog.showMessage(null, MessageDialog.Type.ERROR, "Error al realizar la búsqueda", ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            crudFrame.prepareEdition(null);
        } catch(Exception ex) {
            LOGGER.error(ex);
            MessageDialog.showMessage(null, MessageDialog.Type.ERROR, "Error al preparar un nuevo registro", ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            Object data = crudFrame.getDataForProcessing();
            crudFrame.prepareEdition(data);
        } catch(Exception ex) {
            LOGGER.error(ex);
            MessageDialog.showMessage(null, MessageDialog.Type.ERROR, "Error al preparar la edición", ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            Object data = crudFrame.getDataForProcessing();
            crudFrame.saveChanges(data);
        } catch(Exception ex) {
            LOGGER.error(ex);
            MessageDialog.showMessage(null, MessageDialog.Type.ERROR, "Error al guardar los cambios", ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            Object data = crudFrame.getDataForProcessing();
            crudFrame.delete(data);
        } catch(Exception ex) {
            LOGGER.error(ex);
            MessageDialog.showMessage(null, MessageDialog.Type.ERROR, "Error al eliminar el registro", ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
            crudFrame.cancelAction();
        } catch(Exception ex) {
            LOGGER.error(ex);
            MessageDialog.showMessage(null, MessageDialog.Type.ERROR, "Error al cancelar la acción", ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    // End of variables declaration//GEN-END:variables

    public static enum State {
        STAND_BY,
        EDITING,
        ROW_SELECTED
    }

}
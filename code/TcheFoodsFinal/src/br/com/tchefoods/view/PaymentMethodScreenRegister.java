package br.com.tchefoods.view;

import br.com.tchefoods.dao.PaymenthMethodDAO;
import br.com.tchefoods.model.PaymentMethodModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PaymentMethodScreenRegister {
    private JPanel PanelPaymentMethod;
    private JButton JBSave;
    private JTextField JTFPaymentMethod;
    private JLabel JLPaymentMethod;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PaymentMethodScreenRegister");
        frame.setContentPane(new PaymentMethodScreenRegister().PanelPaymentMethod);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public PaymentMethodScreenRegister(){


        JBSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (JTFPaymentMethod.getText().isEmpty()){
                    JOptionPane.showMessageDialog(PanelPaymentMethod, "Please enter the payment method description");
                    return;
                }
                PaymentMethodModel methodModel = new PaymentMethodModel();
                PaymenthMethodDAO methodDAO = new PaymenthMethodDAO();

                methodModel.setDesc(JTFPaymentMethod.getText());
                try {
                    methodDAO.save(methodModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class MyGUIForm {
    private JPanel mainPanel;
    private JTextArea surname;
    private JButton collapseButton;
    private JTextArea name;
    private JTextArea lastname;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel lastnameLabel;
    private JButton clearButton;
    private JLabel text;
    private JLabel text1;
    private JLabel text2;

    public JPanel getMyGUIForm() {
        return mainPanel;
    }

    public MyGUIForm() {
        clearButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(name.getText(), "")) {
                    surname.setText("");
                    name.setText("");
                    lastname.setText("");

                    if (Objects.equals(name.getText(), "") || Objects.equals(surname.getText(), "") || Objects.equals(lastname.getText(), "")) {
                        text1.setText("Фамилия очищена");
                        text.setText("Имя очищено");
                        text2.setText("Отчество очищено");
                    }
                }

            }
        });

        collapseButton.addActionListener(actionEvent -> {
            if (collapseButton.getText().equals("Collapse")) {
                if (name.getText().isEmpty() || surname.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Заполните имя и фамилию.");
                } else {
                    name.setVisible(false);
                    nameLabel.setVisible(false);
                    surname.setVisible(false);
                    surnameLabel.setVisible(false);
                    lastname.setSize(150, 50);
                    lastname.setText(collapseText());
                    lastnameLabel.setText("Фамилия " +
                            "Имя " +
                            "Отчество");
                    collapseButton.setText("Expand");
                }
                text.setText("");
                text1.setText("");
                text2.setText("");
            } else if (collapseButton.getText().equals("Expand")) {
                var fio = lastname.getText().trim().split(" ");
                if (fio.length > 3) {
                    text.setText("");
                    text1.setText("");
                    text2.setText("");
                    JOptionPane.showMessageDialog(mainPanel, "Не более трёх слов (Фамилия и (или) Имя и (или) Отчество).");

                } else {
                    if (fio.length < 2) {
                        text.setText("");
                        text1.setText("");
                        text2.setText("");
                        JOptionPane.showMessageDialog(mainPanel, "Не менее двух слов (Фамилия и (или) Имя и (или) Отчество). Каждое слово с новой строки.");

                    } else {
                        int n = fio.length - 1;
                        lastname.setSize(100, -1);
                        surname.setText(fio[0]);
                        name.setText(fio[n]);
                        lastname.setText("");
                        if (fio.length == 3) {
                            lastname.setText(fio[2]);
                        }
                        name.setVisible(true);
                        nameLabel.setVisible(true);
                        surname.setVisible(true);
                        surnameLabel.setVisible(true);
                        surnameLabel.setText("Фамилия");
                        nameLabel.setText("Имя");
                        lastnameLabel.setText("Отчество");
                        collapseButton.setText("Collapse");
                    }
                }
            }

        });
    }

    private String collapseText() {
        return surname.getText() + " " + name.getText() + " " + lastname.getText();
    }
}

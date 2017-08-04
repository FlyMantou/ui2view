package com.myhuanghai.ui2view;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.ui.Messages;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class TestDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel p1;

    public TestDialog() {
        /*setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        contentPane.setPreferredSize(new java.awt.Dimension(400, 400));
        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        checkBox1.setText("1111");
        checkBox2.setText("222");*/

        initList();
      //  contentPane.getRootPane().add(frame);
        //list1.add

        frame.setVisible(true);
       /* buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);*/
    }

    JCheckListBox list;
    JFrame frame;
    String text = "";
    String defDp = "360";
    String UiWidth = "1080";
    private void initList() {
        String[] defaultDPArr = new String[]{"384", "392", "400", "410",
                "411", "450", "480", "533",
                "540", "592", "600", "640",
                "662", "720", "768", "800",
                "811", "820", "960", "961",
                "1024", "1280", "1365"};
        Font font = new Font("微软雅黑", Font.PLAIN, 14);

        frame = new JFrame("TWaver中文社区之Swing探秘");

        list = new JCheckListBox(defaultDPArr);

        // PropertiesComponent.getInstance().setValues() //可保存数字
        for (int x = 0; x < defaultDPArr.length; x++) {
            if (PropertiesComponent.getInstance().getValue(defaultDPArr[x], "1").equals("1"))
                ((JCheckBox)(list.getModel().getElementAt(x))).setSelected(true);
        }

        list.setFont(font);
        //frame.getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);
        //frame.getContentPane().add(new JScrollPane(list), GridLayoutManager.DESIGN_TIME_INSETS);
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // System.exit(0);
                if(!text.equals("")){
                    String[] strings = text.split("|");
                    for (int x = 0; x < defaultDPArr.length; x++) {//全部置为0
                        PropertiesComponent.getInstance().setValue(defaultDPArr[x],"0");
                    }
                    for (String str:strings){//将选中的置为1
                        PropertiesComponent.getInstance().setValue(str,"1");
                    }
                }
            }
        });
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        // frame.getContentPane().add(button,GridLayoutManager.DESIGN_TIME_INSETS);
        final JLabel label = new JLabel("当前没有选择。");
        label.setFont(font);
        list.getModel().addListDataListener(new ListDataListener() {

            public void intervalAdded(ListDataEvent e) {
            }

            public void intervalRemoved(ListDataEvent e) {
            }

            public void contentsChanged(ListDataEvent e) {
                if (list.getCheckedCount() == 0) {
                    label.setText("");
                } else {
                    text = "";
                    int[] indices = list.getCheckedIndices();
                    for (int i = 0; i < indices.length; i++) {
                        if(i!=indices.length-1){
                            text += ((JCheckListBox.CheckListBoxModel) list.getModel()).getItem(indices[i]).toString() + "|";

                        }else {
                            text += ((JCheckListBox.CheckListBoxModel) list.getModel()).getItem(indices[i]).toString();
                        }

                    }
                    label.setText(text);
                }
            }
        });
        frame.getContentPane().add(label, BorderLayout.NORTH);
        //frame.getContentPane().add(label,GridLayoutManager.DESIGN_TIME_INSETS);
        JLabel label1 = new JLabel("基于DP");
        label1.setText("基于DP");
        JTextField et1 = new JTextField();
        et1.setText("320");
        JLabel label2 = new JLabel("UI Width");
        label2.setText("UI width(px)");
        JTextField et2 = new JTextField();
        et2.setText("1080");
        JPanel contentPane = new JPanel();
        contentPane.add(new JScrollPane(list));
        contentPane.add(label1);
        contentPane.add(et1);
        contentPane.add(label2);
        contentPane.add(et2);

        frame.getContentPane().add(contentPane, BorderLayout.WEST);
        frame.setBounds(800, 300, 400, 400);
        frame.setVisible(true);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TestDialog dialog = new TestDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}

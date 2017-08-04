package com.myhuanghai.ui2view;

import com.intellij.ide.ui.UINumericRange;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ui2view implements Configurable{
    private JPanel panel1;
    private JCheckBox cb2;
    private JTextField et1;
    private JTextField et2;
    private JButton btn;
    private JCheckBox cb1;
    private JCheckBox cb3;
    private JCheckBox cb4;
    private JCheckBox cb5;
    private JCheckBox cb6;
    private JCheckBox cb7;
    private JCheckBox cb8;
    private JCheckBox cb9;
    private JCheckBox cb10;
    private JCheckBox cb11;
    private JCheckBox cb12;
    private JCheckBox cb13;
    private JCheckBox cb14;
    private JCheckBox cb15;
    private JCheckBox cb16;


    public ui2view() {
        panel1.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void saveData() {
        StringBuilder sb = new StringBuilder();
        sb.append(et1.getText()).append("\r\n")
                .append(et2.getText()).append("\r\n")
                .append("1").append("\r\n")
                .append(cb1.isSelected()?"1":"0").append("\r\n")
                .append(cb2.isSelected()?"1":"0").append("\r\n")
                .append(cb3.isSelected()?"1":"0").append("\r\n")
                .append(cb4.isSelected()?"1":"0").append("\r\n")
                .append(cb5.isSelected()?"1":"0").append("\r\n")
                .append(cb6.isSelected()?"1":"0").append("\r\n")
                .append(cb7.isSelected()?"1":"0").append("\r\n")
                .append(cb8.isSelected()?"1":"0").append("\r\n")
                .append(cb9.isSelected()?"1":"0").append("\r\n")
                .append(cb10.isSelected()?"1":"0").append("\r\n")
                .append(cb11.isSelected()?"1":"0").append("\r\n")
                .append(cb12.isSelected()?"1":"0").append("\r\n")
                .append(cb13.isSelected()?"1":"0").append("\r\n")
                .append(cb14.isSelected()?"1":"0").append("\r\n")
                .append(cb15.isSelected()?"1":"0").append("\r\n")
                .append(cb16.isSelected()?"1":"0").append("\r\n");

        File file = new File("/resources/1.txt");
        writeFile(file,sb.toString());
    }


    /**
     * 写入方法
     */

    public void writeFile(File file, String text) {

        PrintWriter out = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(file,false);
            out = new PrintWriter(fw);
            out.println(text);

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            out.close();
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fw = null;
            out = null;
        }



    }

    @Nls
    @Override
    public String getDisplayName() {
        return "ui2view-component";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, @NotNull String value) {
        return false;
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, int value, @NotNull UINumericRange range) {
        return false;
    }

    @Override
    public boolean isModified(@NotNull JToggleButton toggleButton, boolean value) {
        return false;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return panel1;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }

    @Override
    public void reset() {

    }

    @Override
    public void disposeUIResources() {

    }
}


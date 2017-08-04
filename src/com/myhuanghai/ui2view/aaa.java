package com.myhuanghai.ui2view;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;

public class aaa extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        String s = e.getData(DataKeys.FILE_TEXT);
       // Messages.showMessageDialog("FILE_TEXT:"+s, "hello", Messages.getInformationIcon());

    }
}

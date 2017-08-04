package com.myhuanghai.ui2view;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;
import org.apache.http.util.TextUtils;

public class MakeUi2View extends AnAction{

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (editor == null)
            return;
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取选中内容
        final String selectedText = selectionModel.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            //Utils.showNotification(project, MessageType.ERROR,"请选中生成内容");
            StatusBar statusBar = WindowManager.getInstance().getStatusBar(e.getProject());

            JBPopupFactory.getInstance()
                    .createHtmlTextBalloonBuilder("请选中生成内容", MessageType.ERROR, null)
                    .setFadeoutTime(7500)
                    .createBalloon()
                    .show(RelativePoint.getCenterOf(statusBar.getComponent()), Balloon.Position.atRight);
            return;
        }
        int i = 0;
        try {
            i = Integer.parseInt(selectionModel.getSelectedText().replace("x", ""));
        } catch (Exception e1) {
            return;
        }

        TestDialog dialog = new TestDialog();
       // dialog.setVisible(true);
       // Application application = ApplicationManager.getApplication();
       // MyComponent hello = application.getComponent(MyComponent.class);
        //hello.showHello();
       // hello.createComponent();
       // ui2view myView = new ui2view();
       // myView.getPanel1().setVisible(true);

       // DimenTool.Davn(e.getProject(), i);
        //CaretModel caretModel=editor.getCaretModel();
       // Messages.showMessageDialog("生成成功：@dimen/" + selectionModel.getSelectedText(), "hello", Messages.getInformationIcon());
        //Messages.showMessageDialog(e.getProject().getBaseDir().getPath(),"hello",Messages.getInformationIcon());

    }


}
